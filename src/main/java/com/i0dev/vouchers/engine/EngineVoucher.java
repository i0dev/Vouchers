package com.i0dev.vouchers.engine;

import com.i0dev.vouchers.entity.MConf;
import com.i0dev.vouchers.entity.MLang;
import com.i0dev.vouchers.entity.Voucher;
import com.i0dev.vouchers.util.ItemBuilder;
import com.i0dev.vouchers.util.Pair;
import com.i0dev.vouchers.util.Utils;
import com.massivecraft.massivecore.Engine;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EngineVoucher extends Engine {

    private static final EngineVoucher i = new EngineVoucher();

    public static EngineVoucher get() {
        return i;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        ItemStack itemInHand = e.getItem();
        Action action = e.getAction();
        Player player = e.getPlayer();
        if (action.equals(Action.LEFT_CLICK_BLOCK)) return;
        if (action.equals(Action.LEFT_CLICK_AIR)) return;
        if (itemInHand == null) return;

        Voucher voucher = Voucher.get(ItemBuilder.getPDCValue(itemInHand, "voucher-id"));
        if (voucher == null) return;

        e.setCancelled(true);

        if ((!player.isOp() && MConf.get().isOpsBypassPermissionCheck()) && player.hasPermission(voucher.getRefuseUseIfHasPermission())) {
            player.sendMessage(Utils.prefixAndColor(MLang.get().failedPermission,
                    new Pair<>("%voucher%", voucher.getDisplayName())
            ));
            return;
        }

        Utils.runCommands(voucher.getCommands(), player);

        player.sendMessage(Utils.prefixAndColor(MLang.get().usedVoucher,
                new Pair<>("%voucher%", voucher.getDisplayName())
        ));

        player.playSound(player.getLocation(), voucher.getSound(), 1, 1);

        itemInHand.setAmount(itemInHand.getAmount() - 1);
        e.getPlayer().updateInventory();
    }

}
