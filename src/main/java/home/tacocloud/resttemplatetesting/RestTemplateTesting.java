package home.tacocloud.resttemplatetesting;

import home.tacocloud.Taco;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestTemplateTesting {


    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        Taco taco = restTemplate.getForObject("http://localhost:8080/api/tacos/{id}",
                Taco.class, 1);
        System.out.println(taco);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Taco> entity = new HttpEntity<>(headers);
        ResponseEntity<Taco> response = restTemplate.exchange("http://localhost:8080/api/tacos/{id}", HttpMethod.GET, entity, Taco.class, 1);
        HttpStatus statusCode = response.getStatusCode();
        System.out.println(statusCode.value());



        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);
        headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Taco taco1 = new Taco();
        taco1.setName("Hello");  taco1.setIngredients(null);

        HttpEntity<Taco> entity1 = new HttpEntity<>(taco1, headers1);

        Taco taco2 = restTemplate.postForObject("http://localhost:8080/api/tacos/", entity1, Taco.class);

        if (taco2 != null){
            System.out.println("Taco created");
        } else {
            System.out.println("Smth went wrong");
        }

    }
}
