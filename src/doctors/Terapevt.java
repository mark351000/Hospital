package doctors;

public class Terapevt extends Doctor {

    public Terapevt(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Terapevt{" +
                "name='" + name + '\'' +
                '}';
    }
}
