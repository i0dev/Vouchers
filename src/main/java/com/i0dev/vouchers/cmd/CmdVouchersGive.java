package com.i0dev.vouchers.cmd;

import com.i0dev.vouchers.cmd.type.TypeVoucher;
import com.i0dev.vouchers.entity.MLang;
import com.i0dev.vouchers.entity.Voucher;
import com.i0dev.vouchers.util.Pair;
import com.i0dev.vouchers.util.Utils;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.Visibility;
import com.massivecraft.massivecore.command.type.primitive.TypeInteger;
import com.massivecraft.massivecore.command.type.sender.TypePlayer;
import org.bukkit.entity.Player;

public class CmdVouchersGive extends VouchersCommand {

    public CmdVouchersGive() {
        this.addParameter(TypePlayer.get(), "player");
        this.addParameter(TypeVoucher.get(), "voucher");
        this.addParameter(TypeInteger.get(), "amount", "1");
        this.setVisibility(Visibility.SECRET);
    }

    @Override
    public void perform() throws MassiveException {
        Player player = this.readArg();
        Voucher voucher = this.readArg();
        int amount = this.readArg(1);

        player.getInventory().addItem(voucher.getItemStack(amount));
        msg(Utils.prefixAndColor(MLang.get().gaveVoucher,
                new Pair<>("%voucher%", voucher.getDisplayName()),
                new Pair<>("%player%", player.getName())
        ));

    }
}
