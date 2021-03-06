package com.sorakylin.sejwt.cryptography.impl;


import com.sorakylin.sejwt.cryptography.SymmetricCodec;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * DES3 对称加密
 *
 * @author pyb
 * @time 2019-11-24
 */
public class DESedeCodec extends SymmetricCodec {

    public DESedeCodec() {
        super("DESede/ECB/PKCS5PADDING");
    }

    @Override
    protected Key getKey(String secret) {
        KeyGenerator kgen = null;
        SecureRandom random = null;
        try {
            kgen = KeyGenerator.getInstance("DESede");
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        random.setSeed(secret.getBytes());
        kgen.init(112, random);
        Key key = kgen.generateKey();
        return key;
    }

}
