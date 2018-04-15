package hospital;

import hospital.doctors.*;

import java.util.ArrayList;

public class Hospital {
    private  ArrayList<Doctor> HospitalDoctors = new ArrayList<Doctor>();
    private  double donations = 0;
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.makeDoctors();
        hospital.makeTimeTables();
        hospital.setDonations();

        Terminal terminal = new Terminal(hospital);
        terminal.Velcome();
    }

    private  void makeDoctors(){
        HospitalDoctors.add(new Dentist("Vasul"));
        HospitalDoctors.add(new Gynecologist("Andriy", 42));
        HospitalDoctors.add(new Surgeon("Yura"));
        HospitalDoctors.add(new Therapist("Anton", 34));
        HospitalDoctors.add(new Traumatologist("Oleg", 37));
    }
    private void makeTimeTables(){
        for (Doctor doctor: HospitalDoctors){
            doctor.getRozklad().setVisitInTimeTable("Popovich", 5,6);
            doctor.getRozklad().setVisitInTimeTable("Popovich", 5,5);
            doctor.getRozklad().setVisitInTimeTable("Popovich", 4,6);
            doctor.getRozklad().setVisitInTimeTable("Popovich", 5,9);
            doctor.getRozklad().setVisitInTimeTable("Popovich", 7,10);
            doctor.getRozklad().setVisitInTimeTable("Popovich", 2,6);
            doctor.getRozklad().setVisitInTimeTable("Popovich", 4,1);
            doctor.getRozklad().setVisitInTimeTable("Popovich", 1,7);
        }
    }
    private void setDonations(){
        donations=Math.random()*1000;
    }

    public ArrayList<Doctor> getHospitalDoctors() {
        return HospitalDoctors;
    }

    public double getDonations() {
        return donations;
    }

    public void setHospitalDoctors(ArrayList<Doctor> hospitalDoctors) {
        HospitalDoctors = hospitalDoctors;
    }

    public void setDonations(double donations) {
        this.donations = donations;
    }
    public void addDonations(double donation){
        this.donations+=donation;
    }
}
