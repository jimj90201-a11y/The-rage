package com.gamerofpro.therage.client;

import com.gamerofpro.therage.registry.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "therage", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MenuMusicHandler {

    private static boolean playing = false;

    @SubscribeEvent
    public static void onScreenOpen(ScreenEvent.Opening event) {
        Minecraft mc = Minecraft.getInstance();

        // Start music on title screen
        if (event.getScreen() instanceof TitleScreen && !playing) {
            playing = true;

            mc.getSoundManager().play(
                    new SimpleSoundInstance(
                            ModSounds.MENU_THEME.get().getLocation(),
                            SoundSource.MUSIC,
                            1.0F,
                            1.0F,
                            RandomSource.create(),
                            true,
                            0,
                            SoundInstance.Attenuation.NONE,
                            0.0,
                            0.0,
                            0.0,
                            false
                    )
            );
        }

        // Stop only after entering a world
        if (playing && mc.level != null) {
            playing = false;
            mc.getSoundManager().stop(
                    ModSounds.MENU_THEME.get().getLocation(),
                    SoundSource.MUSIC
            );
        }
    }
                        }
