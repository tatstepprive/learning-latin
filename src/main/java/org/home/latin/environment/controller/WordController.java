package org.home.latin.environment.controller;

import org.home.latin.domain.PostedWord;
import org.home.latin.domain.Utils;
import org.home.latin.entity.Word;
import org.home.latin.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WordController {

    private WordService service;

    public WordController(WordService theWordService) {
        service = theWordService;
    }

    @GetMapping("/")
    public String getHome(Model model){
        List<Word> words=service.findAll();
        Word word =words.get(Utils.getRandomFromMax(words.size()));
        word.setFirstColumnLat("");
        word.setSecondColumnLat("");
        word.setGender("");
        model.addAttribute("word", word);
        model.addAttribute("size", "words: "+words.size());
        model.addAttribute("count", "words: "+0+"/"+service.findAll().size());
        System.out.println("In get");
        System.out.println("Shown Word="+word);
       // words.remove(word);
        return "home";
    }
    @PostMapping("/")
    public String homeSubmit(@ModelAttribute Word word, Model model) {
        model.addAttribute("word", word);
        Word correctWord=service.findById(word.getId());
        System.out.println("In post");
        System.out.println("Recieved Word="+word);
        System.out.println("Correct Word="+correctWord);
        boolean fistColumnError=!word.getFirstColumnLat().equals(correctWord.getFirstColumnLat());
        boolean secondColumnError=!word.getSecondColumnLat().equals(correctWord.getSecondColumnLat());
        boolean genderError=!word.getGender().equals(correctWord.getGender());
        model.addAttribute("firstError", fistColumnError);
        model.addAttribute("secondError", secondColumnError);
        model.addAttribute("genderError", genderError);
        model.addAttribute("hasErrors", (fistColumnError||secondColumnError||genderError));
        model.addAttribute("correctWord", correctWord);
        model.addAttribute("count", "words: "+0+"/"+service.findAll().size());

        System.out.println("firstError="+fistColumnError+ " secondError="+secondColumnError + " genderError="+genderError);
        return "result";
    }



}

