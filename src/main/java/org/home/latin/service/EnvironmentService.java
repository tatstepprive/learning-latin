package org.home.latin.service;

import javafx.geometry.Pos;
import org.home.latin.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvironmentService {
    private List<PostedWord> testedWords;
    private List<PostedWord> allWords;

    public List<PostedWord> getTestedWords(){
        if(testedWords ==null || testedWords.isEmpty()){
            initTestedWords();
        }
        return testedWords;
    }

    public List<PostedWord> getAllWords(){
        if(allWords ==null || allWords.isEmpty()){
            initAllWords();
        }
        return allWords;
    }

    public boolean isFirstColumnError(PostedWord word){
        String name=word.getNameNl();
        PostedWord foundWord=search(name);
        System.out.println(("Found word="+word));
        if(foundWord==null){
            return true;
        }
        return !word.getFirstColumnLat().equals(foundWord.getFirstColumnLat());
    }

    public boolean isSecondColumnError(PostedWord word){
        String name=word.getNameNl();
        PostedWord foundWord=search(name);
        if(foundWord==null){
            return true;
        }
        return !word.getSecondColumnLat().equals(foundWord.getSecondColumnLat());
    }

    public boolean isGenderError(PostedWord word){
        String name=word.getNameNl();
        PostedWord foundWord=search(name);
        if(foundWord==null){
            return true;
        }
        return !word.getGender().equals(foundWord.getGender());
    }

    private void initAllWords(){
        allWords =new ArrayList();
        allWords.add(new PostedWord( 2L,"grootvader", "avus","avi","m", "noun", "/images/intranet-logo.png"));
        allWords.add(new PostedWord( 2L,"roos", "rosa","rosae","v", "noun", "/images/intranet-logo.png"));
        allWords.add(new PostedWord( 2L,"geschenk", "donum","doni","m", "noun", "/images/intranet-logo.png"));
        allWords.add(new PostedWord( 2L,"vriend", "amicus","amici","m", "noun", "/images/intranet-logo.png"));
        allWords.add(new PostedWord( 2L,"jaar", "annus","anni","m", "noun", "/images/intranet-logo.png"));
    }

    private void initTestedWords(){
        testedWords =new ArrayList();
        testedWords.add(new PostedWord( 1L,"grootvader", "avus","avi","m", "noun", "/images/intranet-logo.png"));
        testedWords.add(new PostedWord( 1L,"roos", "rosa","rosae","v", "noun", "/images/intranet-logo.png"));
        testedWords.add(new PostedWord( 1L,"geschenk", "donum","doni","m", "noun", "/images/intranet-logo.png"));
        testedWords.add(new PostedWord( 1L,"vriend", "amicus","amici","m", "noun", "/images/intranet-logo.png"));
        testedWords.add(new PostedWord( 1L,"jaar", "annus","anni","m", "noun", "/images/intranet-logo.png"));
    }

    public PostedWord search(String name){
        if(allWords ==null || allWords.isEmpty()){
            initAllWords();
        }
        for (PostedWord word: allWords){
            if (word.getNameNl().equals(name)){
                return word;
            }
        }
        return null;
    }

}
