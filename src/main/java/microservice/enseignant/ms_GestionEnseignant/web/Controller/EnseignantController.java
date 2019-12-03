package microservice.enseignant.ms_GestionEnseignant.web.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import microservice.enseignant.ms_GestionEnseignant.DAO.EnseignantDao;
import microservice.enseignant.ms_GestionEnseignant.model.Enseignant;
import microservice.enseignant.ms_GestionEnseignant.web.Exception.EnseignantIntrouvableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Api( description = "API pour les operations CRUD sur les Enseignants.")
@RestController
public class EnseignantController {

    @Autowired
    private EnseignantDao ensDAO;

    @Autowired
    public EnseignantController(EnseignantDao ensDAOService) {
        this.ensDAO=ensDAOService;
    }
    @ApiOperation(value = "Récupère liste de tout les  enseigants ")
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
    @ApiOperation(value = "Récupère l'enseignant avec cet id")
    @GetMapping(value="/enseignants/{id}")
    public String findEnseigantByID(@PathVariable int id) {
        Optional<Enseignant> ens=ensDAO.findById(id);
        if(ens.isPresent()==false) throw new EnseignantIntrouvableException("L'enseignant avec l'id " + id + " est INTROUVABLE!!!");
        return ens.get().toString();
    }
    @ApiOperation(value = "Supprimer un enseignant")
    @DeleteMapping(value="/enseignants/delete/{id}")
    public void deleteEnseignant(@PathVariable int id){
    ensDAO.deleteEnsignsByIdEns(id);
    }

    @ApiOperation(value = "Ajouter un enseignant")
    @PostMapping("/enseignants/add")
    public Enseignant addEnseigant(@RequestBody Enseignant enseignant){
        ensDAO.save(enseignant);
        return  enseignant;
    }
    @ApiOperation(value = "Mise à jours des info sur un enseignant")
    @PutMapping(value="/enseignants/update")
    public void updateEnseignant(@RequestBody Enseignant enseignant){
    ensDAO.save(enseignant);
    }


}
