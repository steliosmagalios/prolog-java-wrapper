package me.steliosmagalios.prologwrapper.models;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.CompoundTermImpl;

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

    public static CompoundTerm toProlog(Professor item) {
        return new CompoundTermImpl(new Object[]{
                "professor",
                item.id,
                item.availability
        });
    }

    public static Professor fromProlog(CompoundTerm item) {
        // Check the arity and the functor
        if (!(item.arity() == 2 && item.functor().equals("professor"))) {
            return null;
        }

        // Create the object
        Professor professor = new Professor();
        professor.setId(((Integer) item.arg(1)));
        professor.setAvailability(((Collection<Integer>) item.arg(2)));

        return professor;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", availability=" + availability +
                '}';
    }
}
