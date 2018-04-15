package hospital.doctors;

public class Therapist extends Doctor {
    public Therapist(String name) {
        super(name);
    }

    public Therapist(String name, int age) {
        super(name, age);
    }

    @Override
    public void Treat(String illness) {
        System.out.println(this.getClass().getSimpleName() + this.getName()+" has treated " + illness);

    }

    @Override
    public String Diagnostics() {
        return "You are healthy";
    }
}
