package ru.job4j.oop;

public class Engineer extends Profession {
    private int salary;
    private String project;
    private String projectStatus;

    public Engineer() {}

    public Engineer(String name, String surname, String education, String birthday,
                    int salary, String project, String projectStatus) {
        super(name, surname, education, birthday);
        this.salary = salary;
        this.project = project;
        this.projectStatus = projectStatus;
    }

    public int workingHours(){
        return 0;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
