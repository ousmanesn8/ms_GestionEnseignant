package microservice.enseignant.ms_GestionEnseignant.DAO;

import microservice.enseignant.ms_GestionEnseignant.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantDao extends JpaRepository<Enseignant,Integer> {
}
