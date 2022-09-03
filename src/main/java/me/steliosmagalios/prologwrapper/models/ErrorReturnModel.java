package me.steliosmagalios.prologwrapper.models;

public class ErrorReturnModel {

    private String error;

    public ErrorReturnModel() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorReturnModel{" +
                "message='" + error + '\'' +
                '}';
    }
}
