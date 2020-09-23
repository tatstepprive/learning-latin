package org.home.latin.service;

import org.home.latin.entity.Test;
import org.home.latin.entity.Word;

import java.util.List;

public interface TestService {


    public List<Test> findAll();

    public Test findById(int theId);

    public List<Test> findFromTill(int theIdFrom, int theIdTill);

    public void save(Test word);

    public void deleteById(int theId);

    public Test findByName(String testName);
}
