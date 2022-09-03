package me.steliosmagalios.prologwrapper.models;

import java.util.Arrays;

public class Professor {

    private int id;
    private int[] availability;

    public Professor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getAvailability() {
        return availability;
    }

    public void setAvailability(int[] availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", availability=" + Arrays.toString(availability) +
                '}';
    }
}
