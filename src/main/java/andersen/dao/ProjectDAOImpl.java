package andersen.dao;


import andersen.model.Project;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProjectDAOImpl implements CrudDAO<Project> {
    private final static Path PATH = Paths.get("src/main/resources/projects.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/projectsId.txt");

    private TeamDAOImpl teamDAO = new TeamDAOImpl();

    @Override
    public Project create(Project entity) throws IOException {
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
    public boolean update(Long id, Project entity) throws IOException {
        return update(id, entity, PATH);
    }

}
