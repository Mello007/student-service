package ru.students.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Estimate;

@RepositoryRestResource(collectionResourceRel = "estimate", path = "estimate")
public interface EstimateRepository extends PagingAndSortingRepository<Estimate, Long> {

    @Transactional
    void deleteByStudent(@Param("student") String student);
}
