/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

/**
 *
 * @author alicj
 */
public class Teacher extends Person {
    
    private String courseName;

    //konstruktor kompatybilny z klasą nadrzedną Person
    public Teacher(String firstName, String lastName, String emailAddress, String courseName) {
        super(firstName, lastName, emailAddress); //konstruktor klasy bazowej
        this.courseName = courseName;
    }
    
    //metoda umożliwiająca dostęp do pola courseName
    public String getcourseName() {
        return courseName;
    }
    
    //metoda pozwalająca na ustawienie wartości pola courseName
    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }
    
}
