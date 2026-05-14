package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Project;
import com.example.capstone2.Repository.ProjectRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public void addProject(Project project) {
        if (project == null) {
            throw new ApiException("project  not found");
        }
        if (userRepository.findUserById(project.getClientId()) == null) {
            throw new ApiException("Client not found");
        }
        if (userRepository.findUserById(project.getClientId()).getRole().equals("FREELANCER")){
            throw new ApiException("unauthorized  to User");
        }
        projectRepository.save(project);
    }

    public void updateProject(Integer id, Project project) {
        Project oldProject = projectRepository.findProjectById(id);
        if (oldProject == null) {
            throw new ApiException("project  not found");
        }
        if (userRepository.findUserById(project.getClientId()) == null) {
            throw new ApiException("Client not found");
        }
        if (userRepository.findUserById(project.getClientId()).getRole().equals("FREELANCER")){
            throw new ApiException("unauthorized  to User");
        }
        oldProject.setClientId(project.getClientId());
        oldProject.setTitle(project.getTitle());
        oldProject.setDescription(project.getDescription());
        oldProject.setBudget(project.getBudget());
        oldProject.setStatus(project.getStatus());
        oldProject.setDeadline(project.getDeadline());
        projectRepository.save(oldProject);
    }

    public void deleteProject(Integer id) {
        Project project = projectRepository.findProjectById(id);
        if (project == null) {
            throw new ApiException("project  not found");
        }
        projectRepository.delete(project);
    }
}
