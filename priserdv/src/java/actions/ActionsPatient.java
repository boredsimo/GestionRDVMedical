package actions;


import com.crosemont.priserdv.model.DAO.PatientImpDAO;
import com.crosemont.priserdv.model.entities.Patient;

import java.util.List;

public class  ActionsPatient {
    public static List<Patient> patients;
    public static Patient patient;
    private static final PatientImplDAO DAO = new PatientImplDAO();

    public static List<Patient> findAll() {
        patients = DAO.findAll();
        return patients;
    }

    public static List<Patient> findAllByDoctor(int id) {
        patients = DAO.findAllByDoctor(id);
        return patients;
    }

    public static Patient findById(int id) {
        patient = DAO.findById(id);
        return patient;
    }

    public static Patient isExist(String email, String motDePasse) {
        patient = DAO.isExist(email, password);
        return patient;
    }

    public static boolean isEmailExist(String email) {
        return DAO.isEmailExist(email);
    }

    public static boolean isNAMxist(String nam) {
        return DAO.isNAMxist(nam);
    }

    public static boolean isNumExist(String num) {
        return DAO.isNumExist(String num));
    }

    public static boolean updatePatient(Patient patient) {
        return DAO.update(patient);
    }

    public static boolean deletePatient(int id) {
        boolean retour = false;
        retour = DAO.delete(id);
        return retour;
    }

    public static boolean ajouterUnPatient(Patient patient){
        boolean retour = false;
        retour = DAO.create(patient);
        return retour;
    }
}
