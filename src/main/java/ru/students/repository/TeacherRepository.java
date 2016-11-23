package ru.students.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Teacher;


@RepositoryRestResource(collectionResourceRel = "teacher", path = "teacher")
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {

    @Transactional
    void deleteByName(@Param("name") String name);

}
