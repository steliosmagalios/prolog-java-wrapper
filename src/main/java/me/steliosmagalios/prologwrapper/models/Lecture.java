package me.steliosmagalios.prologwrapper.models;

import java.util.Arrays;
import java.util.Collection;

public class Lecture {

    private Integer id;
    private Integer duration;
    private String roomType;
    private Collection<Integer> professors;
    private Collection<Integer> groups;

    public Lecture() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Collection<Integer> getProfessors() {
        return professors;
    }

    public void setProfessors(Collection<Integer> professors) {
        this.professors = professors;
    }

    public Collection<Integer> getGroups() {
        return groups;
    }

    public void setGroups(Collection<Integer> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", duration=" + duration +
                ", roomType='" + roomType + '\'' +
                ", professors=" + professors +
                ", groups=" + groups +
                '}';
    }
}
