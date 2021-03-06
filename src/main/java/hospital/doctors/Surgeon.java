package main.java.hospital.doctors;

public class Surgeon extends Doctor {
    public Surgeon(String name) {
        super(name);
    }

    public Surgeon(String name, int age) {
        super(name, age);
    }

    @Override
    public void Treat(String illness) {
        System.out.println(this.getClass().getSimpleName()+ " " + this.getName()+" has treated " + illness);

    }

    @Override
    public String Diagnostics() {
        int chance =(int) (Math.random()*100);
        if (chance>50) return "appendicitis";
        return "You are healthy";
    }
}
