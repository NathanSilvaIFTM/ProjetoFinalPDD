package br.edu.iftm;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {


    public interface Hash {

        public static String generate(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.reset();
            byte[] buffer = input.getBytes("UTF-8");
            md.update(buffer);
            byte[] digest = md.digest();

            String hexStr = "";
            for (int i = 0; i < digest.length; i++) {
                hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
            }
            return hexStr;
        }


        public static boolean compare(StringBuilder input, String hash) throws UnsupportedEncodingException, NoSuchAlgorithmException {
            boolean achou = false;
            String teste = String.valueOf(input);
            String comparacao = Sha256.Hash.generate(teste);
            if(comparacao.equals(hash)) {
                return achou = true;
            }else{
                return achou = false;
            }
        }

    }
}
