package za.ac.cput.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Beverage;
/**
 * BeverageRestImpl.java
 * Rest implementation for the Beverage Gui
 * Author: Nonhlahla Hlungwani 218160658
 * Date: 10 October 2021
 */


import java.util.Set;

public class BeverageRestImpl {

    private static RestTemplate restTemplate = new RestTemplate();
    private final static String BASE_URL = "http://localhost:8080/beverage/getBeverageList";
    private static Set<Beverage> beverageList;

    public static Set<Beverage> getBeverageList() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Beverage>> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Beverage>>() {});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            beverageList = response.getBody();
            return beverageList;
        }

        return null;
    }

    public Beverage[] getBeverageBasedOnCategory(String category)
    {
        int i = 0;
        Beverage[] beverage = new Beverage[beverageList.size()];

        for(Beverage b : beverageList)
        {
            if(category.equals(b.getCategory())) {
                beverage[i] = b;
                i++;
            }
        }

        return beverage;
    }


}
