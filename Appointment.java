public class Appointment {

    private String patientName;
    private String patientPhone;
    private int patientAge;
    private String patientStatus;

    private String doctorName;

    private String appointmentTime;

    private double billAmount;
    private boolean billPaid;
    private static final double TAX_RATE = 0.10; // 10%


    private static int appointmentCount = 0;

    public Appointment(String patientName, String patientPhone, int patientAge, String patientStatus,
                       String doctorName, String appointmentTime, double billAmount) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        setPatientAge(patientAge);
        this.patientStatus = patientStatus;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
        this.billAmount = billAmount;
        this.billPaid = false;
        appointmentCount++;
    }


    public String getPatientName() {
        return patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        if (patientAge > 0) this.patientAge = patientAge;
        else throw new IllegalArgumentException("Age must be positive!");
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public boolean isBillPaid() {
        return billPaid;
    }

    public static int getAppointmentCount() {
        return appointmentCount;
    }


    public double getBillWithTax() {
        return billAmount + (billAmount * TAX_RATE);
    }


    public void receivePayment() {
        if (billPaid) {
            System.out.println("Bill is already paid by " + patientName + ".");
        } else {
            System.out.println("Doctor " + doctorName +
                    " received payment of $" + getBillWithTax() +
                    " from patient " + patientName + ".");
            billPaid = true;
        }
    }


    public void viewAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Doctor: " + doctorName);
        System.out.println("Patient: " + patientName + " | Age: " + patientAge +
                " | Phone: " + patientPhone + " | Status: " + patientStatus);
        System.out.println("Appointment Time: " + appointmentTime);
        System.out.println("Bill (before tax): $" + billAmount);
        System.out.println("Bill (with tax): $" + getBillWithTax());
        System.out.println("Bill Paid: " + (billPaid ? "Yes" : "No"));
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "patientName='" + patientName + '\'' +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientAge=" + patientAge +
                ", patientStatus='" + patientStatus + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", billAmount=" + billAmount +
                ", billPaid=" + billPaid +
                '}';

    }

}