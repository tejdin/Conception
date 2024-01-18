package cars;

public class CarFactory {

        public static Car getCar(String carName) {
            if (carName == null) {
                return null;
            }
            if (carName.equalsIgnoreCase("FIATMULTIPLA")) {
                return new FiatMultipla();
            } else if (carName.equalsIgnoreCase("SUBARU")) {
                return new Subaru();
            } else if (carName.equalsIgnoreCase("JEEP")) {
                return new Jeep();
            }
            return null;
        }

}
