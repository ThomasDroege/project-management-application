package com.thomas.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.thomas.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

}
