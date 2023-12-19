package lemon_juice.better_rubber.item.custom.armor;

import lemon_juice.better_rubber.item.custom.tiers.BetterRubberArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class ScubaChestplateItem extends ArmorItem {
    public ScubaChestplateItem(Properties properties) {
        super(BetterRubberArmorMaterials.RUBBER, ArmorItem.Type.CHESTPLATE, properties);
    }

    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(hasCorrectArmorOn(player)){
            if(hasFullSetOfArmorOn(player)){
                if(!player.isCreative() && !player.isSpectator()) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false, true));
                }
            }
        }
    }

    private boolean hasFullSetOfArmorOn(Player player){
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(Player player){
        ArmorMaterial material = BetterRubberArmorMaterials.RUBBER;
        if(player.getInventory().getArmor(0).getItem() == Items.AIR ||
                (player.getInventory().getArmor(1).getItem() == Items.AIR) ||
                (player.getInventory().getArmor(2).getItem() == Items.AIR) ||
                (player.getInventory().getArmor(3).getItem() == Items.AIR)){
            return false; //Stop before hitting below and getting ClassCastException
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
