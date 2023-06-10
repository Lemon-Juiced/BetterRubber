package lemon_juice.better_rubber.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FullRubberWoodBlock extends RubberWoodBlock{
    public FullRubberWoodBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter p_49817_, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("tooltip.better_rubber.full").withStyle(ChatFormatting.YELLOW));
        super.appendHoverText(itemStack, p_49817_, components, flag);
    }
}
