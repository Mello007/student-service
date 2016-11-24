package ru.students.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Specialty;


@RepositoryRestResource(collectionResourceRel = "specialty", path = "specialty")
public interface SpecialtyRepository extends PagingAndSortingRepository<Specialty, Long> {


    @Transactional
    void deleteBySpecialty(@Param("specialty") String specialty);
}
