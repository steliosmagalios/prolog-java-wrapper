package me.steliosmagalios.prologwrapper.models;

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

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", memberCount=" + memberCount +
                ", overlapping=" + overlapping +
                '}';
    }
}
