package io.boonkuaeb.ppmtool.repository;

import io.boonkuaeb.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    Project findByProjectCode(String projectCode);

    @Override
    Iterable<Project> findAll();


}
