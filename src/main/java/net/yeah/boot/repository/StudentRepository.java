package net.yeah.boot.repository;

import net.yeah.boot.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
}
