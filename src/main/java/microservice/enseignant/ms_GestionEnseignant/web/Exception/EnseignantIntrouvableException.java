package microservice.enseignant.ms_GestionEnseignant.web.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnseignantIntrouvableException extends RuntimeException {
    public EnseignantIntrouvableException(String s) {
        super(s);
    }
}
