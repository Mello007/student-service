package ru.students.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Student;

@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Student findByName(@Param("name") String name);

    @Transactional
    void deleteByName(@Param("name") String name);

}