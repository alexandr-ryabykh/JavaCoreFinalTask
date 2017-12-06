package andersen.controller;


import andersen.dao.CompanyDAOImpl;
import andersen.dao.ProjectDAOImpl;
import andersen.model.Company;
import andersen.model.Project;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CompanyController {

    private CompanyDAOImpl companyDAO = new CompanyDAOImpl();
    private ProjectDAOImpl projectDAO = new ProjectDAOImpl();

    public boolean create(String name, Set<Long> ids) throws IOException {
        Set<Project> projects = new HashSet<>();

        for (Long id : ids) {
            if (!projectDAO.verifyId(id))
                return false;
            projects.add(projectDAO.getById(id));
        }
        companyDAO.create(new Company(name, projects));
        return true;
    }

    public String read(Long id) throws IOException {
        return companyDAO.read(id);
    }

    public boolean update(Long id, String name, Set<Long> ids) throws IOException {
        Set<Project> projects = new HashSet<>();

        for (Long id0 : ids) {
            if (!projectDAO.verifyId(id0))
                return false;
            projects.add(projectDAO.getById(id0));
        }
        return companyDAO.update(id, new Company(name, projects));
    }

    public void delete(Long id) throws IOException {
        companyDAO.delete(id);
    }

    public boolean verifyId(Long id) throws IOException {
        return companyDAO.verifyId(id);
    }
}
