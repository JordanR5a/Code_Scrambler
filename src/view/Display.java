package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class Display {
    private boolean replay;

    public boolean isReplay() {
        return replay;
    }

    public void setReplay(boolean replay) {
        this.replay = replay;
    }

    public void presentMenu(){
        System.out.println("1: Enter an input\n" +
                "2: Add methods of encryption\n" +
                "3: Display current list & current input\n" +
                "4: Clear current list\n" +
                "5: Encrypt current input\n" +
                "6: Decrypt current input\n" +
                "7: Exit");
    }

    public void presentOptions(){
        System.out.println("1: Double\n" +
                "2: Cut and switch\n" +
                "3: Replace vowels\n" +
                "4: Switch letters\n" +
                "5: Exit");
    }

    public String getUserStrInput(){
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String input = null;
        do {
            try {
                input = br.readLine();
                if(input.isEmpty() || input == null){
                    throw new IllegalStateException("User input unacceptable");
                }
                setReplay(false);
            } catch (IOException | IllegalStateException exception) {
                System.out.println("Please try again.");
                setReplay(true);
            }
        } while (isReplay());
        return input;
    }

    public int getUserIntInput(){
        try{
            return Integer.parseInt(getUserStrInput());
        } catch (NumberFormatException exception){
            return 0;
        }
    }

    public void sendRequest(String str){
        System.out.println(str);
    }

    public void displayGroupOfObjs(List group, String contents){
        sendRequest(String.format("%s:", contents));
        for(Object obj : group){
            sendRequest(formatObjs(obj));
        }
        sendRequest("");
    }

    private String formatObjs(Object obj){
        String objStr = obj.toString().trim();
        String finalStr = "";
        for (int i = 0; i < objStr.length(); i++) {
            try{
                String tempStr = objStr.substring(i, i + 1);
                if (tempStr.equals("_")) finalStr += " ";
                else finalStr += tempStr;
            } catch (StringIndexOutOfBoundsException exception){}
        }
        return finalStr;
    }
}
