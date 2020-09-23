package org.home.latin.environment.controller;

import org.home.latin.domain.Utils;
import org.home.latin.entity.Test;
import org.home.latin.entity.Word;
import org.home.latin.service.TestService;
import org.home.latin.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class WordController {

    private WordService service;
    private TestService testService;

    public WordController(WordService theWordService, TestService theTestService) {
        service = theWordService;
        testService= theTestService;
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

    @GetMapping("/test/start")
    public String getTestNew(Model model){
        Test test=new Test();
        test.setName("ref1");
        test.setDate(new Date());
        model.addAttribute("test", test);
        System.out.println("In get /test/start");
        System.out.println("Shown test="+test);
        return "test-start";
    }

    @RequestMapping(path="test/word/{id}")
    public String getMessage(@PathVariable("id") String id, Model model) {
        Word word=service.findById(Integer.parseInt(""+id));
        word.setFirstColumnLat("");
        word.setSecondColumnLat("");
        word.setGender("");
        model.addAttribute("word", word);
        model.addAttribute("size", "words: "+50);
        model.addAttribute("count", "words: "+0+"/"+service.findAll().size());
        System.out.println("In get");
        System.out.println("Shown Word="+word);
        return "test";
    }

    @RequestMapping(path="test/{id}")
    public String getTe(@PathVariable("id") String id, @ModelAttribute Word word, Model model) {
        Test test=testService.findById(Integer.parseInt(id));
        Word correctWord=service.findById(Integer.parseInt(""+word.getId()));
        word.setFirstColumnLat("");
        word.setSecondColumnLat("");
        word.setGender("");
        model.addAttribute("word", word);
        model.addAttribute("size", "words: "+50);
        model.addAttribute("count", "words: "+0+"/"+service.findAll().size());
        System.out.println("In get test/id");
        System.out.println("Shown TestId="+id);
        System.out.println("Shown Word="+word);
        System.out.println("Shown Correct Word="+correctWord);
        return "test";
    }

    @PostMapping("/test")
    public String testSubmit(@ModelAttribute Test test, Model model) {
        List<Word> words=service.findFromTill(test.getStartIndex(), test.getEndIndex());
        test.setWords(words);
        test.setNumberWords(test.getWords().size());
        testService.save(test);
        for(Word word: words){
            word.setFirstColumnLat("");
            word.setSecondColumnLat("");
            word.setGender("");
            word.addTest(test);
        }
        Word word=test.getWords().get(0);
        model.addAttribute("testid", test.getId());
        model.addAttribute("word", word);
   //     Word correctWord=service.findById(word.getId());
        System.out.println("In post /test");
        System.out.println("Shown test="+test);
        System.out.println("Shown word="+word);
     //   System.out.println("Recieved Word="+word);
     //   System.out.println("Correct Word="+correctWord);
  /*      boolean fistColumnError=!word.getFirstColumnLat().equals(correctWord.getFirstColumnLat());
        boolean secondColumnError=!word.getSecondColumnLat().equals(correctWord.getSecondColumnLat());
        boolean genderError=!word.getGender().equals(correctWord.getGender());
        model.addAttribute("firstError", fistColumnError);
        model.addAttribute("secondError", secondColumnError);
        model.addAttribute("genderError", genderError);
        model.addAttribute("hasErrors", (fistColumnError||secondColumnError||genderError));
        model.addAttribute("correctWord", correctWord);
        System.out.println("firstError="+fistColumnError+ " secondError="+secondColumnError + " genderError="+genderError);
   */
        model.addAttribute("count", "words: "+0+"/"+test.getWords().size());
        return "test";
    }

    @PostMapping("/test/word")
    public String wordSubmit(@ModelAttribute Word word, Model model) {
        model.addAttribute("word", word);
        Word correctWord=service.findById(word.getId());
  //      int allWordsCount=service.findAll().size();
  //      int nextId=allWordsCount<word.getId()+1?0:word.getId()+1;
        List<Test> tests=word.getTests();
        System.out.println(tests);
        tests.get(0).removeWord(word);
        Word nextWord=word.getTests().get(0).getWords().get(0);
        System.out.println("In post /test/word");
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
        model.addAttribute("nextWord", nextWord);

        System.out.println("firstError="+fistColumnError+ " secondError="+secondColumnError + " genderError="+genderError);
        return "result";
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

