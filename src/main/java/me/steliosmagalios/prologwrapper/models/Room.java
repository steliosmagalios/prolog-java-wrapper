package me.steliosmagalios.prologwrapper.models;

import java.util.Arrays;
import java.util.Collection;

public class Room {

    private Integer id;
    private String type;
    private Integer capacity;
    private Collection<Integer> availability;

    public Room() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Collection<Integer> getAvailability() {
        return availability;
    }

    public void setAvailability(Collection<Integer> availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", availability=" + availability +
                '}';
    }
}
