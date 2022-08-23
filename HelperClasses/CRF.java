package HelperClasses;

public class CRF extends sha256 {

  public int outputsize;

  public CRF(int size) {
    outputsize = size;
    assert outputsize <= 64;
  }

  public String Fn(String s) {
    String shasum = encrypt(s);
    return shasum.substring(0, outputsize);
  }
}
