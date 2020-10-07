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
        System.out.println("Schowing home");
        return "home";
    }
    @PostMapping("/")
    public String homeSubmit(@ModelAttribute Word word, Model model) {
        model.addAttribute("word", word);
        Word correctWord=service.findById(word.getId());
        System.out.println("In homeSubmit post /");
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
        System.out.println("Schowing result");
        return "result";
    }

    @GetMapping("/learn")
    public String getLearn(Model model){
        List<Word> words=service.findAll();
        Word word =words.get(Utils.getRandomFromMax(words.size()));
        model.addAttribute("word", word);
        model.addAttribute("size", "words: "+words.size());
        model.addAttribute("count", "words: "+0+"/"+service.findAll().size());
        System.out.println("In getLearn get /learn");
        System.out.println("Shown Word="+word);
        System.out.println("Schowing learn");
        return "learn";
    }
//--------/test get mappings-----------------------------
    @GetMapping("/test")
    public String getTest(Model model){
        Test test=new Test();
        test.setName(getNameTimeBased());
        test.setDate(new Date());
        System.out.println("In getTest get /test");
        System.out.println("Init test="+test);
        model.addAttribute("test", test);
        System.out.println("Schowing test-start");
        return "test-start";
    }

    @RequestMapping(path="test/{testname}")
    public String getTestUnique(@PathVariable("testname") String testname, Model model) {

        Test test=testService.findByName(testname);
        model.addAttribute("test", test);
        System.out.println("In get getTestUnique test/"+testname);
        System.out.println("Test from db ="+test);

        List<Knowledge> knowledges =knowledgeService.findAllByTest(test);
        model.addAttribute("knowledges", knowledges);
        int correctAnswers=0;
        List<Word> testedWords=new ArrayList<>();
        for (Knowledge knowledge: knowledges){
            testedWords.add(knowledge.getWord());
            correctAnswers+=knowledge.getOk()?1:0;
        }
        model.addAttribute("correctAnswers", correctAnswers);
        model.addAttribute("result", "score: "+correctAnswers+"/"+knowledges.size());
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
        }
        System.out.println("Showing score or test-word with word="+word);
        return word==null?"score":"test-word";
    }
//-----------/test post mappings-------------------------------------
    @PostMapping("/test")
    public String testSubmit(@ModelAttribute Test test, Model model) {
        List<Word> words=service.findFromTill(test.getStartIndex(), test.getEndIndex());
        test.setWords(words);
        test.setNumberWords(test.getWords().size());
        System.out.println("In testSubmit post /test");
        System.out.println("Saving test="+test);
        testService.save(test);
        System.out.println("Saved test="+test);
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
        System.out.println("Shown test="+test);
        System.out.println("Shown word="+word);
        model.addAttribute("count", "words: "+0+"/"+test.getNumberWords());
        System.out.println("Showing test-word");
        return "test-word";
    }

    @RequestMapping(path="test/{testname}", method = RequestMethod.POST)
    public String postTestUnique(@PathVariable("testname") String testname, @ModelAttribute Word word, Model model) {
        model.addAttribute("word", word);
        Test test=testService.findByName(testname);
        System.out.println("In getTestUnique post test/"+testname);
        System.out.println("Test from db ="+test);
        Word correctWord=service.findById(word.getId());
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
        System.out.println("Showing result");
        return "result";
    }
    //--------/score get mappings-----------------------------
    @GetMapping("/score")
    public String getScore(Model model){
        System.out.println("In getScore get /score");
        Test test=testService.findLast();
        model.addAttribute("test", test);
        System.out.println("Test from db ="+test);

        List<Knowledge> knowledges =knowledgeService.findAllByTest(test);
        model.addAttribute("knowledges", knowledges);
        int correctAnswers=0;
        List<Word> testedWords=new ArrayList<>();
        for (Knowledge knowledge: knowledges){
            testedWords.add(knowledge.getWord());
            correctAnswers+=knowledge.getOk()?1:0;
        }
        model.addAttribute("correctAnswers", correctAnswers);
        model.addAttribute("result", "score: "+correctAnswers+"/"+knowledges.size());
        System.out.println("Showing score");
        return "score";
    }
    //--------/search get mappings-----------------------------
    @GetMapping("/search")
    public String getSearch(Model model){
        System.out.println("In getSearch get /search");
        List<Word> words=service.findAll();
        model.addAttribute("words", words);
        System.out.println("Showing search");
        return "search";
    }

}

