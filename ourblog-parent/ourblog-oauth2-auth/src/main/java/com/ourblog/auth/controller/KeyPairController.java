package com.ourblog.auth.controller;

/**
 * @ClassName KeyPairController
 * @Description TODO
 * @Author Yudachi
 * @Date 2021/1/22 10:43
 * @Version 1.0
 */

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @Author yudachi
 * @Description 获取RSA公钥接口
 * @Date 2021/1/22 14:26
 * @Version 1.0
 **/
@RestController
public class KeyPairController {

    @Autowired
    private KeyPair keyPair;

    @GetMapping("/rsa/publicKey")
    public Map<String, Object> getKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

}
