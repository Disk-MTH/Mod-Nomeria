package fr.diskmth.nomeria.objects.items;

import fr.diskmth.nomeria.Main;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class StickItem extends Item implements IHasModel
{
    private String typeOfstick = "";

    public StickItem(String name, int MaxDamage)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        this.typeOfstick = name;
        setMaxDamage(MaxDamage - 1);
        setCreativeTab(null);
        ItemsInit.ITEMS.add(this);
    }

    @SubscribeEvent
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if(typeOfstick.contains("heal"))
        {
            ItemStack stack = playerIn.getHeldItem(EnumHand.MAIN_HAND);
            if(!worldIn.isRemote)
            {
                if(playerIn.getHealth() == 20)
                {
                    return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
                }
                else
                {
                    playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 2));
                    stack.damageItem(1, playerIn);
                    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
                }
            }
            else
            {
                return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
            }

        }

        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }

    @Override
    public boolean isEnchantable(ItemStack stack)
    {
        return false;
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
