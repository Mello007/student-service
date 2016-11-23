package ru.students.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.Session;

@RepositoryRestResource(collectionResourceRel = "session", path = "session")
public interface SessionRepository extends PagingAndSortingRepository<ru.students.entity.Session, Long> {
    @Transactional
    void deleteByDescription(@Param("description") String description);
}
