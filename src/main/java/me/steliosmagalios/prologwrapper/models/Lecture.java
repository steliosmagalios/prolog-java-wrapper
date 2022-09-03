package me.steliosmagalios.prologwrapper.models;

import java.util.Arrays;

public class Lecture {

    private int id;
    private int duration;
    private String roomType;
    private int[] professors;
    private int[] groups;

    public Lecture() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int[] getProfessors() {
        return professors;
    }

    public void setProfessors(int[] professors) {
        this.professors = professors;
    }

    public int[] getGroups() {
        return groups;
    }

    public void setGroups(int[] groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", duration=" + duration +
                ", roomType='" + roomType + '\'' +
                ", professors=" + Arrays.toString(professors) +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
