package microservice.enseignant.ms_GestionEnseignant.Service;

import microservice.enseignant.ms_GestionEnseignant.DAO.EnseignantDaoJDBC;
import microservice.enseignant.ms_GestionEnseignant.model.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnseignantServiceJDBCImpl implements EnseignantServiceJDBC {
    @Autowired
    EnseignantDaoJDBC enseignantDaoJDBC;

    @Override
    public List<Enseignant> getAllEnseignants() {

        return enseignantDaoJDBC.getAllEnseignants();
    }

    @Override
    public void insertEnseignant(Enseignant enseignant) {
        enseignantDaoJDBC.insertEnseignant(enseignant);
    }

    @Override
    public Enseignant getEnseignant(int id) {
        return enseignantDaoJDBC.getEnseignant(id);
    }

    @Override
    public void deleteEnseignant(int id) {
      enseignantDaoJDBC.deleteEnseignant(id);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        return null;
    }
}
