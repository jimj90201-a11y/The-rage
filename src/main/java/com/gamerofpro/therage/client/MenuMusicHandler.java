package com.gamerofpro.therage.client;

import com.gamerofpro.therage.registry.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class MenuMusicHandler {

    private static boolean playing = false;

    @SubscribeEvent
    public static void onScreenOpen(ScreenEvent.Opening event) {
        Minecraft mc = Minecraft.getInstance();

        if (event.getScreen() instanceof TitleScreen) {
            if (!playing) {
                mc.getSoundManager().play(
                        SimpleSoundInstance.forUI(ModSounds.TH.get(), 1.0F)
                );
                playing = true;
            }
        } else {
            playing = false;
        }
    }
}
