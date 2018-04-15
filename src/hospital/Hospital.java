package hospital;

import hospital.doctors.*;

import java.util.ArrayList;

public class Hospital {
    private static ArrayList<Doctor> HospitalDoctors = new ArrayList<Doctor>();
    private static double donations = 0;
    public static void main(String[] args) {
        makeDoctors();
        Terminal terminal = new Terminal();
        terminal.Velcome();


    }

    private static void makeDoctors(){
        HospitalDoctors.add(new Dentist("Vasul"));
    }

}
