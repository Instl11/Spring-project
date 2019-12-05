package home.tacocloud.resttemplatetesting;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.*;

public class NameClientCode {
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();





        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> forEntity = template.getForEntity("http://localhost:8080/greeting?name=Dimon", String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }


        ResponseEntity<String> response = null;
        try {
            response = template.exchange("http://localhost:8080/greeting?name=Dimon", GET, entity, String.class);
            HttpStatus statusCode = response.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                System.out.println(response.getBody());
            }
        } catch (HttpClientErrorException.NotAcceptable e) {
            System.out.println("Your name is Dimon, go away piece of shit");
        } catch (ResourceAccessException c) {
            System.out.println("Unable connect to the server");
        }

        String name = "Anton";
        ResponseEntity<String> anton = template.getForEntity("http://localhost:8080/greeting", String.class, name);
        System.out.println(anton.getBody());

    }
}
