package org.home.latin.dao;

import org.home.latin.entity.Knowledge;
import org.home.latin.entity.Test;
import org.home.latin.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Integer> {

    public List<Knowledge> findAllByOrderByTestAsc();
/*
    @Query("SELECT k FROM Knowledge k WHERE  k.test.id =:tid")
    public List<Knowledge> findAllByTestId(@Param("tid") Integer tid);

    @Query("SELECT k FROM Knowledge k WHERE  k.test.id =:tid and k.word.id =:tillId")
    public Knowledge findKnowledge(@Param("testId") Integer tid, @Param("wordId") Integer wid);

 */
    public List<Knowledge> findAllByTest(Test test);

}

