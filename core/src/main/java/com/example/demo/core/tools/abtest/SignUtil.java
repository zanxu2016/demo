package com.example.demo.core.tools.abtest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignUtil {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String sec = "24v223250r6EFWCqi534354vCXAtnbuusKwn";
        String a = "_hupu_themis_up_up_";
        long ts = System.currentTimeMillis();

        String sign = sec + a +ts;

//        String md5 = Hex.encodeHexString(MessageDigest.getInstance("MD5").digest(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(sign)));
        String md5 = null;
        String header = md5 + "_" + ts;
        System.out.println(header);
    }
}
