package ru.job4j.oop;

public class Builder extends Engineer {
    private String workShift;
    private int deadline;

    public Builder(String name, String surname, String education, String birthday,
                   int salary, String project, String projectStatus, String workShift, int deadline) {
        super(name, surname, education, birthday, salary, project, projectStatus);
        this.workShift = workShift;
        this.deadline = deadline;
    }

    public int estimate() {
        return 0;
    }

    public void projectDev() {
    }

    public boolean qualityBuildingMaterials() {
        return false;
    }

    public void supervisesWork() {
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getWorkShift() {
        return workShift;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }
}
