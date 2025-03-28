package org.example.letters_service.controller;

import org.example.letters_service.model.Letter;
import org.example.letters_service.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/letters")
public class LetterController {
    @Autowired
    private LetterService letterService;

    // Admin: Post a letter
    @PostMapping("/post")
    public ResponseEntity<String> postLetter(@RequestBody Letter letter) {
        letterService.saveLetter(letter);
        return ResponseEntity.ok("Letter posted successfully.");
    }

    // User: View all letters
    @GetMapping("/all")
    public ResponseEntity<List<Letter>> getAllLetters() {
        return ResponseEntity.ok(letterService.getAllLetters());
    }

    // User: View letters by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Letter>> getLettersByCategory(@PathVariable String category) {
        return ResponseEntity.ok(letterService.getLettersByCategory(category));
    }
}
