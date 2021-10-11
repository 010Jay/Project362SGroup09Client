package za.ac.cput.rest;

/**
 * EntertainmentRestImpl.java
 * Rest implementation for the Entertainment Gui
 * Author: ??
 * Date: 8 October 2021
 */

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Entertainment;
import za.ac.cput.entity.Food;

import java.util.Set;

public class EntertainmentRestImpl {

    private static RestTemplate restTemplate = new RestTemplate();
    private final static String BASE_URL = "http://localhost:8080/entertainment/getEntertainment";
    private static Set<Entertainment> eventList;

    public static Set<Entertainment>  getEntertainmentList()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);

        ResponseEntity<Set<Entertainment>> postResponse = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Entertainment>>() {});

        if(postResponse.getStatusCode().equals(HttpStatus.OK))
        {
            eventList = postResponse.getBody();
            return eventList;
        }
        else {
            return null;
        }
    }
}
