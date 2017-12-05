package model;

import java.util.Set;

public class Project {
    private Long id;
    private String name;
    private Set<Team> teams;

    public Project(Long id, String name, Set<Team> teams) {
        this.id = id;
        this.name = name;
        this.teams = teams;
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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Team team : teams) {
            builder.append(team.getName()).append(",");
        }
        String teamsString = builder.substring(0, builder.length() - 1);
        return id + ";" + name + ";" + teamsString;
    }
}
