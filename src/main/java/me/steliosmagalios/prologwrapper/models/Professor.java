package me.steliosmagalios.prologwrapper.models;

import java.util.Arrays;
import java.util.Collection;

public class Professor {

    private Integer id;
    private Collection<Integer> availability;

    public Professor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Integer> getAvailability() {
        return availability;
    }

    public void setAvailability(Collection<Integer> availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", availability=" + availability +
                '}';
    }
}
