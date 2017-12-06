package andersen.dao;

import andersen.model.Skill;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SkillDAOImpl implements CrudDAO<Skill> {

    private final static Path PATH = Paths.get("src/main/resources/skills.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/skillsId.txt");

    @Override
    public Skill create(Skill entity) throws IOException {
        return create(entity, PATH, PATH_ID);
    }

    @Override
    public String read(Long id) throws IOException {
        return read(id, PATH);
    }

    @Override
    public boolean update(Long id, Skill newSkill) throws IOException {
        return update(id, newSkill, PATH);
    }

    @Override
    public void delete(Long id) throws IOException {
        delete(id, PATH);
    }

}
