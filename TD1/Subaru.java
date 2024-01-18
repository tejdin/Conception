package cars;

public class Subaru implements Car {
    int fuel = 0;
    String honk = "Honk honk";
    String speedUp = "Vroum vroum";

    @Override
    public void refuel() {
        fuel = 100;

    }

    @Override
    public String honk() {
        return honk;
    }

    @Override
    public String speedUp() {
        return speedUp;
    }
}
