package ru.students.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Chair;
import ru.students.entity.Discipline;

@RepositoryRestResource(collectionResourceRel = "discipline", path = "discipline")
public interface DisciplineRepository extends PagingAndSortingRepository<Discipline, Long> {

    @Transactional
    void deleteByDiscipline(@Param("discipline") String discipline);
}
