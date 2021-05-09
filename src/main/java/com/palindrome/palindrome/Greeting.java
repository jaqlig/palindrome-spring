package com.palindrome.palindrome;

public class Greeting {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {

        StringBuilder inverted = new StringBuilder();
        for (int i = content.length()-1; i>=0; i--){
            inverted.append(content.charAt(i));
        }

        String inv_str = inverted.toString();

        if (inv_str.equals(content)) this.content = "Entered value: " + content + " is a palindrome.";
        else this.content = "Entered value: " + content + " is NOT a palindrome.";

    }

}