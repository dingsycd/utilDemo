package utils;

import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateKeySpec;

public class HaiyangRSA {


	public static String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
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

	public static String rsaDecode(String data) throws Exception {
		String pk = privateKey.replaceAll("-----BEGIN RSA PRIVATE KEY-----", "").replaceAll("-----END RSA PRIVATE KEY-----", "").replaceAll("\n", "");

		System.out.println(pk);
		RSAPrivateKey rsaPrivateKey = RSAPrivateKey.getInstance(
				org.bouncycastle.util.encoders.Base64.decode(pk));

		RSAPrivateKeySpec privateKey = new RSAPrivateKeySpec(rsaPrivateKey.getModulus(), rsaPrivateKey.getPrivateExponent());

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		PrivateKey privateKey1 = keyFactory.generatePrivate(privateKey);

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", new org.bouncycastle.jce.provider.BouncyCastleProvider());
		cipher.init(Cipher.DECRYPT_MODE, privateKey1);

		byte b[] = cipher.doFinal(Base64.decode(data));

		return new String(b);
	}


	public static void main(String[] args) throws Exception {
		String cipherStr = "BI3wgrIN85KyGKejm9TiUnX7k7T2ZJaT1J4GEMVMEbK3UuEe5q8eKThZ674wP+Pzzy7Wb5LsUK8yaoijivOxpP1sW4rFlGb9wEHoI6uhxC7nwqMWT66LwjdF7EfQrM9xPS0yp3Ad1LwXzOZEfYfZwFAoxDt22tU3IF0f/J0cmiM=";
		String plainStr = HaiyangRSA.rsaDecode(cipherStr);
		System.out.println(plainStr);
	}
}
