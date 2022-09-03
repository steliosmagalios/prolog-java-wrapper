package me.steliosmagalios.prologwrapper.models;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.CompoundTermImpl;

import java.util.Arrays;
import java.util.Collection;

public class Group {

    private Integer id;
    private Integer memberCount;
    private Collection<Integer> overlapping;

    public Group() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public Collection<Integer> getOverlapping() {
        return overlapping;
    }

    public void setOverlapping(Collection<Integer> overlapping) {
        this.overlapping = overlapping;
    }

    public static CompoundTerm toProlog(Group item) {
        return new CompoundTermImpl(new Object[]{
                "group",
                item.id,
                item.memberCount,
                item.overlapping
        });
    }

    public static Group fromProlog(CompoundTerm item) {
        // Check the arity and the functor
        if (!(item.arity() == 3 && item.functor().equals("group"))) {
            return null;
        }

        // Create the object
        Group group = new Group();
        group.setId(((Integer) item.arg(1)));
        group.setMemberCount((Integer) item.arg(2));
        group.setOverlapping((Collection<Integer>) item.arg(3));

        return group;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", memberCount=" + memberCount +
                ", overlapping=" + overlapping +
                '}';
    }
}
