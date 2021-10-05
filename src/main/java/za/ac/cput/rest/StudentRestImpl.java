package za.ac.cput.rest;

/**
 * StudentRestImpl.java
 * Rest implementation for the Student Gui
 * Author: Jason Jaftha (217009301)
 * Date: 6 October 2021
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Student;

public class StudentRestImpl {

    //Attributes
        private static RestTemplate restTemplate = new RestTemplate(); //Use rest template to send http requests
        private final static String BASE_URL = "http://localhost:8080/student/saveStudentDetails"; //Url endpoint for submitting student's details

    public static boolean saveStudentDetails(Student student)
    {
        ResponseEntity<Boolean> postResponse = restTemplate.postForEntity(BASE_URL, student, Boolean.class); //Create the request

        if(postResponse.getStatusCode().equals(HttpStatus.OK)) //Return true/false based on the response received
        {
            return true;
        }
        else {
            return false;
        }
    }
}
