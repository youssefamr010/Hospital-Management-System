public class Patient {
//Attributes of patient

    private String patientName;
    private String patientPhone;
    private int patientAge;
    private String patientStatus;
    private String receivedTime;
    // to count the number of patient
    static int count_patient;// static variable Shared with all objects

    public Patient() {
        count_patient++;
    }

    public Patient(String patientName, String patientPhone, int patientAge, String patientStatus, String receivedTime) {
        this.setPatientName(patientName);
        this.setPatientPhone(patientPhone);
        this.setPatientAge(patientAge);
        this.setPatientStatus(patientStatus);
        this.setReceivedTime(receivedTime);
        count_patient++;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        if(patientAge>0){
            this.patientAge = patientAge;
        }else{
            System.out.println("Please Enter the positive number!");
        }
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }

    public String getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(String receivedTime) {
        this.receivedTime = receivedTime;
    }

    public static int getCount_patient() {
        return count_patient;
    }

    public void viewInfoPatient(){
        System.out.println("The patient_name: "+this.getPatientName());
        System.out.println("The patient_age: "+this.getPatientAge());
        System.out.println("The Patient_phone: "+this.getPatientPhone());
        System.out.println("The patient_status: "+this.getPatientStatus());
        System.out.println("The patient_ReceivedTime: "+this.getReceivedTime());
    }

}