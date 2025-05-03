import java.util.Date;
import java.text.SimpleDateFormat;

public class Prescription {
    private Patient patient;
    private Doctor doctor;
    private String medications;
    private String notes;
    private String dateIssued;

    public Prescription(Patient patient, Doctor doctor, String medications, String notes) {
        this.patient = patient;
        this.doctor = doctor;
        this.medications = medications;
        this.notes = notes;
        this.dateIssued = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // تاريخ اليوم
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getMedications() {
        return medications;
    }

    public String getNotes() {
        return notes;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public void updatePrescription(String medications, String notes, Doctor requestingDoctor) {
        if (doctor.equals(requestingDoctor)) {
            this.medications = medications;
            this.notes = notes;
            System.out.println("Prescription updated successfully.");
        } else {
            System.out.println("Access denied. Only the assigned doctor can update this prescription.");
        }
    }

    public void viewPrescription() {
        System.out.println("Prescription for: " + patient.getPatientName());
        System.out.println("Doctor: " + doctor.getDoctorName());
        System.out.println("Date: " + dateIssued);
        System.out.println("Medications: " + medications);
        System.out.println("Notes: " + notes);
    }
}