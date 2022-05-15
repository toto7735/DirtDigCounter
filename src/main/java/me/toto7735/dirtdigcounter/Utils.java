package me.toto7735.dirtdigcounter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Utils {

    private static Map<UUID, Integer> count = new HashMap<>();

    public static Map<UUID, Integer> getDirtCounts() {
        return count;
    }

    public static void addDirtCount(UUID uuid, int amount) {
        count.putIfAbsent(uuid, 0);
        count.put(uuid, getDirtCount(uuid) + amount);
    }

    public static int getDirtCount(UUID uuid) {
        count.putIfAbsent(uuid, 0);
        return count.get(uuid);
    }

    public static void setup(Map<UUID, Integer> map) {
        count = map;
    }

}
