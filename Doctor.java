import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String doctorName;
    private String doctorSpeciality;
    private String doctorID;
    private double doctorSalary;
    private String doctorDepartment;
    private List<Patient> patientList;

    public Doctor() {
        patientList = new ArrayList<>();
    }

    public Doctor(String doctorName, String doctorSpeciality, String doctorID, double doctorSalary, String doctorDepartment) {
        this.setDoctorName(doctorName);
        this.setDoctorSpeciality(doctorSpeciality);
        this.setDoctorID(doctorID);
        this.setDoctorSalary(doctorSalary);
        this.setDoctorDepartment(doctorDepartment);
        this.patientList = new ArrayList<>();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public double getDoctorSalary() {
        return doctorSalary;
    }

    public void setDoctorSalary(double doctorSalary) {
        if (doctorSalary >= 0) {
            this.doctorSalary = doctorSalary;
        } else {
            System.out.println("Salary must be a positive number.");
        }
    }

    public String getDoctorDepartment() {
        return doctorDepartment;
    }

    public void setDoctorDepartment(String doctorDepartment) {
        this.doctorDepartment = doctorDepartment;
    }

    public void addPatient(Patient patient) {
        if (patient != null) {
            patientList.add(patient);
            System.out.println("Patient added to Dr. " + doctorName);
        }
    }

    public List<Patient> checkPatients() {
        return patientList;
    }

    public void showAllPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients assigned to Dr. " + doctorName);
        } else {
            System.out.println("Patients of Dr. " + doctorName + ":");
            for (Patient p : patientList) {
                p.viewInfoPatient();
                System.out.println("-----------------------------");
            }
        }
    }

    public boolean removePatientByName(String name) {
        for (Patient p : patientList) {
            if (p.getPatientName().equalsIgnoreCase(name)) {
                patientList.remove(p);
                System.out.println("Patient " + name + " removed.");
                return true;
            }
        }
        System.out.println("Patient not found.");
        return false;
    }

    public boolean updatePatientStatus(String name, String newStatus) {
        for (Patient p : patientList) {
            if (p.getPatientName().equalsIgnoreCase(name)) {
                p.setPatientStatus(newStatus);
                System.out.println("Updated status of " + name + " to: " + newStatus);
                return true;
            }
        }
        System.out.println("Patient not found.");
        return false;
    }

    public Prescription writePrescriptionForPatient(Patient patient, String medications, String notes) {
        if (patientList.contains(patient)) {
            Prescription prescription = new Prescription(patient, this, medications, notes);
            System.out.println("Prescription created successfully for " + patient.getPatientName());
            return prescription;
        } else {
            System.out.println("Access denied. This patient is not assigned to Dr. " + doctorName);
            return null;
        }
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>();
    }

    public void viewInfoDoctor() {
        System.out.println("Doctor Name: " + doctorName);
        System.out.println("Speciality: " + doctorSpeciality);
        System.out.println("ID: " + doctorID);
        System.out.println("Salary: " + doctorSalary);
        System.out.println("Department: " + getDoctorDepartment());
        System.out.println("Number of Patients: " + patientList.size());
    }
}
