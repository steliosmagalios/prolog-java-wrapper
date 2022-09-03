package me.steliosmagalios.prologwrapper.models;

import java.util.Arrays;

public class Group {

    private int id;
    private int memberCount;
    private int[] overlapping;

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }


    public int[] getOverlapping() {
        return overlapping;
    }

    public void setOverlapping(int[] overlapping) {
        this.overlapping = overlapping;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", memberCount=" + memberCount +
                ", overlapping=" + Arrays.toString(overlapping) +
                '}';
    }
}
