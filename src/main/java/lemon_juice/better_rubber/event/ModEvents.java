package lemon_juice.better_rubber.event;

import lemon_juice.better_rubber.item.ModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.EventPriority;

public class ModEvents {

    public static void registerEvents(){
        MinecraftForge.EVENT_BUS.<LivingFallEvent>addListener(EventPriority.LOW, event -> {
            final ItemStack boots = event.getEntity().getItemBySlot(EquipmentSlot.FEET);

            if(ModItems.RUBBER_BOOTS.orElseThrow(IllegalStateException::new).equals(boots.getItem()))
                event.setDamageMultiplier(0.0F);
        });
    }

}
