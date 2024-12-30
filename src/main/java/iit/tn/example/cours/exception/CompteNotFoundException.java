package iit.tn.example.cours.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.IOException;

public class CompteNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CompteNotFoundException(String message) {
        super(message);
    }

}
