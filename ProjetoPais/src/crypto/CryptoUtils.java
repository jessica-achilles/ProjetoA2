package crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * A utility class that encrypts or decrypts a file.
 * 
 * @author www.codejava.net
 *
 */
public class CryptoUtils {
	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES";

	public static void encrypt(String key, File inputFile, File outputFile)
			throws CryptoException {
		doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
	}

	public static void decrypt(String key, File inputFile, File outputFile)
			throws CryptoException {
		doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
	}
	
	public static byte[] encrypt(String key, byte[] input)
			throws CryptoException {
		return doCrypto(Cipher.ENCRYPT_MODE, key, input);
	}

	public static byte[] decrypt(String key, byte[] input)
			throws CryptoException {
		return doCrypto(Cipher.DECRYPT_MODE, key, input);
	}

	public static String encrypt(String key, String input)
			throws CryptoException {
		return doCrypto(Cipher.ENCRYPT_MODE, key, input);
	}

	public static String decrypt(String key, String input)
			throws CryptoException {
		return doCrypto(Cipher.DECRYPT_MODE, key, input);
	}

	private static void doCrypto(int cipherMode, String key, File inputFile,
			File outputFile) throws CryptoException {
			try {
				Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
				Cipher cipher = Cipher.getInstance(TRANSFORMATION);
				cipher.init(cipherMode, secretKey);

				FileInputStream inputStream = new FileInputStream(inputFile);
				byte[] inputBytes = new byte[(int) inputFile.length()];
				inputStream.read(inputBytes);

				byte[] outputBytes = cipher.doFinal(inputBytes);

				FileOutputStream outputStream = new FileOutputStream(outputFile);
				outputStream.write(outputBytes);

				inputStream.close();
				outputStream.close();
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException | IOException e) {
				throw new CryptoException("Erro ao encriptar/decriptar o arquivo", e);
			}
	}

	private static byte[] doCrypto(int cipherMode, String key, byte[] input)
			throws CryptoException {
			try {
				Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
				Cipher cipher = Cipher.getInstance(TRANSFORMATION);
				cipher.init(cipherMode, secretKey);

				return cipher.doFinal(input);
				
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException
					| IllegalBlockSizeException | BadPaddingException e) {
				throw new CryptoException("Erro ao encriptar/decriptar o vetor de bytes", e);
			}
	}
	
	private static String doCrypto(int cipherMode, String key, String input)
			throws CryptoException {
			try {
				Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
				Cipher cipher = Cipher.getInstance(TRANSFORMATION);
				cipher.init(cipherMode, secretKey);

				return new String(cipher.doFinal(input.getBytes("UTF-8")), "UTF-8");
				
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | UnsupportedEncodingException
					| IllegalBlockSizeException | BadPaddingException e) {
				throw new CryptoException("Erro ao encriptar/decriptar o texto", e);
			}
	}
}