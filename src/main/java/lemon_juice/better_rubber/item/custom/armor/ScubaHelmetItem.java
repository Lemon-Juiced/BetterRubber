package lemon_juice.better_rubber.item.custom.armor;

import lemon_juice.better_rubber.item.custom.tiers.BetterRubberArmorMaterials;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ScubaHelmetItem extends ArmorItem {
    public ScubaHelmetItem(Properties properties) {
        super(BetterRubberArmorMaterials.RUBBER, ArmorItem.Type.HELMET, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!player.isCreative() && !player.isSpectator()) {
            if (!player.isEyeInFluid(FluidTags.WATER)) {
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0, false, false, true));
            }
        }
        super.onArmorTick(stack, level, player);
    }
}
