package za.ac.cput.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Entertainment;


public class EntertainmentRestImpl {

    private static RestTemplate restTemplate = new RestTemplate();
    private final static String BASE_URL = "http://localhost:8080/entertainment/getEntertainment";

    public static boolean saveEntertainment(Entertainment entertainment)
    {
        ResponseEntity<Boolean> postResponse = restTemplate.postForEntity(BASE_URL, entertainment, Boolean.class);

        if(postResponse.getStatusCode().equals(HttpStatus.OK))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
