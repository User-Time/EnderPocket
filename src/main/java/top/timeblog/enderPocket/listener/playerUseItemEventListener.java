package top.timeblog.enderPocket.listener;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import  org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class playerUseItemEventListener implements Listener{

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        // 只处理主手（避免触发两次）
        if (event.getHand() != EquipmentSlot.HAND) return;

        // 必须是右键
        if (event.getAction() != Action.RIGHT_CLICK_AIR
                && event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        // 必须手里有东西
        ItemStack item = event.getItem();
        if (item == null || item.getType().isAir()) return;
        Player player =  event.getPlayer();
        if (item.getType() == Material.ENDER_CHEST){
            if (!player.isSneaking()){
                player.openInventory(player.getEnderChest());
                event.setCancelled(true);
            }
        };
    }


}
