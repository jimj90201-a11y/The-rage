package com.gamerofpro.therage.registry;

import com.gamerofpro.therage.TheRage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TheRage.MOD_ID);

    public static final RegistryObject<SoundEvent> MENU_THEME =
            SOUND_EVENTS.register("menu_theme",
                    () -> SoundEvent.createVariableRangeEvent(
                            new ResourceLocation(TheRage.MOD_ID, "menu_theme")));
}
