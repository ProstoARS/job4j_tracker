package ru.job4j.oop;

public class Doctor extends Profession {
    private Pacient pacient;
    private String journal;
    private String receptionTime;
    private int salary;

    public boolean inspection(Pacient pacient){
        return false;
    }

    public String analyzes(Pacient pacient) {
        return " ";
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public String getJournal() {
        return journal;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getReceptionTime() {
        return receptionTime;
    }

    public void setReceptionTime(String receptionTime) {
        this.receptionTime = receptionTime;
    }
}
