package com.gamerofpro.therage;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(TheRage.MOD_ID)
public class TheRage {

    public static final String MOD_ID = "therage";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TheRage() {
        LOGGER.info("The Rage has awakened...");
    }
}
