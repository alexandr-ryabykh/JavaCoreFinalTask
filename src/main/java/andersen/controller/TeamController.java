package andersen.controller;

import andersen.dao.DeveloperDAOImpl;
import andersen.dao.TeamDAOImpl;
import andersen.model.Developer;
import andersen.model.Team;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TeamController {

    private TeamDAOImpl teamDAO = new TeamDAOImpl();
    private DeveloperDAOImpl developerDAO = new DeveloperDAOImpl();

    public boolean create(String name, Set<Long> ids) throws IOException {

        Set<Developer> developers = new HashSet<>();

        for (Long id : ids) {
            if (!developerDAO.verifyId(id))
                return false;
            developers.add(developerDAO.getById(id));
        }

        teamDAO.create(new Team(name, developers));

        return true;
    }

    public String read(Long id) throws IOException {

        return teamDAO.read(id);
    }

    public boolean update(Long id, String name, Set<Long> ids) throws IOException {

        Set<Developer> developers = new HashSet<>();

        for (Long idd : ids) {
            if (!developerDAO.verifyId(idd))
                return false;
            developers.add(developerDAO.getById(idd));
        }

        return teamDAO.update(id, new Team(name, developers));
    }

    public void delete(Long id) throws IOException {
        teamDAO.delete(id);
    }

    public boolean verifyId(Long id) throws IOException {
        return teamDAO.verifyId(id);
    }

}
