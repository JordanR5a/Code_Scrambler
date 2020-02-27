package model;

public class Cutter implements stringEncrypter{
    public String encrypt(String stringToCut){
        return String.format("%s%s", stringToCut.substring(stringToCut.length() / 2),
                stringToCut.substring(0, stringToCut.length() / 2));
    }

    public String decrypt(String stringToUncut){
        return String.format("%s%s", stringToUncut.substring((stringToUncut.length() / 2) + 1),
                stringToUncut.substring(0, (stringToUncut.length() / 2) + 1));
    }

    @Override
    public String toString(){
    return EncryptionType.Cut_and_switch.toString();
    }
}
