package hospital.doctors;

public class Dentist extends Doctor {
    public Dentist(String name) {
        super(name);
    }

    public Dentist(String name, int age) {
        super(name, age);
    }

    @Override
    public void Treat(String illness) {
        System.out.println(this.getClass().getSimpleName()+ " " + this.getName()+" has treated " + illness);

    }

    @Override
    public String Diagnostics() {
        return "You are healthy";
    }

}
