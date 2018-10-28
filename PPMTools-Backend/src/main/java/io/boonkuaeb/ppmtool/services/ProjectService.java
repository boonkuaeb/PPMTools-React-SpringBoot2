package io.boonkuaeb.ppmtool.services;

import io.boonkuaeb.ppmtool.domain.Project;
import io.boonkuaeb.ppmtool.exceptions.ProjectCodeException;
import io.boonkuaeb.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectCode(project.getProjectCode().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectCodeException("Project Code '" + project.getProjectCode().toUpperCase() + "' is duplicated");
        }
    }
}
