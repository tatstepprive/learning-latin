package org.home.latin.service;

import org.home.latin.entity.Knowledge;
import org.home.latin.entity.Test;
import org.home.latin.entity.Word;

import java.util.List;

public interface KnowledgeService {

    public List<Knowledge> findAll();

    public Knowledge findById(int theId);

    public void save(Knowledge knowledge);

    public void deleteById(int theId);

    public List<Knowledge> findAllByTest(Test test);

}
