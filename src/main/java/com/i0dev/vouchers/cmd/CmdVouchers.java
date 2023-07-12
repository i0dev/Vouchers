package com.i0dev.vouchers.cmd;

import com.i0dev.vouchers.Perm;
import com.i0dev.vouchers.VouchersPlugin;
import com.i0dev.vouchers.entity.MConf;
import com.massivecraft.massivecore.command.MassiveCommandVersion;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;

import java.util.List;

public class CmdVouchers extends VouchersCommand {

    private static CmdVouchers i = new CmdVouchers();

    public static CmdVouchers get() {
        return i;
    }

    public CmdVouchersGive cmdVouchersGive = new CmdVouchersGive();
    public MassiveCommandVersion cmdFactionsVersion = new MassiveCommandVersion(VouchersPlugin.get()).setAliases("v", "version").addRequirements(RequirementHasPerm.get(Perm.VERSION));

    @Override
    public List<String> getAliases() {
        return MConf.get().aliases;
    }

}
