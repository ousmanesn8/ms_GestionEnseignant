package microservice.enseignant.ms_GestionEnseignant.DAO;

import microservice.enseignant.ms_GestionEnseignant.model.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EnseignantDaoJDBCImpl extends JdbcDaoSupport implements EnseignantDaoJDBC {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        String req="select * from Enseignant";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(req);
        List<Enseignant> result = new ArrayList<Enseignant>();
        for (Map<String, Object> row : rows) {
            Enseignant enseignant = new Enseignant();
            enseignant.setIdEns((int) row.get("idEns"));
            enseignant.setNom((String) row.get("nom"));
            enseignant.setPrenom((String) row.get("prenom"));
            enseignant.setStatus((String) row.get("status"));
            enseignant.setSpecialite((String) row.get("specialite"));
            result.add(enseignant);
        }
        return result;
    }

    @Override
    public void insertEnseignant(Enseignant enseignant) {
        String sql = "INSERT INTO Enseignant " + "(idEns, nom, prenom, status, specialite) VALUES (?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[] { enseignant.getIdEns(),enseignant.getNom(),enseignant.getPrenom(), enseignant.getStatus(),  enseignant.getSpecialite() });
    }

    @Override
    public Enseignant getEnseignant(int id) {
        String sql ="select * from Enseignant where idEns = "+id;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        Enseignant enseignant = new Enseignant();
        for (Map<String, Object> row : rows) {
            enseignant.setIdEns((int) row.get("idcours"));
            enseignant.setNom((String) row.get("nom"));
            enseignant.setPrenom((String) row.get("prenom"));
            enseignant.setStatus((String) row.get("status"));
            enseignant.setSpecialite((String) row.get("specialite"));
        }
        return enseignant;
    }

    @Override
    public void deleteEnseignant(int id) {
      String sql = "delete from Enseignant where idEns= "+id;
        Object[] params = {id};
      getJdbcTemplate().update(sql,params);
    }
//---------------------------------------------------------------------------
    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        return null;
    }
}
