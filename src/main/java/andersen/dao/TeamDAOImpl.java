package andersen.dao;

import andersen.model.Team;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TeamDAOImpl implements CrudDAO<Team> {
    private final static Path PATH = Paths.get("src/main/resources/teams.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/teamsId.txt");

    private DeveloperDAOImpl developerDAO = new DeveloperDAOImpl();

    @Override
    public Team create(Team entity) throws IOException {
        return create(entity, PATH, PATH_ID);
    }

    @Override
    public void delete(Long id) throws IOException {
        delete(id, PATH);
    }

    @Override
    public String read(Long id) throws IOException {
        return read(id, PATH);
    }

    @Override
    public boolean update(Long id, Team entity) throws IOException {
        return update(id, entity, PATH);
    }

}
