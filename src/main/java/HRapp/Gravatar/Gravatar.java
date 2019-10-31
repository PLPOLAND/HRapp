package HRapp.Gravatar;

import java.io.*;
import java.security.*;

public class Gravatar {
    public static String hex(byte[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    public static String gethash(String email) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return hex(md.digest(email.getBytes("CP1252")));
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }
    public static String getUrl(String email){
        String hash = gethash(email);

        return "https://www.gravatar.com/avatar/"+hash+"?s=200&d=monsterid";

    }
}