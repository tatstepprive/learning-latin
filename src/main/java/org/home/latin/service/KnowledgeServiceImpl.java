package org.home.latin.service;

import org.home.latin.dao.KnowledgeRepository;
import org.home.latin.dao.TestRepository;
import org.home.latin.entity.Knowledge;
import org.home.latin.entity.Test;
import org.home.latin.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    KnowledgeRepository knowledgeRepository;

    @Autowired
    public KnowledgeServiceImpl(KnowledgeRepository theKnowledgeRepository) {
        knowledgeRepository = theKnowledgeRepository;
    }

    @Override
    public List<Knowledge> findAll() {
        return knowledgeRepository.findAll();
    }

    @Override
    public Knowledge findById(int theId) {
        Optional<Knowledge> result = knowledgeRepository.findById(theId);

        Knowledge theKnowledge = null;

        if (result.isPresent()) {
            theKnowledge = result.get();

        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find test id - " + theId);
        }

        return theKnowledge;
    }


    @Override
    public void save(Knowledge test) {
        knowledgeRepository.save(test);
    }

    @Override
    public void deleteById(int theId) {
        knowledgeRepository.deleteById(theId);
    }

    @Override
    public List<Knowledge> findAllByTest(Test test) {
        return knowledgeRepository.findAllByTest(test);
    }


}
