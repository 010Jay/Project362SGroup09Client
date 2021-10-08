package za.ac.cput.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Food;

import java.util.Set;

public class FoodRestImpl {

    private static RestTemplate restTemplate = new RestTemplate();
    private final static String BASE_URL = "http://localhost:8080/food/getFoodList";
    private static Set<Food> foodList;

    public static Set<Food> getFoodList()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Food>> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Food>>() {});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
           foodList = response.getBody();
           return foodList;
        }

        return null;
    }

    public Food[] getFoodBasedOnCategory(String category)
    {
        int i = 0;
        Food[] food = new Food[foodList.size()];

        for(Food f : foodList)
        {
            if(category.equals(f.getCategory())) {
                food[i] = f;
                i++;
            }
        }

        return food;
    }

    //Save order to invoiceLine??

}
