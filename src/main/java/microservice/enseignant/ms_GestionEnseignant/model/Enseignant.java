package microservice.enseignant.ms_GestionEnseignant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Enseignant {
    @Column(name = "idEns")
    @Id
    @GeneratedValue
    private int idEns;
    @Column(name = "nom")
    private  String nom;
    @Column(name = "prenom")
    private  String prenom;
    @Column(name = "status")
    private  String status;
    @Column(name = "specialite")
    private  String specialite;


    @Override
    public String toString() {
        return "Enseignant  : \n" +
                "Id         = "+idEns+",\n" +
                "Prenom     = "+nom+",\n" +
                "Nom        = "+prenom+",\n" +
                "Status     = "+status+",\n" +
                "specialite = "+specialite;
    }

    public Enseignant(){}

    public Enseignant(int idEns, String nom, String prenom, String status, String specialite) {
        this.idEns = idEns;
        this.nom = nom;
        this.prenom = prenom;
        this.status = status;
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdEns() {
        return idEns;
    }

    public void setIdEns(int idEns) {
        this.idEns = idEns;
    }
}
