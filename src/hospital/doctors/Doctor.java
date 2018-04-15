package hospital.doctors;

import hospital.Rozklad;

public abstract class Doctor {
    private String name;
    private int age;
    private Rozklad rozklad;

    public abstract void Treat(String illness);
    public abstract String Diagnostics();

    public Doctor(String name) {
        this.name = name;
        this.rozklad = new Rozklad();
    }

    public Doctor(String name, int age) {
        this.name = name;
        this.age = age;
        this.rozklad= new Rozklad();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Rozklad getRozklad() {
        return rozklad;
    }

    public void setRozklad(Rozklad rozklad) {
        this.rozklad = rozklad;
    }

    @Override
    public String toString() {
        return "My name is " + name + " . I am a " + this.getClass().getSimpleName();
    }
}
