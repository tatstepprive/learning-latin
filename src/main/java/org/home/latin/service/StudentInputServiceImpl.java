package org.home.latin.service;

import org.home.latin.dao.KnowledgeRepository;
import org.home.latin.dao.StudentInputRepository;
import org.home.latin.entity.Knowledge;
import org.home.latin.entity.StudentInput;
import org.home.latin.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentInputServiceImpl implements StudentInputService {

    StudentInputRepository repository;

    @Autowired
    public StudentInputServiceImpl(StudentInputRepository theRepository) {
        repository = theRepository;
    }
    @Override
    public List<StudentInput> findAll() {
        return repository.findAll();
    }

    @Override
    public StudentInput findById(int theId) {
        Optional<StudentInput> result = repository.findById(theId);

        StudentInput  studentInput = null;

        if (result.isPresent()) {
            studentInput = result.get();

        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find studentInput id - " + theId);
        }

        return studentInput;
    }

    @Override
    public void save(StudentInput studentInput) {
          repository.save(studentInput);
    }

    @Override
    public void deleteById(int theId) {
          repository.deleteById(theId);
    }

}
