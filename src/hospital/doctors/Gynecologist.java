package hospital.doctors;

public class Gynecologist extends Doctor {
    public Gynecologist(String name) {
        super(name);
    }

    public Gynecologist(String name, int age) {
        super(name, age);
    }

    @Override
    public void Treat(String illness) {
        System.out.println(this.getClass().getSimpleName() + " " + this.getName()+" has treated " + illness);

    }

    @Override
    public String Diagnostics() {
        int chance =(int) (Math.random()*100);
        if (chance>50) return "venereal disease";
        return "You are healthy";
    }
}
