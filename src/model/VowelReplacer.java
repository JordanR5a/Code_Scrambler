package model;

public class VowelReplacer implements stringEncrypter {
    private String vowels = "aeiou";
    public String encrypt(String stringToReplaceVowel){
        String finalStr = "";
        for (int i = 0; i < stringToReplaceVowel.length(); i++) {
            char c = stringToReplaceVowel.charAt(i);
            for (int a = 0; a < vowels.length(); a++) {
                if(stringToReplaceVowel.charAt(i) == vowels.charAt(a)){
                    try {
                        c = vowels.charAt(a + 1);
                    } catch (StringIndexOutOfBoundsException str){
                        c = vowels.charAt(0);
                    }
                }
            }
            finalStr += c;
        }
        return finalStr;
    }

    public String decrypt(String stringToRevertReplacement){
        String finalStr = "";
        for (int i = 0; i < stringToRevertReplacement.length(); i++) {
            char c = stringToRevertReplacement.charAt(i);
            for (int a = 0; a < vowels.length(); a++) {
                if(stringToRevertReplacement.charAt(i) == vowels.charAt(a)){
                    try {
                        c = vowels.charAt(a - 1);
                    } catch (StringIndexOutOfBoundsException str){
                        c = vowels.charAt(vowels.length() - 1);
                    }
                }
            }
            finalStr += c;
        }
        return finalStr;
    }

    @Override
    public String toString(){
        return EncryptionType.Replace_vowels.toString();
    }
}
