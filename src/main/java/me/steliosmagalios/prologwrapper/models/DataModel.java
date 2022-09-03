package me.steliosmagalios.prologwrapper.models;

import java.util.Arrays;

public class DataModel {

    private Lecture[] lectures;
    private Professor[] professors;
    private Group[] groups;
    private Room[] rooms;

    public DataModel() {}

    public Lecture[] getLectures() {
        return lectures;
    }

    public void setLectures(Lecture[] lectures) {
        this.lectures = lectures;
    }

    public Professor[] getProfessors() {
        return professors;
    }

    public void setProfessors(Professor[] professors) {
        this.professors = professors;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "lectures=" + Arrays.toString(lectures) +
                ", professors=" + Arrays.toString(professors) +
                ", groups=" + Arrays.toString(groups) +
                ", rooms=" + Arrays.toString(rooms) +
                '}';
    }
}
