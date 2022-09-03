package me.steliosmagalios.prologwrapper.models;

import java.util.Collection;

public class ReturnDataModel {

    private Collection<Task> tasks;

    public ReturnDataModel() {
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "ReturnDataModel{" +
                "tasks=" + tasks +
                '}';
    }
}
