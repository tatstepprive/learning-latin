package org.home.latin.service;

import org.home.latin.dao.TestRepository;
import org.home.latin.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {
    TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository theWordRepository) {
        testRepository = theWordRepository;
    }

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Test findById(int theId) {
        Optional<Test> result = testRepository.findById(theId);

        Test theTest = null;

        if (result.isPresent()) {
            theTest = result.get();

        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find test id - " + theId);
        }

        return theTest;
    }

    @Override
    public List<Test> findFromTill(int theIdFrom, int theIdTill){
        return testRepository.findFromTill(theIdFrom, theIdTill);
    }

    @Override
    public void save(Test test) {
        testRepository.save(test);
    }

    @Override
    public void deleteById(int theId) {
        testRepository.deleteById(theId);
    }

    @Override
    public Test findByName(String testName){
        return testRepository.findByName(testName);
    }

    @Override
    public Test findLast(){
        return testRepository.findTopByOrderByIdDesc();
    }

}
