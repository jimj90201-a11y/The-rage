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

    public static final RegistryObject<SoundEvent> TH =
            SOUND_EVENTS.register("th",
                    () -> SoundEvent.createVariableRangeEvent(
                            new ResourceLocation(TheRage.MOD_ID, "th")));

}
