package ru.students.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Chair;

@RepositoryRestResource(collectionResourceRel = "chair", path = "chair")
public interface ChairRepository extends PagingAndSortingRepository<Chair, Long> {

    @Transactional
    void deleteByHead(@Param("head") String head);
}
