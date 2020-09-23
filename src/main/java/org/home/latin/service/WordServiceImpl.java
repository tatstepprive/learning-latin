package org.home.latin.service;

import org.home.latin.dao.WordRepository;
import org.home.latin.domain.PostedWord;
import org.home.latin.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository theWordRepository) {
        wordRepository = theWordRepository;
    }

    @Override
    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    @Override
    public Word findById(int theId) {
        Optional<Word> result = wordRepository.findById(theId);

        Word theWord = null;

        if (result.isPresent()) {
            theWord = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find word id - " + theId);
        }

        return theWord;
    }

    @Override
    public List<Word> findFromTill(int theIdFrom, int theIdTill){
        return wordRepository.findFromTill(theIdFrom, theIdTill);
    }

    @Override
    public void save(Word word) {
      wordRepository.save(word);
    }

    @Override
    public void deleteById(int theId) {
         wordRepository.deleteById(theId);
    }
}
