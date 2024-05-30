package com.ospl.__project.controller;

import com.ospl.__project.dto.Project;
import com.ospl.__project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    public Project addProject(@RequestBody Project project){
        return service.addProject(project);
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable int id){
        return service.getProject(id);
    }

    @GetMapping("/name/{name}")
    public String getProjectByName(@PathVariable String name){
        return service.getProjectByName(name);
    }

    @PutMapping
    public Project updateProject(@RequestBody Project project){
        return service.updateProject(project);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable int id){
        return service.deleteProject(id);
    }

    @DeleteMapping("/name/{name}")
    public String deleteProjectByName(@PathVariable String name){
        return service.deleteProjectByName(name);
    }

    @PutMapping("/desc/{id}")
    public Project updateDescriptionById(@RequestParam String desc, @PathVariable int id){
        return service.updateProjectDesc(desc,id);
    }

    @GetMapping
    public List<Project> getAllStudents(){
        return service.getAllProjects();
    }

    @DeleteMapping
    public String deleteAllProjects(){
        return service.deleteAllProjects();
    }
}
