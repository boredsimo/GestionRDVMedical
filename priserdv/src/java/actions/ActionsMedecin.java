package actions;

import com.crosemont.priserdv.model.DAO.PatientImpDAO;
import com.crosemont.priserdv.model.entities.Medecin;

import java.util.List;

public class ActionsMedecin {

    public static List<Medecin> medecins;
    public static Medecin medecin;
    private static final MedecinImplDAO DAO = new MedecinImplDAO();

    public static List<Medecin> findAll() {
        medecins = DAO.findAll();
        return medecins;
    }

    public static List<Medecin> findBySpecialization(int specializationID) {
        medecins = DAO.findBySpecialization(specializationID);
        return medecins;
    }

    public static List<Medecin> findByClinic(int clinicId) {
        medecins = DAO.findByClinic(clinicId);
        return medecins;
    }

    public static Medecin findById(int id) {
        medecin = DAO.findById(id);
        return medecin;
    }

    public static Medecin findByName(String nom) {
        medecin = DAO.findByName(nom);
        return medecin;
    }

	
    public static Medecin findByNumeroMedecin(int numero){
        medecin = DAO.findByNumeroMedecin(numero);
        return medecin;
    }

    public static Medecin findByaddresseRue(String addresseRue){
        medecin = DAO.findByaddresseRue(addresseRue);
        return medecin;
    }

    public static Medecin existsByEmailAndPassword(String email, String motDePasse) {
        medecin = DAO.existsByEmailAndPassword(email, password);
        return medecin;
    }

    
    public static boolean update (Medecin medecin) {
        boolean retour;
        retour = DAO.update(medecin);
        return retour;
    }


    public static boolean deleteMedecin(int id) {
        boolean retour;
        retour = DAO.delete(id);
        return retour;
    }

    public static boolean ajouterUnMedecin(Medecin medecin){
        boolean retour;
        retour = DAO.create(medecin);
        return retour;
    }

    public static void chercherClinique(){
        DAO.create(medecin);

    }

}
