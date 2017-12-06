package andersen.controller;

import andersen.dao.CustomerDAOImpl;
import andersen.dao.ProjectDAOImpl;
import andersen.model.Customer;
import andersen.model.Project;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CustomerController {

    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    private ProjectDAOImpl projectDAO = new ProjectDAOImpl();

    public boolean create(String firstName, String lastName, String address, Set<Long> ids) throws IOException {
        Set<Project> projects = new HashSet<>();

        for (Long id : ids) {
            if (!projectDAO.verifyId(id))
                return false;
            projects.add(projectDAO.getById(id));
        }
        customerDAO.create(new Customer(firstName, lastName, address, projects));
        return true;
    }

    public String read(Long id) throws IOException {
        return customerDAO.read(id);
    }

    public boolean update(Long id, String firstName, String lastName, String address, Set<Long> ids) throws IOException {
        Set<Project> projects = new HashSet<>();

        for (Long idd : ids) {
            if (!projectDAO.verifyId(idd))
                return false;
            projects.add(projectDAO.getById(idd));
        }

        return customerDAO.update(id, new Customer(firstName, lastName, address, projects));
    }

    public void delete(Long id) throws IOException {
        customerDAO.delete(id);
    }

    public boolean verifyId(Long id) throws IOException {
        return customerDAO.verifyId(id);
    }
}
