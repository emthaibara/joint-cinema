package cn.scbc.servicevideouploadapi.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */

public class ChunkIndexMap {

    private static final Map<String,Integer> CHUNK_MAP = new ConcurrentHashMap<>(256);

    public static void add(String number){
        CHUNK_MAP.put(number, CHUNK_MAP.get(number)+1);
    }

    public static Integer get(String number){
        return CHUNK_MAP.get(number);
    }

    public static void remove(String number){
        CHUNK_MAP.remove(number);
    }
}
