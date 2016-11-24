package ru.students.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Chair;
import ru.students.entity.Plan;

@RepositoryRestResource(collectionResourceRel = "plan", path = "plan")
public interface PlanRepository extends PagingAndSortingRepository<Plan, Long> {

    @Transactional
    void deleteByDiscipline(@Param("discipline") String discipline);
}
