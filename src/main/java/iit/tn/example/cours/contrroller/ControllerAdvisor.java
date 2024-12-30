package iit.tn.example.cours.contrroller;

import iit.tn.example.cours.exception.CompteNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CompteNotFoundException.class)
    public String handleCompteNotFoundException
}
