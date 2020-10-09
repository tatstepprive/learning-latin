package org.home.latin.dao;

import org.home.latin.entity.Knowledge;
import org.home.latin.entity.StudentInput;
import org.home.latin.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentInputRepository extends JpaRepository<StudentInput, Integer> {

}

