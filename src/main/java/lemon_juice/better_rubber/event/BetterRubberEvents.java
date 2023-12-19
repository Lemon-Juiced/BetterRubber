package lemon_juice.better_rubber.event;

import lemon_juice.better_rubber.item.BetterRubberItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

public class BetterRubberEvents {

    public static void registerEvents(){
        NeoForge.EVENT_BUS.<LivingFallEvent>addListener(EventPriority.LOW, event -> {
            final ItemStack boots = event.getEntity().getItemBySlot(EquipmentSlot.FEET);

            if(BetterRubberItems.RUBBER_BOOTS.get().equals(boots.getItem()))
                event.setDamageMultiplier(0.0F);
        });
    }

}
