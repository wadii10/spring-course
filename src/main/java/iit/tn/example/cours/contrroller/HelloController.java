package iit.tn.example.cours.contrroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping({"/index", "/"})
    public String index(Model model){
        model.addAttribute("time", LocalTime.now());
        return "hello";
    }

    @GetMapping({"/index2"})
    public ModelAndView index2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("time", LocalTime.now());
        return modelAndView;
    }
}
