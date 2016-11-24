package ru.students.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Faculties;
import ru.students.entity.GroupList;

@RepositoryRestResource(collectionResourceRel = "faculties", path = "faculties")
public interface FacultiesRepository extends PagingAndSortingRepository<Faculties, Long> {

    @Transactional
    void deleteByFaculties(@Param("faculties") String faculties);
}
