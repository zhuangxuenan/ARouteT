package com.king.commonlib.utils.encryption;

import com.king.commonlib.utils.AppLogMessageMgr;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密/解密工具
 * @author chengquanyong
 * @date 2018年2月27日
 * ios对应的加密解密参考http://blog.csdn.net/coooliang/article/details/50419201
 */
public class EncryptUtil {
	/**
	 * DES加密，输入内容将被UTF-8编码后进行加密，密钥长度不要大于8位
	 * 
	 * @param key 密钥
	 * @param content 明文
	 * @return 密文
	 */
	public static String encryptByDES(String key, String content) {
		if ((key == null) || (content == null))
			return null;

		// 生成密钥，密钥长度限定为8位，如果超出8位取前8位
		byte[] tmpBytes;
		try {
			tmpBytes = key.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			AppLogMessageMgr.e("不支持的字符集");
			return null;
		}
		byte[] keyBytes = new byte[8];
		for (int i = 0; i < tmpBytes.length && i < keyBytes.length; i++) {
			keyBytes[i] = tmpBytes[i];
		}
		// DES加密成为密文
		try {
			Key k = new SecretKeySpec(keyBytes, "DES");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, k);
			byte[] output = cipher.doFinal(content.getBytes("UTF-8"));
			return ConvertUtil.bytesToHexString(output);
		} catch (Exception e) {
			AppLogMessageMgr.e("DES加密失败");
		}
		return null;
	}

	/**
	 * DES解密，输入内容是密文，密钥长度不要大于8位
	 * 
	 * @param key 密钥
	 * @param cipherText 密文
	 * @return 明文
	 */
	public static String decryptByDES(String key, String cipherText) {
		if ((key == null) || (cipherText == null))
			return null;

		// 生成密钥，密钥长度限定为8位，如果超出8位取前8位
		byte[] tmpBytes;
		try {
			tmpBytes = key.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			AppLogMessageMgr.e("不支持的字符集");
			return null;
		}
		byte[] keyBytes = new byte[8];
		for (int i = 0; i < tmpBytes.length && i < keyBytes.length; i++) {
			keyBytes[i] = tmpBytes[i];
		}
		// DES解密成为明文
		try {
			Key k = new SecretKeySpec(keyBytes, "DES");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, k);
			byte[] output = cipher.doFinal(ConvertUtil.hexStringToBytes(cipherText));
			return new String(output, "UTF-8");
		} catch (Exception e) {
			AppLogMessageMgr.e("DES解密失败");
		}
		return null;
	}
	
}
