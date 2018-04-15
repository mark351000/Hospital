package hospital;

import hospital.doctors.Doctor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Terminal {

    private Hospital ownerHospital;

    public Terminal(Hospital ownerHospital) {
        this.ownerHospital = ownerHospital;
    }

    public void Velcome() {

        System.out.println("Hello. It is hospital's terminal. ");
        choice();

    }

     public void choice(){
         System.out.println(" Press 1 - visit doctor " +
                 "\n Press 2 - sign up for a doctor's appointment " +
                 "\n Press 3 - doctors timetable" +
                 "\n Press 4 - make a donation" +
                 "\n Press 5 - exit" +
                 "\n Press:");
            try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            switch (Integer.valueOf(bufferedReader.readLine())) {
                    case 1:
                        System.out.println(1);
                        break;
                    case 2:
                        System.out.println(2);
                        break;
                    case 3:
                        watchDoctorTimetable();
                        break;
                    case 4:
                        this.makeDonation();
                        break;
                    case 5:
                        break;
                    default: throw new ClassCastException();

                }
                bufferedReader.close();

        }catch (Exception e){
            System.out.println("Incorrect data. Try again.");
            this.choice();
        }
    }
    public void makeDonation(){
        System.out.println("Enter the amount");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String donetion = bufferedReader.readLine();
            ownerHospital.addDonations(Double.valueOf(donetion));
            System.out.println("Thank you for the donation " + Double.valueOf(donetion));
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("Incorrect data. Try again.");
            this.makeDonation();
        }

        this.choice();

    }
    public void watchDoctorTimetable(){
        System.out.println(choceDoctor().getRozklad());
        choice();

    }
    public Doctor choceDoctor(){
        Doctor chocenDoctor = null;
        System.out.println("Doctors");
        for (int i =0; i<ownerHospital.getHospitalDoctors().size(); i++){
            System.out.println(i+" "+ownerHospital.getHospitalDoctors().get(i).getClass().getSimpleName() + " " + ownerHospital.getHospitalDoctors().get(i).getName());
        }
        System.out.println("Press:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            chocenDoctor = ownerHospital.getHospitalDoctors().get(Integer.valueOf(bufferedReader.readLine()));
        }catch (Exception e){
            System.out.println("Incorrect data. Try again.");
            this.choceDoctor();
        }
        return  chocenDoctor;
    }

}
