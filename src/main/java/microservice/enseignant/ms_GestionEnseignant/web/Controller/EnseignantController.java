package microservice.enseignant.ms_GestionEnseignant.web.Controller;

import microservice.enseignant.ms_GestionEnseignant.DAO.EnseignantDao;
import microservice.enseignant.ms_GestionEnseignant.model.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnseignantController {

    @Autowired
    private EnseignantDao ensDAO;

    @Autowired
    public EnseignantController(EnseignantDao ensDAOService) {
        this.ensDAO=ensDAOService;
    }

    @RequestMapping(value="/enseignants",method = RequestMethod.GET)
    public MappingJacksonValue listEnseigant(){
        Iterable<Enseignant> enseignants=ensDAO.findAll();
        MappingJacksonValue mapJVal=new MappingJacksonValue(enseignants);
        return mapJVal;
    }
/*
    @GetMapping(value="/enseignants/specialite/{specialite}")
    public String listEnseigantParSpecialite(String specialite){
        List<Enseignant> listenseignant=ensDAO.findEnsignsBySpecialite(specialite);
        String ret="";
        for (Enseignant e:listenseignant) {
            ret =ret +"\n "+e.toString();
        }
        return ret;
    }
*/
    @GetMapping(value="/enseignants/{id}")
    public String findEnseigantByID(@PathVariable int id){
        Optional<Enseignant> ens=ensDAO.findById(id);
        return ens.get().toString();
    }

    @DeleteMapping(value="/enseignants/delete/{id}")
    public void deleteEnseignant(@PathVariable int id){
    ensDAO.deleteEnsignsByIdEns(id);
    }

    @PostMapping("/enseignants/addEnseignant")
    public Enseignant addEnseigant(@RequestBody Enseignant enseignant){
        ensDAO.save(enseignant);
        return  enseignant;
    }
    @PutMapping(value="/enseignants/updateEnseignant")
    public void updateEnseignant(@RequestBody Enseignant enseignant){
    ensDAO.save(enseignant);
    }


}
