package org.home.latin.service;

import org.home.latin.entity.Word;

import java.util.List;

public interface WordService {

    public List<Word> findAll();

    public Word findById(int theId);

    public void save(Word word);

    public void deleteById(int theId);

}
