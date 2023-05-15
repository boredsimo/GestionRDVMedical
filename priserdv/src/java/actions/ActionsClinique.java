package actions;


import com.crosemont.priserdv.model.DAO.CliniqueImpDAO;
import com.crosemont.priserdv.model.entities.Clinique;


import java.util.List;

public class ActionsClinique {
    public static List<Clinique> cliniques;
    public static Clinique clinique;
    private static final CliniqueImplDAO DAO = new CliniqueImplDAO();

    public static List<Clinique> findAll() {
        cliniques = DAO.findAll();
        return cliniques;
    }

    public static Clinique findById(int id) {
        clinique = DAO.findById(id);
        return clinique;
    }

    public static Clinique findByName(String nom) {
        clinique = DAO.findByName(nom);
        return clinique;
    }

    public static Clinique findByEmail(String email) {
	  clinique = DAO.findByEmail(email);
        return clinique;
    }

    public static Clinique findByaddresseRue(String addresseRue){
        clinique = DAO.findByaddresseRue(addresseRue);
        return clinique;
    }

    public static Clinique existsByEmailAndPassword(String email, String motDePasse) {
        clinique = DAO.existsByEmailAndPassword(email, password);
        return clinique;
    }


    public static boolean updateClinique(Clinique clinique) {
        boolean retour = false;
        retour = DAO.update(clinique);
        return retour;
    }

    public static boolean deleteClinique(int id) {
        boolean retour = false;
        retour= DAO.delete(id);
        return retour;
    }

    public static boolean ajouterUneClinique(Clinique clinique){
        boolean retour = false;
        retour =  DAO.create(clinique);
        return retour; 
    }
}
