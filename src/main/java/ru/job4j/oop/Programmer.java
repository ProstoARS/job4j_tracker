package ru.job4j.oop;

public class Programmer extends Engineer {
    private int pricePerHour;
    private int tasksCompleted;

    public Programmer(String name, String surname, String education, String birthday,
                      int salary, String project, String projectStatus, int pricePerHour, int tasksCompleted) {
        super(name, surname, education, birthday, salary, project, projectStatus);
        this.pricePerHour = pricePerHour;
        this.tasksCompleted = tasksCompleted;
    }

    public void efficiency() {
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(int tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

}
