package com.palindrome.palindrome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class checkPalindrome {
    @GetMapping("/get/{param}")
    public String getChecker(@PathVariable("param") String param)
    {
        StringBuilder inverted = new StringBuilder();
        for (int i = param.length()-1; i>=0; i--){
            inverted.append(param.charAt(i));
        }

        String inv_str = inverted.toString();

        if (inv_str.equals(param)) return "Entered value: " + param + " is a palindrome.";
        return "Entered value: " + param + " is NOT a palindrome.";
    }
}
