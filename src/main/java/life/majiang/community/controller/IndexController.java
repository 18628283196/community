package life.majiang.community.controller;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
=======
import org.springframework.web.bind.annotation.RequestMapping;

>>>>>>> origin/master
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
