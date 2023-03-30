package com.example.SpringBootGradelMongoDB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringAnalyzer {

    @GetMapping("/api")
    public String analyze(@RequestParam String input) {
        int vowels = 0;
        int specialChars = 0;

        for (char c : input.toCharArray()) {
            if (isVowel(c)) {
                vowels++;
            } else if (isSpecialChar(c)) {
                specialChars++;
            }
        }

        return "Vowels: " + vowels + ", Special Characters: " + specialChars;
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    private boolean isSpecialChar(char c) {
        return !Character.isLetterOrDigit(c);
    }
}
