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
        private static RestTemplate restTemplate = new RestTemplate();
        private final static String BASE_URL = "http://localhost:8080/student/saveStudentDetails";

    public static boolean saveStudentDetails(Student student)
    {
        ResponseEntity<Boolean> postResponse = restTemplate.postForEntity(BASE_URL, student, Boolean.class);

        if(postResponse.getStatusCode().equals(HttpStatus.OK))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
