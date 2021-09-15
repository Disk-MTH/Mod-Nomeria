package fr.diskmth.nomeria.utils.handlers;

import fr.diskmth.nomeria.objects.blocks.TopazeLadderBlock;
import fr.diskmth.nomeria.objects.items.StickItem;
import fr.diskmth.nomeria.objects.items.SwordItem;
import fr.diskmth.nomeria.utils.OldPvpUtils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EventHandler
{
    public static boolean isBlocking = false;

    @SideOnly(Side.CLIENT)
    public void onOpenGui(GuiOpenEvent event)
    {
        if(event.getGui() != null && event.getGui().getClass() == GuiMainMenu.class)
        {
            //event.setGui(new GuiCustomMainMenu());
        }

        if(event.getGui() != null && event.getGui().getClass() == GuiMultiplayer.class)
        {
            //event.setGui(new GuiCustomMainMenu());
        }
    }

    @SubscribeEvent
    public void OnLivingUpdate(LivingEvent.LivingUpdateEvent event)
    {
        if(event.getEntityLiving() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)event.getEntityLiving();
            Block block = player.world.getBlockState(new BlockPos(player.posX, player.posY, player.posZ)).getBlock();

            if(block instanceof TopazeLadderBlock)
            {
                if(!player.isSneaking())

                    if(player.moveForward > 0.0F)
                    {
                        player.move(MoverType.SELF, 0.0D, 0.3D, 0.0D);
                    }
                    else
                    {
                        player.move(MoverType.SELF, 0.0D, -0.3D, 0.0D);
                    }
            }
        }
    }

    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event)
    {
        if((event.getLeft().getItem() instanceof StickItem) && (event.getRight().getItem() instanceof ItemEnchantedBook))
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onPlayerTickClient(TickEvent.PlayerTickEvent event)
    {
        if(!event.player.getEntityWorld().isRemote)
        {
            if(((Minecraft.getMinecraft()).gameSettings.keyBindUseItem.isKeyDown() && OldPvpUtils.getItemType(event.player.getHeldItem(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD))
            {
                isBlocking = true;
            }

            else
            {
                isBlocking = false;
            }

            if(OldPvpUtils.getItemType(event.player.getHeldItem(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD)
            {
                event.player.getHeldItem(EnumHand.MAIN_HAND).getItem().addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()
                {
                    @Override
                    public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
                    {
                        return OldPvpUtils.convertIsBlocking(isBlocking);
                    }

                    public float call(ItemStack itemStack, @Nullable World world, @Nullable EntityLiving entityLiving)
                    {
                        return EventHandler.isBlocking ? 1.0F : 0.0F;
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public void onPlayerAttack(AttackEntityEvent event)
    {
        if((event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemSword || event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof SwordItem) && (event.getTarget() instanceof EntityLiving || event.getTarget() instanceof EntityPlayer))
        {
            event.setCanceled(true);
            event.getTarget().attackEntityFrom(DamageSource.causePlayerDamage(event.getEntityPlayer()), ((ItemSword)event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND).getItem()).getAttackDamage() + 4);
        }
    }

    @SubscribeEvent
    public void onEntityGotHurt(LivingHurtEvent event)
    {
        if(!event.getEntityLiving().getEntityWorld().isRemote && event.getEntity() instanceof EntityPlayer && isBlocking && OldPvpUtils.canBeBlocked(event.getSource()))
        {
            //event.setAmount(event.getAmount() / 2.0F);
            event.setCanceled(true);
        }
        else if(event.getSource().getTrueSource() instanceof EntityPlayer && OldPvpUtils.getItemType(((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand()) == OldPvpUtils.itemType.AXE)
        {
            event.setAmount(OldPvpUtils.getOldDamages(((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand()));
        }
    }

    @SubscribeEvent
    public void onPlayerTickServer(TickEvent.PlayerTickEvent event)
    {
        if(!event.player.getEntityWorld().isRemote)
        {
            IAttributeInstance attackSpeed = event.player.getAttributeMap().getAttributeInstanceByName("generic.attackSpeed");

            if(attackSpeed != null && attackSpeed.getBaseValue() != 1024.0D)
            {
                attackSpeed.setBaseValue(1024.0D);
            }

            OldPvpUtils.removeAllCooldowns(event.player);
        }
    }
}