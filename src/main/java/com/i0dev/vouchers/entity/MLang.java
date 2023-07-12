package com.i0dev.vouchers.entity;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;

@EditorName("config")
public class MLang extends Entity<MLang> {

    protected static transient MLang i;

    public static MLang get() {
        return i;
    }

    public String prefix = "&8[&cVouchers&8]&7";
    public String gaveVoucher = "%prefix% &7You have given &c%player% &7a %voucher% voucher.";
    public String usedVoucher = "%prefix% &7You have used a %voucher% voucher.";
    public String failedPermission = "%prefix% &7It looks like you already have the contents of this voucher.";

    @Override
    public MLang load(MLang that) {
        super.load(that);
        return this;
    }
}
