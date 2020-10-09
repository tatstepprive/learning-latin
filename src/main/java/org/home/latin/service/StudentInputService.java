package org.home.latin.service;

import org.home.latin.entity.Knowledge;
import org.home.latin.entity.StudentInput;
import org.home.latin.entity.Test;

import java.util.List;

public interface StudentInputService {

    public List<StudentInput> findAll();

    public StudentInput findById(int theId);

    public void save(StudentInput studentInput);

    public void deleteById(int theId);

}
