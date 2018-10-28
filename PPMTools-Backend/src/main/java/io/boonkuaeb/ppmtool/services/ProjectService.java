package io.boonkuaeb.ppmtool.services;

import io.boonkuaeb.ppmtool.domain.Project;
import io.boonkuaeb.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdateProject(Project project)
    {
        /* Logic */
        return projectRepository.save(project);
    }
}
