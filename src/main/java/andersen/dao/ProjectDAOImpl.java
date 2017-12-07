package andersen.dao;


import andersen.model.Project;
import andersen.model.Team;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class ProjectDAOImpl implements CrudDAO<Project> {
    private final static Path PATH = Paths.get("src/main/resources/projects.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/util/projectsId.txt");

    private TeamDAOImpl teamDAO = new TeamDAOImpl();

    @Override
    public Project create(Project entity) throws IOException {
        return create(entity, PATH, PATH_ID);
    }

    @Override
    public String read(Long id) throws IOException {
        return read(id, PATH);
    }

    @Override
    public boolean update(Long id, Project entity) throws IOException {
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

    public Project getById(Long id) throws IOException {
        String project = read(id);
        String[] strings = project.split(";");
        String name = strings[1];
        Set<Team> teams = new HashSet<>();
        String[] teamId = strings[2].split(",");

        for (String idString : teamId) {
            teams.add(teamDAO.getById(Long.parseLong(idString)));
        }

        Project proj = new Project(name, teams);
        proj.setId(id);
        return proj;
    }
}
