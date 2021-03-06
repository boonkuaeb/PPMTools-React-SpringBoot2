package io.boonkuaeb.ppmtool.services;

import io.boonkuaeb.ppmtool.domain.Project;
import io.boonkuaeb.ppmtool.exceptions.ProjectCodeException;
import io.boonkuaeb.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            throw new ProjectCodeException("Project Code '" + project.getProjectCode().toUpperCase() + "' already exists");
        }
    }

    public Project findByProjectCode(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode.toUpperCase());
        if (project == null) {
            throw new ProjectCodeException("Project Code '" + projectCode.toUpperCase() + "' doesn't exists");
        }

        return project;
    }

    public Iterable<Project> findProjects()
    {
        return projectRepository.findAll();
    }

    public void deleteByProjectCode(String projectCode)
    {
        Project project = projectRepository.findByProjectCode(projectCode.toUpperCase());
        if(project == null)
        {
            throw new ProjectCodeException("Project Code '" + projectCode.toUpperCase() + "' doesn't exists");
        }
        projectRepository.delete(project);
    }

    public Project updateProject(Project project)
    {
        Optional<Project> projectOptional = projectRepository.findById(project.getId());
        if (!projectOptional.isPresent())
        {
            throw new ProjectCodeException("Project  doesn't exists");
        }
        return this.saveOrUpdateProject(project);
    }
}
