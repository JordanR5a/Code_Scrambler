package model;

public class Switcher implements stringEncrypter {
    public String encrypt(String stringToSwitch){
        String finalString = "";
        for (int i = 0; i < stringToSwitch.length(); i += 2) {
            try {
                finalString += String.format("%s%s", stringToSwitch.substring(i + 1, i + 2),
                        stringToSwitch.substring(i, i + 1));
            } catch (StringIndexOutOfBoundsException str){
                finalString += String.format("%s%s", stringToSwitch.substring(i + 1),
                        stringToSwitch.substring(i, i + 1));
            }
        }
        return finalString;
    }

    public String decrypt(String stringToSwitch){
        return encrypt(stringToSwitch);
    }

    @Override
    public String toString(){
        return EncryptionType.Switch_letters.toString();
    }
}
