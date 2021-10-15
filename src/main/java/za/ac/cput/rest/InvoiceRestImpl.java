package za.ac.cput.rest;

/**
 * Author: ??
 * Description: Rest implementation for the Invoice gui
 * File: InvoiceRestImpl.java
 * Date: 14 October 2021
 */


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.entity.Invoice;

import java.util.Set;

public class InvoiceRestImpl {

    //Attributes
        private static RestTemplate restTemplate = new RestTemplate(); //Use rest template to send http requests
        private final static String BASE_URL1 = "http://localhost:8080/invoice/getInvoice"; //Url endpoint to get invoice details
        private final static String BASE_URL2 = "http://localhost:8080/invoice/saveInvoice"; //Url endpoint to save invoice details
        private static Set<Invoice> invoiceList;

    public static Set<Invoice> getFoodList()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Invoice>> response = restTemplate.exchange(BASE_URL1, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Invoice>>() {});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            invoiceList = response.getBody();
            return invoiceList;
        }

        return null;
    }

    public static boolean saveInvoice(String studentNumber, String eventCode, String totalPrice)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE); //Set the accept header and content type

        UriComponentsBuilder queryParams = UriComponentsBuilder.fromHttpUrl(BASE_URL2) //Add the query params needed for this request
                .queryParam("studentNumber", studentNumber)
                .queryParam("eventCode", eventCode)
                .queryParam("totalPrice", totalPrice);

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
}
