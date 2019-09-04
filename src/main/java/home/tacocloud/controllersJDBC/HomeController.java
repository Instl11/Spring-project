package home.tacocloud.controllersJDBC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping   //обрабатывает зарпосы корневого пути
    public String home(){
        return "home";
    }

    @PostMapping
    public String design(){
        return "redirect:/design";
    }


}
