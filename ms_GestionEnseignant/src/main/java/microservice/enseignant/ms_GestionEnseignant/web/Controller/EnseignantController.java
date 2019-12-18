package microservice.enseignant.ms_GestionEnseignant.web.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import microservice.enseignant.ms_GestionEnseignant.repository.EnseignantDao;
import microservice.enseignant.ms_GestionEnseignant.model.Enseignant;
import microservice.enseignant.ms_GestionEnseignant.web.Exception.EnseignantIntrouvableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Api( description = "API pour les operations CRUD sur les Enseignants.")
@RestController
@RequestMapping("/enseignants1")
public class EnseignantController {
    @Autowired
    private EnseignantDao ensDAO;
    @Autowired
    public EnseignantController(EnseignantDao ensDAOService) {
        this.ensDAO=ensDAOService;
    }

     //--------------------------------------------------------------------------------------µ
    @ApiOperation(value = "Ajouter un enseignant")
    @PostMapping("/add")
    public Enseignant addEnseigant(@RequestBody Enseignant enseignant){
        return   ensDAO.save(enseignant);
    }

    //--------------------------------------------------------------------------------------µ

    @ApiOperation(value = "Mise à jours des info sur un enseignant")
    @PutMapping(value="/update/{ens_id}")
    public Enseignant updateEnseignant(@PathVariable("ens_id") int ensId, @RequestBody Enseignant enseignant){
        Optional<Enseignant> enseignant1=ensDAO.findById(ensId);
       Enseignant e= enseignant1.get();
       e.setPrenomEnseignant(enseignant.getPrenomEnseignant());
       e.setNomEnseignant(enseignant.getNomEnseignant());
       e.setSpecialiteEnseignant(enseignant.getSpecialiteEnseignant());
       e.setStatusEnseignant(enseignant.getStatusEnseignant());
       return ensDAO.save(e);
    }

    //--------------------------------------------------------------------------------------µ
    @ApiOperation(value = "Supprimer un enseignant")
    @DeleteMapping(value="/delete/{idEns}")
    public List<Enseignant> deleteEnseignant(@PathVariable("idEns") int id){
    ensDAO.deleteById(id);
    return  ensDAO.findAll();
    }
    //--------------------------------------------------------------------------------------µ

    @ApiOperation(value = "Récupère liste de tout les  enseignants ")
    @GetMapping(value="/all")
    public List<Enseignant> listEnseigant(){
        return ensDAO.findAll();
    }
//--------------------------------------------------------------------------------------µ

    @ApiOperation(value = "Récupère l'enseignant avec cet id")
    @GetMapping(value="/{idEns}")
    public String findEnseigantByID(@PathVariable("idEns") int id) {
        Optional<Enseignant> ens=ensDAO.findById(id);
        if(ens.isPresent()==false) throw new EnseignantIntrouvableException("L'enseignant avec l'id " + id + " est INTROUVABLE!!!");
        return ens.get().toString();
    }


}
