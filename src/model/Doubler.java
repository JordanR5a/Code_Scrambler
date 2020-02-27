package model;

public class Doubler implements stringEncrypter{
    public String encrypt(String stringToDouble) {
        return String.format("%s%s", stringToDouble, stringToDouble);
    }

    public String decrypt(String stringToHalf) {
        return stringToHalf.substring((stringToHalf.length() / 2));
    }

    @Override
    public String toString(){
        return EncryptionType.Double.toString();
    }
}
