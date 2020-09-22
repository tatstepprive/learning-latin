package org.home.latin.environment.controller;

import org.home.latin.domain.PostedWord;
import org.home.latin.domain.Utils;
import org.home.latin.entity.Test;
import org.home.latin.entity.Word;
import org.home.latin.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class WordController {

    private WordService service;

    public WordController(WordService theWordService) {
        service = theWordService;
    }

    @GetMapping("/")
    public String getHome(Model model){
        Test test=new Test();
        test.setName("ref1");
        test.setDate(new Date());
        model.addAttribute("test", test);
        System.out.println("In get");
        System.out.println("Shown test="+test);
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

    @GetMapping("/learn")
    public String getLearn(Model model){
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
        return "learn";
    }

    @GetMapping("/test")
    public String getTest(Model model){
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
        return "test";
    }

    @PostMapping("/test")
    public String homeSubmit(@ModelAttribute Test test, Model model) {
        Word word=service.findById(test.getStartIndex());
        word.setFirstColumnLat("");
        word.setSecondColumnLat("");
        word.setGender("");
        test.addWord(word);
        test.addWord(service.findById(test.getEndIndex()));
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
        return "test";
    }

    @GetMapping("/score")
    public String getScore(Model model){
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
        return "score";
    }

    @GetMapping("/search")
    public String getSearch(Model model){
        List<Word> words=service.findAll();
        model.addAttribute("words", words);
        return "search";
    }

}

