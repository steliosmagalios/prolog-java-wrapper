package me.steliosmagalios.prologwrapper.models;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.CompoundTermImpl;

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

    public static CompoundTerm toProlog(Room item) {
        return new CompoundTermImpl(new Object[]{
                "room",
                item.id,
                item.type,
                item.capacity,
                item.availability
        });
    }

    public static Room fromProlog(CompoundTerm item) {
        // Check the arity and the functor
        if (!(item.arity() == 4 && item.functor().equals("room"))) {
            return null;
        }

        // Create the object
        Room room = new Room();
        room.setId(((Integer) item.arg(1)));
        room.setType((String) item.arg(2));
        room.setCapacity((Integer) item.arg(3));
        room.setAvailability((Collection<Integer>) item.arg(4));

        return room;
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
