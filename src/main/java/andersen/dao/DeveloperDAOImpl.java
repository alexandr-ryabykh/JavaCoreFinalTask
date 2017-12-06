package andersen.dao;

import andersen.model.Developer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeveloperDAOImpl implements CrudDAO<Developer> {

    private final static Path PATH = Paths.get("src/main/resources/developers.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/developersId.txt");

    private SkillDAOImpl skillDAO = new SkillDAOImpl();

    @Override
    public Developer create(Developer entity) throws IOException {
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
    public boolean update(Long id, Developer entity) throws IOException {
        return update(id, entity, PATH);
    }

}