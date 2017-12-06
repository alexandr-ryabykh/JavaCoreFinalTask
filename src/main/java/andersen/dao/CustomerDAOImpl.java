package andersen.dao;

import andersen.model.Customer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomerDAOImpl implements CrudDAO<Customer> {
    private final static Path PATH = Paths.get("src/main/resources/customers.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/customersId.txt");

    @Override
    public Customer create(Customer entity) throws IOException {
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
    public boolean update(Long id, Customer entity) throws IOException {
        return update(id, entity, PATH);
    }

}
