package com.i0dev.vouchers.entity;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;
import lombok.Getter;
import org.bukkit.Material;

import java.util.List;

@Getter
@EditorName("config")
public class MConf extends Entity<MConf> {

    protected static transient MConf i;

    public static MConf get() {
        return i;
    }

    public List<String> aliases = MUtil.list("vouchers", "fragments");

    boolean OpsBypassPermissionCheck = true;

    @Override
    public MConf load(MConf that) {
        super.load(that);
        return this;
    }

}
