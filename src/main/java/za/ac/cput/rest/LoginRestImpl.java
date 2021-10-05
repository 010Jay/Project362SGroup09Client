package za.ac.cput.rest;

/**
 * LoginRestImpl.java
 * Rest implementation for the Login Gui
 * Author: Jason Jaftha (217009301)
 * Date: 6 October 2021
 */

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class LoginRestImpl {

    //Attributes
        private static RestTemplate restTemplate = new RestTemplate();
        private final static String BASE_URL = "http://localhost:8080/login/getLoginDetails";

    public static boolean getLoginDetails(String username, String password)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder queryParams = UriComponentsBuilder.fromHttpUrl(BASE_URL)
        .queryParam("username", username)
        .queryParam("password", password);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Boolean> response = restTemplate.exchange(queryParams.build().toUriString(), HttpMethod.POST, entity, boolean.class);

        if(response.getBody())
        {
            return true;
        }
        else{
            return false;
        }
    }
}
