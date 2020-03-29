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
public class Person implements EmailRecipient{

    private String firstName;
    private String lastName;
    private String emailAddress;

    //konstruktor inicjujący pola firstName i lastName
    public Person(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    //metody umożliwiające dostęp do pól firstName i lastName
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    //Skoro klasa Person implementuje interfejs EmailRecipient, musi posiadać zadklarowane w nim metody - w tym przypadku jedną metodę getEmailAddress()
    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    //metody pozwalające na ustawianie wartości obu pól
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //wyświetlanie
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + emailAddress;
    }
}
