package org.home.latin.environment.controller;

import org.home.latin.domain.*;
import org.home.latin.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnvironmentController {
    @Autowired
    private EnvironmentService service;

public EnvironmentController(){

}
    @GetMapping("/test")
    public String getHome(Model model){
        List<PostedWord> words=service.getTestedWords();
        PostedWord word =words.get(Utils.getRandomFromMax(words.size()));
        model.addAttribute("word", new PostedWord(word.getNameNl()));
        model.addAttribute("size", "words: "+words.size());
        System.out.println("In get");
        model.addAttribute("count", "words: "+service.getTestedWords().size()+"/"+service.getAllWords().size());
        words.remove(word);
        return "home";
    }
    @PostMapping("/test")
    public String homeSubmit(@ModelAttribute PostedWord word, Model model) {
        model.addAttribute("word", word);
        boolean fistColumnError=service.isFirstColumnError(word);
        boolean secondColumnError=service.isSecondColumnError(word);
        boolean genderError=service.isGenderError(word);
        model.addAttribute("firstError", fistColumnError);
        model.addAttribute("secondError", secondColumnError);
        model.addAttribute("genderError", genderError);
        model.addAttribute("hasErrors", (fistColumnError||secondColumnError||genderError));
        model.addAttribute("correctWord", service.search(word.getNameNl()));
        model.addAttribute("count", "words: "+service.getTestedWords().size()+"/"+service.getAllWords().size());
        System.out.println("In post");
        System.out.println("firstError="+fistColumnError+ " secondError="+secondColumnError + " genderError="+genderError);
        return "result";
    }

    @GetMapping("/itinera-environment-list")
    public String getItineraEnvironments(Model model){
      return "itinera-environment-list";
    }

    @GetMapping("/trivia-environment-list")
    public String getTriviaEnvironments(Model model){
        return "trivia-environment-list";
    }

    @GetMapping("/holmes-environment-list")
    public String getHolmesEnvironments(Model model){
        return "holmes-environment-list";
    }

    @GetMapping("/famicontrol-environment-list")
    public String getFamicontrolEnvironments(Model model){
        return "famicontrol-environment-list";
    }

    @GetMapping("/myfamiris-environment-list")
    public String getMyFamirisEnvironments(Model model){
        return "myfamiris-environment-list";
    }

    @GetMapping("/alis-environment-list")
    public String getAlisEnvironments(Model model){ ;
        return "alis-environment-list";
    }

    @GetMapping("/dms-environment-list")
    public String getDmsEnvironments(Model model){ ;
        return "dms-environment-list";
    }

    @GetMapping("/sprint")
    public String getSprint(Model model){

        return "sprint";
    }

    @RequestMapping(path="environment/{id}")
    public String getMessage(@PathVariable("id") String id, Model model) {
        return "environment-unknown";
    }

}
