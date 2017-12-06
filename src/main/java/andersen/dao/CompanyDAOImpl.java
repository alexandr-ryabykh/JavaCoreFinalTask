package andersen.dao;

import andersen.model.Company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompanyDAOImpl implements CrudDAO<Company> {
    private final static Path PATH = Paths.get("src/main/resources/company.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/companyId.txt");

    @Override
    public Company create(Company entity) throws IOException {
        return create(entity, PATH, PATH_ID);
    }

    @Override
    public String read(Long id) throws IOException {
        return read(id, PATH);
    }

    @Override
    public boolean update(Long id, Company entity) throws IOException {
        return update(id, entity, PATH);
    }

    @Override
    public void delete(Long id) throws IOException {
        delete(id, PATH);
    }

}
