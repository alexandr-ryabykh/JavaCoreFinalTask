package andersen.dao;

import andersen.model.Id;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;


public interface CrudDAO<T extends Id> {

    T create(T entity) throws IOException;

    String read(Long id) throws IOException;

    boolean update(Long id, T entity) throws IOException;

    void delete(Long id) throws IOException;

    boolean verifyId(Long id) throws IOException;

    default T create(T entity, Path path, Path pathId) throws IOException {
        Long previousId = Long.parseLong(Files.readAllLines(pathId).get(0));
        Long currentId = previousId + 1;
        entity.setId(currentId);
        List<String> id = Collections.singletonList(currentId.toString());
        Files.write(pathId, id, StandardCharsets.UTF_8);

        List<String> lines = Collections.singletonList(entity.toString());
        Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

        return entity;
    }

    default String read(Long id, Path path) throws IOException {
        List<String> entity = Files.readAllLines(path);
        String result = null;
        for (String s : entity) {
            if (s.split(";")[0].equals(id.toString())) {
                result = s;
                break;
            }
        }
        return result;
    }

    default boolean update(Long id, T entity, Path path) throws IOException {
        List<String> entities = Files.readAllLines(path);
        String previousString;
        for (String s : entities) {
            if (s.split(";")[0].equals(id.toString())) {
                previousString = s;
                entity.setId(id);
                Files.write(path,
                        new String(Files.readAllBytes(path), StandardCharsets.UTF_8)
                                .replace(previousString, entity.toString())
                                .getBytes(StandardCharsets.UTF_8));
                return true;
            }
        }
        return false;
    }

    default void delete(Long id, Path path) throws IOException {
        List<String> entities = Files.readAllLines(path);
        String previousString;
        for (String s : entities) {
            if (s.split(";")[0].equals(id.toString())) {
                previousString = s;
                Files.write(path,
                        new String(Files.readAllBytes(path), StandardCharsets.UTF_8)
                                .replace(previousString, "").trim()
                                .getBytes(StandardCharsets.UTF_8));
                break;
            }
        }
    }

    default boolean verifyId(Long id, Path path) throws IOException {
        List<String> entities = Files.readAllLines(path);
        for (String s : entities) {
            if (s.split(";")[0].equals(id.toString())) {
                return true;
            }
        }
        return false;
    }
}
