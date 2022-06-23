package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private Project mapRowToProject(SqlRowSet results) {
		Project theProject = new Project();
		theProject.setId(results.getInt("project_id"));
		theProject.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			theProject.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			theProject.setToDate(results.getDate("to_date").toLocalDate());
		}
		return theProject;
	}

	@Override
	public Project getProject(int projectId) {
		Project projects = null;
		String sql = "SELECT * FROM project WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		if (results.next()) {
			projects = mapRowToProject(results);
		}
		return projects;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT * FROM project";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Project allProjects = mapRowToProject(results);
			projects.add(allProjects);
		}

		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (project_id, name, from_date, to_date) VALUES (?, ?, ?, ?) RETURNING project_id";
			Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, newProject.getId(), newProject.getName(), newProject.getFromDate(), newProject.getToDate());

			return getProject(newId);
		}
	@Override
	public void deleteProject(int projectId) {
		String sql1 = "DELETE FROM project_employee WHERE project_id = ? ";
		jdbcTemplate.update(sql1, projectId);
		String sql = "DELETE FROM project WHERE project_id = ? ";
		jdbcTemplate.update(sql, projectId);
	}
	

}
