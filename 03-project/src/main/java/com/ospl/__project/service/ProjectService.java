package com.ospl.__project.service;

import com.ospl.__project.dto.Project;
import com.ospl.__project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public Project addProject(Project project){
        return repository.save(project);
    }

    public Project getProject(int id){
        return repository.findById(id).get();
    }

    public Project updateProject(Project project){
        return repository.save(project);
    }

    public Project updateProjectDesc(String desc, int id){
        Project project = getProject(id);
        project.setDescription(desc);
        return repository.save(project);
    }

    public String getProjectByName(String name){
        return repository.findByName(name);
    }

    public String deleteProjectByName(String name){
        repository.deleteByName(name);
        return "Project "+name+" Removed";
    }

    public String deleteProject(int id){
        repository.deleteById(id);
        return "Project Deleted";
    }

    public List<Project> getAllProjects(){
        return repository.findAll();
    }

    public String deleteAllProjects(){
        repository.deleteAll();
        return "Deleted All Projects";
    }
}
