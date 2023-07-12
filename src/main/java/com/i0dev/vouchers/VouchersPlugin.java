package com.i0dev.vouchers;

import com.i0dev.vouchers.entity.MConfColl;
import com.i0dev.vouchers.entity.MLangColl;
import com.i0dev.vouchers.entity.Voucher;
import com.i0dev.vouchers.entity.VoucherColl;
import com.massivecraft.massivecore.MassivePlugin;
import com.massivecraft.massivecore.collections.MassiveList;

import java.util.List;

public class VouchersPlugin extends MassivePlugin {

    private static VouchersPlugin i;

    public VouchersPlugin() {
        VouchersPlugin.i = this;
    }

    public static VouchersPlugin get() {
        return i;
    }

    @Override
    public void onEnableInner() {
        this.activateAuto();
    }


    @Override
    public List<Class<?>> getClassesActiveColls() {
        return new MassiveList<>(
                MConfColl.class,
                MLangColl.class,
                VoucherColl.class
        );
    }

    @Override
    public void onEnablePost() {
        super.onEnablePost();
        Voucher.example();
    }

}