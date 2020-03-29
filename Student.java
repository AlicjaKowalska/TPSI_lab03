/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alicj
 */
public class Student extends Person {

    private String groupId;
    private List<Double> grades = new ArrayList<>(); //lista ocen
    private double gradesAverage;

    //konstruktor kompatybilny z klasą nadrzedną Person
    public Student(String firstName, String lastName, String emailAddress, String groupId) {
        super(firstName, lastName, emailAddress); //konstruktor klasy bazowej
        this.groupId = groupId;
    }

    //metoda umożliwiająca dostęp do pola groupId
    public String getGroupId() {
        return groupId;
    }

    //metoda pozwalająca na ustawienie wartości pola groupId
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    //pobranie listy ocen
    public List<Double> getGrades() {
        return grades;
    }

    //dodanie nowej oceny do listy
    public void addGrade(double grade) {
        grades.add(grade);
    }

    //obliczanie średniej ocen
    public double getGradesAverage() {

        int size = grades.size();
        gradesAverage = 0.0;

        for (int i = 0; i < size; i++) {
            gradesAverage = gradesAverage + grades.get(i);
        }
        gradesAverage = gradesAverage / size;
        
        return gradesAverage;
    }
}
