package home.tacocloud.resttemplatetesting;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "greeting", produces = MediaType.APPLICATION_JSON_VALUE)
public class NameController {

    @GetMapping
    public ResponseEntity<String> getName(@RequestParam(defaultValue = "No name") String name) {
        String result = "Welcome to our shop, dear " + name;
        if (name.equals("Dimon")) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}









