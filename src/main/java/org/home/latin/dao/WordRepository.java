package org.home.latin.dao;

import org.home.latin.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer> {

    // that's it ... no need to write any code LOL!

    public List<Word> findAllByOrderByNameNlAsc();

    @Query("SELECT w FROM Word w WHERE  w.id between :fromId and :tillId")
    public List<Word> findFromTill(@Param("fromId") Integer fid,@Param("tillId") Integer tid);

}

