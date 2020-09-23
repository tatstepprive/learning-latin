package org.home.latin.environment.controller;

import org.home.latin.domain.Utils;
import org.home.latin.entity.Knowledge;
import org.home.latin.entity.Test;
import org.home.latin.entity.Word;
import org.home.latin.service.KnowledgeService;
import org.home.latin.service.TestService;
import org.home.latin.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.home.latin.domain.Utils.getNameTimeBased;

@Controller
public class WordController {

    private WordService service;
    private TestService testService;
    private KnowledgeService knowledgeService;

    public WordController(WordService theWordService, TestService theTestService, KnowledgeService theKnowledgeService) {
        service = theWordService;
        testService= theTestService;
        knowledgeService=theKnowledgeService;
    }

    @GetMapping("/")
    public String getHome(Model model){
        Test test=new Test();
        test.setName("ref1");
        test.setDate(new Date());
        model.addAttribute("test", test);
        System.out.println("In get /");
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
        return "learn";
    }
//--------/test get mappings-----------------------------
    @GetMapping("/test")
    public String getTest(Model model){
        Test test=new Test();
        test.setName(getNameTimeBased());
        test.setDate(new Date());
        System.out.println("In get /test");
        System.out.println("Init test="+test);
        model.addAttribute("test", test);
        return "test-start";
    }

    @RequestMapping(path="test/{testname}")
    public String getTestUnique(@PathVariable("testname") String testname, Model model) {

        Test test=testService.findByName(testname);
        System.out.println("In get getTestUnique test/testName");
        System.out.println("Test from db ="+test);

        model.addAttribute("test", test);

        List<Knowledge> knowledges =knowledgeService.findAllByTest(test);
        List<Word> testedWords=new ArrayList<>();
        for (Knowledge knowledge: knowledges){
            testedWords.add(knowledge.getWord());
        }
        System.out.println("TESTED words:"+testedWords);
        List<Word> wordsToTest = test.getWords().stream()
                .filter(e -> !testedWords.contains(e))
                .collect (Collectors.toList());
        Iterator<Word> iter
                = wordsToTest.listIterator();
        Word word=null;
        if(iter.hasNext()){
            word=iter.next();
            word.setFirstColumnLat("");
            word.setSecondColumnLat("");
            word.setGender("");
            model.addAttribute("word", word);
            model.addAttribute("size", "words: "+test.getNumberWords());
            model.addAttribute("count", "words: "+testedWords.size()+"/"+test.getNumberWords());
        }else{
            test=new Test();
            test.setName(getNameTimeBased());
            test.setDate(new Date());
            System.out.println("In get getTestUnique test/testName");
            System.out.println("Init test="+test);
            model.addAttribute("test", test);
        }
        return word==null?"test-start":"test-word";
    }
//-----------/test post mappings-------------------------------------
    @PostMapping("/test")
    public String testSubmit(@ModelAttribute Test test, Model model) {
        List<Word> words=service.findFromTill(test.getStartIndex(), test.getEndIndex());
        test.setWords(words);
        test.setNumberWords(test.getWords().size());
        System.out.println("In post /test Saving test="+test);
        testService.save(test);
        System.out.println("In post /test Saved test="+test);
        for(Word word: words){
            word.setFirstColumnLat("");
            word.setSecondColumnLat("");
            word.setGender("");
            word.addTest(test);
        }
        Word word=test.getWordToTest();
        model.addAttribute("testid", test.getId());
        model.addAttribute("testname", test.getName());
        model.addAttribute("word", word);
        System.out.println("In post /test");
        System.out.println("Shown test="+test);
        System.out.println("Shown word="+word);
        model.addAttribute("count", "words: "+0+"/"+test.getNumberWords());
        return "test-word";
    }

    @RequestMapping(path="test/{testname}", method = RequestMethod.POST)
    public String postTestUnique(@PathVariable("testname") String testname, @ModelAttribute Word word, Model model) {
        model.addAttribute("word", word);
        Test test=testService.findByName(testname);
        System.out.println("In post getTestUnique test/testName");
        System.out.println("Test from db ="+test);
        Word correctWord=service.findById(word.getId());

        System.out.println("In post getTestUnique test/testname");
        System.out.println("Recieved Word="+word);
        System.out.println("Correct Word="+correctWord);
        boolean fistColumnError=!word.getFirstColumnLat().equals(correctWord.getFirstColumnLat());
        boolean secondColumnError=!word.getSecondColumnLat().equals(correctWord.getSecondColumnLat());
        boolean genderError=!word.getGender().equals(correctWord.getGender());
        boolean hasErrors=(fistColumnError||secondColumnError||genderError);

        model.addAttribute("firstError", fistColumnError);
        model.addAttribute("secondError", secondColumnError);
        model.addAttribute("genderError", genderError);
        model.addAttribute("hasErrors", hasErrors);
        model.addAttribute("correctWord", correctWord);
        System.out.println("firstError="+fistColumnError+ " secondError="+secondColumnError + " genderError="+genderError);
        model.addAttribute("size", "words: "+test.getNumberWords());
        model.addAttribute("count", "words: "+0+"/"+test.getNumberWords());
        // todo save result (before showing result or after showing result with NEXT word action)
        // but NEXT word action is get action and should be no post action to contain data to save
        // todo calculate next word correct, dont show the same
        // keep second array with words done? and take nextWord from substraction of to test words and done words
      //  test.removeWord(correctWord);
      //  testService.save(test);
        Knowledge knowledge=new Knowledge();
        knowledge.setTest(test);
        knowledge.setWord(correctWord);
        knowledge.setOk(!hasErrors);
        knowledgeService.save(knowledge);
        Word nextWord=test.getWordToTest();
        model.addAttribute("nextWord", nextWord);

        return "result";
    }

    @PostMapping("test/word")
    public String wordSubmit(@ModelAttribute Word word, Model model) {
        model.addAttribute("word", word);
        Word correctWord=service.findById(word.getId());
  //      int allWordsCount=service.findAll().size();
  //      int nextId=allWordsCount<word.getId()+1?0:word.getId()+1;
        List<Test> tests=word.getTests();
        System.out.println(tests);
        tests.get(0).removeWord(word);
        Word nextWord=word.getTests().get(0).getWords().get(0);
        System.out.println("In post test/word");
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

