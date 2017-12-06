package andersen.controller;

import andersen.dao.SkillDAOImpl;
import andersen.model.Skill;

import java.io.IOException;

public class SkillController {

    private SkillDAOImpl dao = new SkillDAOImpl();

    public boolean create(String name) throws IOException {
        Skill skill = dao.create(new Skill(name));

        return skill != null;
    }

    public String read(Long id) throws IOException {
        return dao.read(id);
    }

    public boolean update(Long id, String name) throws IOException {
        return dao.update(id, new Skill(name));
    }

    public void delete(Long id) throws IOException {
        dao.delete(id);
    }

    public boolean verifyId(Long id) throws IOException {
        return dao.verifyId(id);
    }
}
