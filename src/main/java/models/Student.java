package models;

import java.util.Objects;

//
public class Student {
    private String fNumber;
    private String name;
    private String lastName;
    private String speciality;
    private int vote;

    public Student() {
    }

    public Student(String fNumber, String name, String lastName, String speciality) {
        this.fNumber = fNumber;
        this.name = name;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    public Student(String fNumber, String name, String lastName, String speciality, int vote) {
        this(fNumber, name, lastName, speciality);
        this.vote = 1;
    }

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getVote() {
        return vote;
    }

    public void setVote() {
        vote++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return vote == student.vote && Objects.equals(fNumber, student.fNumber) && Objects.equals(name, student.name) && Objects.equals(lastName, student.lastName) && Objects.equals(speciality, student.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fNumber, name, lastName, speciality, vote);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fNumber='" + fNumber + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", vote=" + vote +
                '}';
    }
}
