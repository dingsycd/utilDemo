package utils;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.crypto.util.PublicKeyFactory;

import javax.crypto.Cipher;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Base64;

public class RsaUtils {

//    public static String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
//            "MIICWwIBAAKBgQDDVOzscmouVOyD517JGJOM1iggHucRT/iNcmqwZkTk18vdteYl\n" +
//            "i3ExoWZrhdoKyAcuqLk4G/njB8Njxe1A9Qhaa9eAndcq90GHAY2a1jyFufa0hD9k\n" +
//            "r7kCcaqMnCRC61yz6TR2vGzwE1t08SryyOeE15BCtTGp2HOqTkr8/MDwHwIDAQAB\n" +
//            "AoGABQYKn9wjcfSaLpxFOkvJA67AUm8pBy9014JxTv8aV35bTmTuudl3vEyH200S\n" +
//            "egOB98e8F77UcuvQsSC2hNyobctlEBwPOdET3711fmHbFvYbHRn3QkRp8oGqwgcb\n" +
//            "L0LRqz1bw7p9aAJVfC2sncLtrMcDj1b9SJv9S9Xoqn+7D90CQQDYaeIgAxQKLTpY\n" +
//            "rc/I51VhrKTsyWnohb4fGhp+9Ta4EyLsOETz6W9Hv0SsK6lztDKVwwacn3GLVXKh\n" +
//            "8QZUKcFVAkEA5w/UiySuw4KYP0eNyjRVc2OfL4SGaLIthcjquvVtjqf0AyLCfWMA\n" +
//            "CZRdWtLex5QdrTVMHLquk8IgZ2VeaSt7owJAdxX0z4bCHUN8CtZCM5xQmHnnG0FO\n" +
//            "HRyTXQwBLoGDBdHJ8tCX6Nw4VvPCNzejfD7ZYx25YrA+S9zOQpydzexYLQJAUNRa\n" +
//            "1+oXMNGojMptMYUpN1psP2Uu18Us45YrdweQMc1TMR2hx9cwFinOlo0Z3dtUnlj8\n" +
//            "rTgpBgts5n6xjjzl3QJAD8MAFVqq5HyUysEUyuohIO00trFGeuJTyLQx4oVKyEgY\n" +
//            "uWYVDjkEryn+Gsslg3h9WxULeGECMsb4NO4qHLJrgA==\n" +
//            " -----END RSA PRIVATE KEY-----";


    public static String privateKey = "------BEGIN RSA PRIVATE KEY----\n" +
            "MIICWwIBAAKBgQDDVOzscmouVOyD517JGJOM1iggHucRT/iNcmqwZkTk18vdteYl\n" +
            "i3ExoWZrhdoKyAcuqLk4G/njB8Njxe1A9Qhaa9eAndcq90GHAY2a1jyFufa0hD9k\n" +
            "r7kCcaqMnCRC61yz6TR2vGzwE1t08SryyOeE15BCtTGp2HOqTkr8/MDwHwIDAQAB\n" +
            "AoGABQYKn9wjcfSaLpxFOkvJA67AUm8pBy9014JxTv8aV35bTmTuudl3vEyH200S\n" +
            "egOB98e8F77UcuvQsSC2hNyobctlEBwPOdET3711fmHbFvYbHRn3QkRp8oGqwgcb\n" +
            "L0LRqz1bw7p9aAJVfC2sncLtrMcDj1b9SJv9S9Xoqn+7D90CQQDYaeIgAxQKLTpY\n" +
            "rc/I51VhrKTsyWnohb4fGhp+9Ta4EyLsOETz6W9Hv0SsK6lztDKVwwacn3GLVXKh\n" +
            "8QZUKcFVAkEA5w/UiySuw4KYP0eNyjRVc2OfL4SGaLIthcjquvVtjqf0AyLCfWMA\n" +
            "CZRdWtLex5QdrTVMHLquk8IgZ2VeaSt7owJAdxX0z4bCHUN8CtZCM5xQmHnnG0FO\n" +
            "HRyTXQwBLoGDBdHJ8tCX6Nw4VvPCNzejfD7ZYx25YrA+S9zOQpydzexYLQJAUNRa\n" +
            "1+oXMNGojMptMYUpN1psP2Uu18Us45YrdweQMc1TMR2hx9cwFinOlo0Z3dtUnlj8\n" +
            "rTgpBgts5n6xjjzl3QJAD8MAFVqq5HyUysEUyuohIO00trFGeuJTyLQx4oVKyEgY\n" +
            "uWYVDjkEryn+Gsslg3h9WxULeGECMsb4NO4qHLJrgA==\n" +
            "-----END RSA PRIVATE KEY-----";


    //加密
    public static String encryptData(String data, String publicInfoStr) throws IOException, InvalidCipherTextException {

        final Base64.Decoder decoder64 = Base64.getDecoder();
        final Base64.Encoder encoder64 = Base64.getEncoder();

        AsymmetricBlockCipher cipher = new RSAEngine();


        byte[] publicInfoBytes = decoder64.decode(publicInfoStr);

        ASN1Object pubKeyObj = ASN1Primitive.fromByteArray(publicInfoBytes); //这里也可以从流中读取，从本地导入
        AsymmetricKeyParameter pubKey = PublicKeyFactory.createKey(SubjectPublicKeyInfo.getInstance(pubKeyObj));

        cipher.init(true, pubKey);//true表示加密
        byte[] encryptDataBytes = cipher.processBlock(data.getBytes("utf-8")
                , 0, data.getBytes("utf-8").length);
        String encryptData = encoder64.encodeToString(encryptDataBytes);
        return encryptData;
    }

    //解密
    public static String decryptData(String data, String privateInfoStr) throws IOException, InvalidCipherTextException {
//        final Base64.Decoder decoder64 = Base64.getDecoder();
//
//        AsymmetricBlockCipher cipher = new RSAEngine();
//        byte[] encryptDataBytes = decoder64.decode(data);
//
//        byte[] privateInfoByte = decoder64.decode(privateInfoStr);

        AsymmetricBlockCipher cipher = new RSAEngine();
        byte[] encryptDataBytes = org.apache.commons.codec.binary.Base64.decodeBase64(data.getBytes("UTF-8"));
        byte[] privateInfoByte = org.apache.commons.codec.binary.Base64.decodeBase64(privateInfoStr);
        AsymmetricKeyParameter priKey = PrivateKeyFactory.createKey(privateInfoByte);
        cipher.init(false, priKey);//false表示解密

        byte[] decryptDataBytes = cipher.processBlock(encryptDataBytes, 0, encryptDataBytes.length);


        return new String(decryptDataBytes, "utf-8");
    }




    public static void main(String[] args) throws Exception {
        String cipherStr = "BI3wgrIN85KyGKejm9TiUnX7k7T2ZJaT1J4GEMVMEbK3UuEe5q8eKThZ674wP+Pzzy7Wb5LsUK8yaoijivOxpP1sW4rFlGb9wEHoI6uhxC7nwqMWT66LwjdF7EfQrM9xPS0yp3Ad1LwXzOZEfYfZwFAoxDt22tU3IF0f/J0cmiM=";
        String plainStr = RsaUtils.decryptData(cipherStr, RsaUtils.privateKey.replace("\n", "").replace("-----END RSA PRIVATE KEY-----", "").replace("------BEGIN RSA PRIVATE KEY----", ""));
        System.out.println(plainStr);
    }
}
