package cn.scbc.servicevideouploadapi.utils;

import java.util.HashMap;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */

public class ChunkIndexMap {

    private static final HashMap<String,Integer> CHUNK_MAP = new HashMap<>(256);

    public synchronized void add(String number){
        CHUNK_MAP.put(number, CHUNK_MAP.get(number)+1);
    }

    public void remove(String number){
        CHUNK_MAP.remove(number);
    }

}
