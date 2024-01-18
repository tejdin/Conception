package aubrasseur.Models;

public class FactoryTarte {
    public static Tarte createTarte( String nom) {
        return switch (nom) {
            case "TarteMunster" -> new TarteMunster("TarteMunster", 6);
            case "TarteTraditionnelle" -> new TarteTraditionnelle("TarteTraditionnelle", 5);
            case "TarteHawai" -> new TarteHawai("TarteHawai", 6.5);
            default -> null;
        };
    }
}
