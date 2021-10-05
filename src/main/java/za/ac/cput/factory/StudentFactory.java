package za.ac.cput.factory;

import za.ac.cput.entity.Student;

/**
 * StudentFactory.java
 * Factory class for the Student
 * Author: Jason Jaftha (217009301)
 * Date: 13 September 2021
 **/

public class StudentFactory {

    public static Student createStudent(String studentNumber, String firstName, String lastName, String emailAddress, String phoneNumber)
    {
        return new Student.Builder().setStudentNumber(studentNumber)
                                    .setFirstName(firstName)
                                    .setLastName(lastName)
                                    .setEmailAddress(emailAddress)
                                    .setPhoneNumber(phoneNumber)
                                    .build();
    }
}
