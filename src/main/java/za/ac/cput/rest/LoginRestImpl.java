package za.ac.cput.rest;

/**
 * LoginRestImpl.java
 * Rest implementation for the Login Gui
 * Author: Jason Jaftha (217009301)
 * Date: 6 October 2021
 */

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.entity.Login;

public class LoginRestImpl {

    //Attributes
        private static RestTemplate restTemplate = new RestTemplate(); //Use rest template to send http requests
        private final static String BASE_URL1 = "http://localhost:8080/login/getLoginDetails"; //Url endpoint to get login details
        private final static String BASE_URL2 = "http://localhost:8080/login/saveRegistrationDetails"; //Url endpoint to save registration details

    public static boolean getLoginDetails(String username, String password)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE); //Set the accept header and content type

        UriComponentsBuilder queryParams = UriComponentsBuilder.fromHttpUrl(BASE_URL1) //Add the query params needed for this request
        .queryParam("username", username)
        .queryParam("password", password);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Boolean> response = restTemplate.exchange(queryParams.build().toUriString(), HttpMethod.POST, entity, boolean.class); //Create the request

        if(response.getBody()) //Return true/false based on the response received
        {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean saveRegistrationDetails(Login login)
    {
        ResponseEntity<Boolean> postResponse = restTemplate.postForEntity(BASE_URL2, login, Boolean.class); //Create the request

        if(postResponse.getStatusCode().equals(HttpStatus.OK)) //Return true/false based on the response received
        {
            return true;
        }
        else {
            return false;
        }
    }
}
