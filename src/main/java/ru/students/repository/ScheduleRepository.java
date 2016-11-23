package ru.students.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Schedule;

@RepositoryRestResource(collectionResourceRel = "schedule", path = "schedule")
public interface ScheduleRepository extends PagingAndSortingRepository<Schedule, Long> {


    @Transactional
    void deleteByTeacher(@Param("teacher") String teacher);
}


