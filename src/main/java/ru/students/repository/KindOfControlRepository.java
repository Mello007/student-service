package ru.students.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.GroupList;
import ru.students.entity.KindOfControl;


@RepositoryRestResource(collectionResourceRel = "kindOfControl", path = "kindOfControl")
public interface KindOfControlRepository extends PagingAndSortingRepository<KindOfControl, Long> {


    @Transactional
    void deleteByKindOfControl(@Param("kindOfControl") String kindOfControl);
}
