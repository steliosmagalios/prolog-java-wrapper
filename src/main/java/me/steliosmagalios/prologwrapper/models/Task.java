package me.steliosmagalios.prologwrapper.models;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.CompoundTermImpl;

public class Task {

    private Integer id;
    private Integer roomId;
    private Integer startTime;

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }


    public static CompoundTerm toProlog(Task item) {
        return new CompoundTermImpl(new Object[]{
                "task",
                item.id,
                item.roomId,
                item.startTime
        });
    }

    public static Task fromProlog(CompoundTerm item) {
        // Check the arity and the functor
        if (!(item.arity() == 3 && item.functor().equals("task"))) {
            return null;
        }

        // Create the object
        Task task = new Task();
        task.setId(((Integer) item.arg(1)));
        task.setRoomId((Integer) item.arg(2));
        task.setStartTime((Integer) item.arg(3));

        return task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "lectureId=" + id +
                ", roomId=" + roomId +
                ", startTime=" + startTime +
                '}';
    }
}
