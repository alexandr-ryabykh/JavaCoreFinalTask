package model;

import java.util.Set;

public class Team {
    private Long id;
    private String name;
    private Set<Developer> developers;

    public Team(Long id, String name, Set<Developer> developers) {
        this.id = id;
        this.name = name;
        this.developers = developers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Developer dev : developers) {
            builder.append(dev.getLastName()).append(",");
        }
        String developersString = builder.substring(0, builder.length() - 1);
        return id + ";" + name + ";" + developersString;
    }
}
