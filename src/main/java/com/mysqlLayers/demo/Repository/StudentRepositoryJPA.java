package com.mysqlLayers.demo.Repository;

import com.mysqlLayers.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryJPA extends JpaRepository<Student,Integer> {
}
