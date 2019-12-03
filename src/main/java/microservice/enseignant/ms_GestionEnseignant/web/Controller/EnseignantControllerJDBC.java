package microservice.enseignant.ms_GestionEnseignant.web.Controller;

import microservice.enseignant.ms_GestionEnseignant.Service.EnseignantServiceJDBC;
import microservice.enseignant.ms_GestionEnseignant.model.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnseignantControllerJDBC {
    @Autowired
    EnseignantServiceJDBC enseignantServiceJDBC;

    @RequestMapping(value = "/enseigants", method = RequestMethod.GET)
    public List<Enseignant> getEnseignants(){
        return  enseignantServiceJDBC.getAllEnseignants();
    }
    @RequestMapping(value = "/insertEnseigant", method = RequestMethod.POST)
    public void insertEnseignant(@RequestBody Enseignant enseignant) {
        enseignantServiceJDBC.insertEnseignant(enseignant);
    }

    @RequestMapping(value = "/getEnseigant/{id}", method = RequestMethod.GET)
    public Enseignant getEnseigant(@PathVariable int id) {
        return enseignantServiceJDBC.getEnseignant(id);
    }
    @RequestMapping(value = "/deleteEnseigant/{id}", method = RequestMethod.DELETE)
    public void deleteEnseigant(@PathVariable int id) {
         enseignantServiceJDBC.deleteEnseignant(id);
    }
//UPDATE

}
