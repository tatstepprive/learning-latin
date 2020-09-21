package org.home.latin.dao;

import org.home.latin.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer> {

    // that's it ... no need to write any code LOL!

    public List<Word> findAllByOrderByNameNlAsc();

}

