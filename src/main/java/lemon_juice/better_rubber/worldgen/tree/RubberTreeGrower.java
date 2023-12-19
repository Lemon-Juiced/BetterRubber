package lemon_juice.better_rubber.worldgen.tree;

import lemon_juice.better_rubber.worldgen.BetterRubberConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class RubberTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource source, boolean b) {
        return BetterRubberConfiguredFeatures.RUBBER_KEY;
    }
}
