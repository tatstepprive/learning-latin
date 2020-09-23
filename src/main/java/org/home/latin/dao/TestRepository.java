package org.home.latin.dao;

import org.home.latin.entity.Test;
import org.home.latin.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer> {

    // that's it ... no need to write any code LOL!

    public List<Test> findAllByOrderByNameAsc();

    @Query("SELECT t FROM Test t WHERE  t.id between :fromId and :tillId")
    public List<Test> findFromTill(@Param("fromId") Integer fid, @Param("tillId") Integer tid);

    public Test findByName(String name);

}

