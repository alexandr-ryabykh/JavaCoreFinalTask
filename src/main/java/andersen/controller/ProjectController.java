package andersen.controller;

import andersen.dao.ProjectDAOImpl;
import andersen.dao.TeamDAOImpl;
import andersen.model.Project;
import andersen.model.Team;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ProjectController {

    private ProjectDAOImpl projectDAO = new ProjectDAOImpl();
    private TeamDAOImpl teamDAO = new TeamDAOImpl();

    public boolean create(String name, Set<Long> ids) throws IOException {
        Set<Team> teams = new HashSet<>();

        for (Long id : ids) {
            if (!teamDAO.verifyId(id))
                return false;
            teams.add(teamDAO.getById(id));
        }

        projectDAO.create(new Project(name, teams));

        return true;
    }

    public String read(Long id) throws IOException {
        return projectDAO.read(id);
    }

    public boolean update(Long id, String name, Set<Long> ids) throws IOException {

        Set<Team> teams = new HashSet<>();

        for (Long idd : ids) {
            if (!teamDAO.verifyId(idd))
                return false;
                teams.add(teamDAO.getById(idd));
        }

        return projectDAO.update(id, new Project(name, teams));
    }

    public void delete(Long id) throws IOException {
        projectDAO.delete(id);
    }

    public boolean verifyId(Long id) throws IOException {
        return projectDAO.verifyId(id);
    }
}
