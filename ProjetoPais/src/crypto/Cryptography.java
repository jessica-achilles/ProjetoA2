package crypto;

import java.io.UnsupportedEncodingException;

/**
 * A tester for the CryptoUtils class.
 * @author www.codejava.net
 *
 */
public class Cryptography {
    public String crypto(String pw) {
    	String cripto="";
			try {
				String key = "continentespais9";
				byte[] bpw = pw.getBytes("UTF-8");
				System.out.println("mensagem: " + pw);
				byte[] bCripto = CryptoUtils.encrypt(key, bpw);
				cripto = new String(bCripto, "UTF-8");
				System.out.println("cripto: " + cripto);
			} catch (UnsupportedEncodingException | CryptoException e) {
				e.printStackTrace();
			}
			return cripto;
    }
}