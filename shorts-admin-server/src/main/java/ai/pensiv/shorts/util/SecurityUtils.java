package ai.pensiv.shorts.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class SecurityUtils {
    public static String randomSha256Hex(int size){
        return DigestUtils.sha256Hex(UUID.randomUUID().toString()).substring(0, size);
    }
}
