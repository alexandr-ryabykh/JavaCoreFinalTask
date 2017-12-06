package andersen.dao;

import andersen.model.Developer;
import andersen.model.Skill;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class DeveloperDAOImpl implements CrudDAO<Developer> {

    private final static Path PATH = Paths.get("src/main/resources/developers.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/util/developersId.txt");

    private SkillDAOImpl skillDAO = new SkillDAOImpl();

    @Override
    public Developer create(Developer entity) throws IOException {
        return create(entity, PATH, PATH_ID);
    }

    @Override
    public String read(Long id) throws IOException {
        return read(id, PATH);
    }

    @Override
    public boolean update(Long id, Developer entity) throws IOException {
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

    public Developer getById(Long id) throws IOException {

        String developerString = read(id);

        String[] strings = developerString.split(";");

        String firstName = strings[1];
        String lastName = strings[2];
        String speciality = strings[3];
        BigDecimal salary = new BigDecimal(strings[4]);
        Set<Skill> skills = new HashSet<>();

        String[] skillsId = strings[5].split(",");
        for (String idString : skillsId) {
            skills.add(skillDAO.getById(Long.parseLong(idString)));
        }

        Developer developer = new Developer(firstName, lastName, speciality, skills, salary);
        developer.setId(id);

        return developer;
    }
}