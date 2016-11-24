package ru.students.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.students.entity.GroupList;
import ru.students.entity.Plan;


@RepositoryRestResource(collectionResourceRel = "groupList", path = "groupList")
public interface GroupListRepository extends PagingAndSortingRepository<GroupList, Long> {

    @Transactional
    void deleteByNumberOfGroup(@Param("numberOfGroup") String numberOfGroup);
}
