package home.tacocloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")   //обрабатывает зарпосы корневого пути
    public String home(){
        return "home";
    }
}
