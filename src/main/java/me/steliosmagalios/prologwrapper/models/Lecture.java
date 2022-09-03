package me.steliosmagalios.prologwrapper.models;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.CompoundTermImpl;

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

    public static CompoundTerm toProlog(Lecture item) {
        return new CompoundTermImpl(new Object[]{
                "lecture",
                item.id,
                item.duration,
                item.roomType,
                item.professors,
                item.groups
        });
    }

    public static Lecture fromProlog(CompoundTerm item) {
        // Check the arity and the functor
        if (!(item.arity() == 5 && item.functor().equals("lecture"))) {
            return null;
        }

        // Create the object
        Lecture lecture = new Lecture();
        lecture.setId(((Integer) item.arg(1)));
        lecture.setDuration((Integer) item.arg(2));
        lecture.setRoomType((String) item.arg(3));
        lecture.setProfessors((Collection<Integer>) item.arg(4));
        lecture.setGroups((Collection<Integer>) item.arg(5));

        return lecture;
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
