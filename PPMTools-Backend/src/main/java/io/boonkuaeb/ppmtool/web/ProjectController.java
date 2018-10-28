package io.boonkuaeb.ppmtool.web;

import io.boonkuaeb.ppmtool.domain.Project;
import io.boonkuaeb.ppmtool.services.MapValidationErrorServices;
import io.boonkuaeb.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final MapValidationErrorServices mapValidationErrorServices;

    @Autowired
    public ProjectController(ProjectService projectService, MapValidationErrorServices mapValidationErrorServices) {
        this.projectService = projectService;
        this.mapValidationErrorServices = mapValidationErrorServices;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorServices.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Project newProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }
}
