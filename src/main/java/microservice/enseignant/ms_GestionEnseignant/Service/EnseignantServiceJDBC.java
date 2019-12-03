package microservice.enseignant.ms_GestionEnseignant.Service;

import microservice.enseignant.ms_GestionEnseignant.model.Enseignant;

import java.util.List;

public interface EnseignantServiceJDBC {
    List<Enseignant> getAllEnseignants();
    void insertEnseignant(Enseignant enseignant);
    Enseignant getEnseignant(int id);
    void deleteEnseignant(int id);
    Enseignant updateEnseignant(Enseignant enseignant);
}
