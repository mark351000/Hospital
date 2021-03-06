package main.java.hospital;

import main.java.hospital.doctors.Doctor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {

    private Hospital ownerHospital;
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public Terminal(Hospital ownerHospital) {
        this.ownerHospital = ownerHospital;
    }

    public void Velcome() {

        System.out.println("Hello. It is hospital's terminal.\nYou can visit doctor now or set time-slot on the next week");
        choice();

    }

    private void choice(){
         System.out.println(" Press 1 - visit doctor " +
                 "\n Press 2 - sign up for a doctor's appointment " +
                 "\n Press 3 - doctors timetable" +
                 "\n Press 4 - make a donation" +
                 "\n Press 5 - exit" +
                 "\n Press:");
            try {

            switch (Integer.valueOf(bufferedReader.readLine())) {
                    case 1:
                        this.visitDoctor();
                        break;
                    case 2:
                        this.setVisitToDoctor();
                        break;
                    case 3:
                        this.watchDoctorTimetable();
                        break;
                    case 4:
                        this.makeDonation();
                        break;
                    case 5:
                        break;
                    default: throw new ClassCastException();
                    }
                    }catch (Exception e){
                System.out.println("Incorrect data. Try again.");
                this.choice();
            }
    }

    private void makeDonation(){
        System.out.println("Enter the amount (usd)");
        try {
            String donetion = bufferedReader.readLine();
            ownerHospital.addDonations(Double.valueOf(donetion));
            System.out.println("Thank you for the donation " + Double.valueOf(donetion)+ " usd. " + "Total amount " + String.format("%(.2f", ownerHospital.getDonations())+ " usd");
        }catch (Exception e){
            System.out.println("Incorrect data. Try again.");
            this.makeDonation();
        }
        this.choice();
    }

    private void watchDoctorTimetable(){
        System.out.println(choiceDoctor().getRozklad());
        choice();
    }

    private void visitDoctor(){
        Doctor chosenDoctor = choiceDoctor();
        String illness;
        System.out.println("Did you know your illness?\n 1 Yes, 2 No");
        try {
            String answer = bufferedReader.readLine();
            if (Integer.valueOf(answer)==1){
                System.out.println("Enter your illness");
                chosenDoctor.Treat(bufferedReader.readLine());
            } else if (Integer.valueOf(answer)==2){
                illness = chosenDoctor.Diagnostics();
                System.out.println("You had " + illness);
                if (!illness.equals("You are healthy")) chosenDoctor.Treat(illness);
            } else throw new IOException();

        } catch (IOException e) {
            System.out.println("Incorrect data. Try again.");
            this.visitDoctor();
        }
        this.choice();
    }

    private   void setVisitToDoctor(){
        Doctor chosenDoctor = choiceDoctor();
        String surname;
        Integer day, hour;
        try {
            System.out.println("Enter your surname (no more 10 symbols)");
            surname = bufferedReader.readLine();
            if (surname.length()>10) throw new Exception();
            System.out.println("Please choose the day\n 1 Monday, 2 Tuesday, 3 Wednesday, 4 Thursday, 5 Friday, 6 Saturday, 7 Sunday");
            day = Integer.valueOf(bufferedReader.readLine());
            System.out.println("Please choose the hour\n 1 8.00-9.00, 2 9.00-10.00, 3 10.00-11.00, 4 11.00-12.00, 5 12.00-13.00, 6 13.00-14.00, 7 14.00-15.00, 8 15.00-16.00, 9 16.00-17.00, 10 17.00-18.00 ");
            hour = Integer.valueOf(bufferedReader.readLine());
            if (chosenDoctor.getRozklad().getTimeTable()[hour][day]==null){
                chosenDoctor.getRozklad().setVisitInTimeTable(surname, day, hour);
                System.out.println("Time-slot has selected");
            } else System.out.println("Time-slot isn't fre");
        } catch (Exception e) {
            System.out.println("Incorrect data. Try again.");
            this.setVisitToDoctor();
        }
        this.choice();
    }

    private Doctor choiceDoctor(){
        Doctor chosenDoctor = null;
        System.out.println("Choose a doctor");
        for (int i =0; i<ownerHospital.getHospitalDoctors().size(); i++){
            System.out.println(i+" "+ownerHospital.getHospitalDoctors().get(i).getClass().getSimpleName() + " " + ownerHospital.getHospitalDoctors().get(i).getName());
        }
        System.out.println("Press:");
        try {
            chosenDoctor = ownerHospital.getHospitalDoctors().get(Integer.valueOf(bufferedReader.readLine()));
        }catch (Exception e){
            System.out.println("Incorrect data. Try again.");
            return this.choiceDoctor();
        }
        return  chosenDoctor;
    }
}
