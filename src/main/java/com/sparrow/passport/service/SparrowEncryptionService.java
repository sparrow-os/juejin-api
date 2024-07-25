package com.sparrow.passport.service;

import com.sparrow.cryptogram.Base64;
import com.sparrow.cryptogram.MessageSignature;
import com.sparrow.cryptogram.ThreeDES;

import javax.inject.Named;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Named("encryptionService")
public class SparrowEncryptionService implements EncryptionService {
    @Override public String encryptPassword(String password) {
        return MessageSignature.getInstance().md5(password);
    }

    @Override public String base64Encode(String originCode) {
        return Base64.encodeBytes(originCode.getBytes(StandardCharsets.US_ASCII));
    }

    @Override public String base64Decode(String base64) {
        try {
            return new String(Base64.decode(base64), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            return null;
        }
    }

    @Override public String generateToken(String originCode, String originPassword) {
        return ThreeDES.getInstance().encrypt(originPassword, originCode);
    }

    @Override public String decryptToken(String token, String originPassword) {
        return ThreeDES.getInstance().decrypt(originPassword, token);
    }
}
