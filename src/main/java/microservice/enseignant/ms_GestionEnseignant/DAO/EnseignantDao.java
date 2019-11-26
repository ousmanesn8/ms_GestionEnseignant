package microservice.enseignant.ms_GestionEnseignant.DAO;

import microservice.enseignant.ms_GestionEnseignant.model.Enseignant;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EnseignantDao extends JpaRepository<Enseignant,Integer> {
    @Modifying
    @Transactional
    @Query("delete from Enseignant ens where ens.idEns = ?1")
    void deleteEnsignsByIdEns(int id);

    @Transactional
    @Query("Select ens.idEns, ens.nom, ens.prenom, ens.specialite, ens.status from Enseignant ens where ens.specialite like :speciali")
    List<Enseignant> findEnsignsBySpecialite(@Param("speciali") String spec);

}
