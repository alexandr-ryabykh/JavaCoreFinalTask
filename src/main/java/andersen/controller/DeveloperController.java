package andersen.controller;

import andersen.dao.DeveloperDAOImpl;
import andersen.dao.SkillDAOImpl;
import andersen.model.Developer;
import andersen.model.Skill;

import java.io.IOException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DeveloperController {

    private DeveloperDAOImpl developerDAO = new DeveloperDAOImpl();
    private SkillDAOImpl skillDAO = new SkillDAOImpl();

    public boolean create(String firstName, String lastName, String speciality,
                          Set<Long> ids, BigDecimal salary) throws IOException {

        Set<Skill> skills = new HashSet<>();

        for (Long id : ids) {
            if (!skillDAO.verifyId(id))
                return false;
            skills.add(skillDAO.getById(id));
        }

        developerDAO.create(new Developer(firstName, lastName, speciality, skills, salary));

        return true;
    }

    public String read(Long id) throws IOException {

        return developerDAO.read(id);
    }

    public boolean update(Long id, String firstName, String lastName, String speciality,
                          Set<Long> ids, BigDecimal salary) throws IOException {

        Set<Skill> skills = new HashSet<>();

        for (Long id0 : ids) {
            if (!skillDAO.verifyId(id0))
                return false;
            skills.add(skillDAO.getById(id0));
        }

        Developer developer = new Developer(firstName, lastName, speciality, skills, salary);
        return developerDAO.update(id, developer);
    }

    public void delete(Long id) throws IOException {
        developerDAO.delete(id);
    }

    public boolean verifyIf(Long id) throws IOException {
        return developerDAO.verifyId(id);
    }
}
