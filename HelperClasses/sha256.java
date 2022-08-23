package HelperClasses;

import java.nio.charset.StandardCharsets;
import java.security.*;

public class sha256 {

  protected static String encrypt(String password) {
    String shasum = "";
    try {
      MessageDigest crypt = MessageDigest.getInstance("SHA-256");
      shasum =
        Conversion.byteToHex(
          crypt.digest(password.getBytes(StandardCharsets.UTF_8))
        );
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return shasum;
  }
}
