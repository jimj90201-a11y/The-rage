package com.gamerofpro.therage.manager;

import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HeadlessManager {

    private static final int EVENT_INTERVAL = 6000; // 5 minutes
    private static final int EVENT_DURATION = 600;  // 30 seconds

    private static final Map<UUID, Integer> timers = new HashMap<>();
    private static final Map<UUID, Integer> headlessTimers = new HashMap<>();

    public static void tick(Player player) {
        UUID uuid = player.getUUID();

        int timer = timers.getOrDefault(uuid, 0) + 1;
        timers.put(uuid, timer);

        if (timer >= EVENT_INTERVAL) {
            timers.put(uuid, 0);
            headlessTimers.put(uuid, EVENT_DURATION);
        }

        if (headlessTimers.containsKey(uuid)) {
            int remaining = headlessTimers.get(uuid) - 1;

            if (remaining <= 0) {
                headlessTimers.remove(uuid);
            } else {
                headlessTimers.put(uuid, remaining);
            }
        }
    }

    public static boolean isHeadless(Player player) {
        return headlessTimers.containsKey(player.getUUID());
    }
          }
