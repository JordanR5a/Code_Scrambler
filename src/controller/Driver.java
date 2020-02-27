package controller;

import model.*;
import view.Display;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private List<stringEncrypter> process = new ArrayList<>();
    private Display display = new Display();
    private String inputStr;

    public static void main(String[] args) {
        new Driver().run();
    }

    private void run() {
        int input;
        do {
            display.presentMenu();
            input = display.getUserIntInput();
            switch (input) {
                case 1:
                    display.sendRequest("Please enter what you wish to edit.");
                    inputStr = display.getUserStrInput();
                    break;
                case 2:
                    selectMethods();
                    break;
                case 3:
                    display.displayGroupOfObjs(process, String.format("Methods of Encryption (%s)", inputStr));
                    break;
                case 4:
                    process.clear();
                    break;
                case 5:
                    encryptCurrentInputStr();
                    break;
                case 6:
                    decryptCurrentInputStr();
                    break;

            }
        } while (input != 7);
    }

    private void selectMethods() {
        int input;
        do {
            display.presentOptions();
            input = display.getUserIntInput();
            switch (input) {
                case 1:
                    process.add(new Doubler());
                    break;
                case 2:
                    process.add(new Cutter());
                    break;
                case 3:
                    process.add(new VowelReplacer());
                    break;
                case 4:
                    process.add(new Switcher());
                    break;
                default:
                    display.sendRequest("Please try again.");
                    break;
            }
        } while (input != 5);
    }

    private void encryptCurrentInputStr() {
        if (!process.isEmpty()) {
            for (stringEncrypter type : process) {
                inputStr = type.encrypt(inputStr);
            }
        } else display.sendRequest("Methods list is empty.");
    }

    private void decryptCurrentInputStr(){
        if (!process.isEmpty()){
            for (int i = process.size() - 1; i >= 0; i--) {
                inputStr = process.get(i).decrypt(inputStr);
            }
        } else display.sendRequest("Methods list is empty.");
    }
}
