package io.boonkuaeb.ppmtool.exceptions;

public class ProjectCodeExceptionResponse {
    private String projectCode;

    public ProjectCodeExceptionResponse(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
}
