package me.steliosmagalios.prologwrapper.models;

import java.util.Collection;

public class ReturnDataModel {

    private Collection<Task> tasks;
    private boolean solutionFound;

    public ReturnDataModel() {
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isSolutionFound() {
        return solutionFound;
    }

    public void setSolutionFound(boolean solutionFound) {
        this.solutionFound = solutionFound;
    }

    @Override
    public String toString() {
        return "ReturnDataModel{" +
                "tasks=" + tasks +
                ", solutionFound=" + solutionFound +
                '}';
    }
}
