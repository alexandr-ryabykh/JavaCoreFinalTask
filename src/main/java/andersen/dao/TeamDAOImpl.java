package andersen.dao;

import andersen.model.Developer;
import andersen.model.Team;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class TeamDAOImpl implements CrudDAO<Team> {
    private final static Path PATH = Paths.get("src/main/resources/teams.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/util/teamsId.txt");

    private DeveloperDAOImpl developerDAO = new DeveloperDAOImpl();

    @Override
    public Team create(Team entity) throws IOException {
        return create(entity, PATH, PATH_ID);
    }

    @Override
    public String read(Long id) throws IOException {
        return read(id, PATH);
    }

    @Override
    public boolean update(Long id, Team entity) throws IOException {
        return update(id, entity, PATH);
    }

    @Override
    public void delete(Long id) throws IOException {
        delete(id, PATH);
    }

    @Override
    public boolean verifyId(Long id) throws IOException {
        return verifyId(id, PATH);
    }

    public Team getById(Long id) throws IOException {
        String teamString = read(id);
        String[] strings = teamString.split(";");
        String name = strings[1];

        Set<Developer> developers = new HashSet<>();
        String[] developersId = strings[2].split(",");
        for (String idString : developersId) {
            developers.add(developerDAO.getById(Long.parseLong(idString)));
        }

        Team team = new Team(name, developers);
        team.setId(id);
        return team;
    }
}
