package utils;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RsaUtil
 * Created by yangkangwei on 2020/01/15
 */
public class RsaUtil {

    private static Logger logger = LoggerFactory.getLogger(RsaUtil.class);

    // 公钥
    public static String publicKey =
            (
                    "-----BEGIN PUBLIC KEY-----"
                            + "\\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDVOzscmouVOyD517JGJOM1igg"
                            + "\\nHucRT/iNcmqwZkTk18vdteYli3ExoWZrhdoKyAcuqLk4G/njB8Njxe1A9Qhaa9eA"
                            + "\\nndcq90GHAY2a1jyFufa0hD9kr7kCcaqMnCRC61yz6TR2vGzwE1t08SryyOeE15BC"
                            + "\\ntTGp2HOqTkr8/MDwHwIDAQAB"
                            + "\\n-----END PUBLIC KEY-----"
            );

    // 私钥
    public static String privateKey =
            (
                    "-----BEGIN RSA PRIVATE KEY-----"
                            + "\\nMIICWwIBAAKBgQDDVOzscmouVOyD517JGJOM1iggHucRT/iNcmqwZkTk18vdteYl"
                            + "\\ni3ExoWZrhdoKyAcuqLk4G/njB8Njxe1A9Qhaa9eAndcq90GHAY2a1jyFufa0hD9k"
                            + "\\nr7kCcaqMnCRC61yz6TR2vGzwE1t08SryyOeE15BCtTGp2HOqTkr8/MDwHwIDAQAB"
                            + "\\nAoGABQYKn9wjcfSaLpxFOkvJA67AUm8pBy9014JxTv8aV35bTmTuudl3vEyH200S"
                            + "\\negOB98e8F77UcuvQsSC2hNyobctlEBwPOdET3711fmHbFvYbHRn3QkRp8oGqwgcb"
                            + "\\nL0LRqz1bw7p9aAJVfC2sncLtrMcDj1b9SJv9S9Xoqn+7D90CQQDYaeIgAxQKLTpY"
                            + "\\nrc/I51VhrKTsyWnohb4fGhp+9Ta4EyLsOETz6W9Hv0SsK6lztDKVwwacn3GLVXKh"
                            + "\\n8QZUKcFVAkEA5w/UiySuw4KYP0eNyjRVc2OfL4SGaLIthcjquvVtjqf0AyLCfWMA"
                            + "\\nCZRdWtLex5QdrTVMHLquk8IgZ2VeaSt7owJAdxX0z4bCHUN8CtZCM5xQmHnnG0FO"
                            + "\\nHRyTXQwBLoGDBdHJ8tCX6Nw4VvPCNzejfD7ZYx25YrA+S9zOQpydzexYLQJAUNRa"
                            + "\\n1+oXMNGojMptMYUpN1psP2Uu18Us45YrdweQMc1TMR2hx9cwFinOlo0Z3dtUnlj8"
                            + "\\nrTgpBgts5n6xjjzl3QJAD8MAFVqq5HyUysEUyuohIO00trFGeuJTyLQx4oVKyEgY"
                            + "\\nuWYVDjkEryn+Gsslg3h9WxULeGECMsb4NO4qHLJrgA=="
                            + "\\n-----END RSA PRIVATE KEY-----"
            );

    /**
     * RSA公钥加密
     * Created by yangkangwei on 2020/01/15
     */
    public static String encrypt(String plainStr, String publicKeyStr) throws Exception {
        logger.info("-----RSA公钥加密-----");

        String cipherStr = null;

        byte[] plainStrByte = plainStr.getBytes("UTF-8");
        byte[] publicKeyStrByte = Base64.decodeBase64(publicKeyStr);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKeyStrByte));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        cipherStr = Base64.encodeBase64String(cipher.doFinal(plainStrByte));

        return cipherStr;
    }

    /**
     * RSA私钥解密
     * Created by yangkangwei on 2020/01/15
     */
    public static String decrypt(String cipherStr, String privateKeyStr) throws Exception {
        logger.info("-----RSA私钥解密-----");

        String plainStr = null;

        byte[] cipherStrByte = Base64.decodeBase64(cipherStr.getBytes("UTF-8"));
        byte[] privateKeyStrByte = Base64.decodeBase64(privateKeyStr);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKeyStrByte));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        plainStr = new String(cipher.doFinal(cipherStrByte));

        return plainStr;
    }

	public static void main(String[] args) throws Exception {
		String cipherStr = "BI3wgrIN85KyGKejm9TiUnX7k7T2ZJaT1J4GEMVMEbK3UuEe5q8eKThZ674wP+Pzzy7Wb5LsUK8yaoijivOxpP1sW4rFlGb9wEHoI6uhxC7nwqMWT66LwjdF7EfQrM9xPS0yp3Ad1LwXzOZEfYfZwFAoxDt22tU3IF0f/J0cmiM=";
		String plainStr = RsaUtil.decrypt(cipherStr, RsaUtil.privateKey);
		System.out.println(plainStr);
	}
}
