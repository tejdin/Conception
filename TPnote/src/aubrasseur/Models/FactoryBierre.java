package aubrasseur.Models;

public class FactoryBierre {
public static Bierre createBierre(String nom) {
switch (nom) {
        case "BierreSansAlcool":
            return new BierreSansAlcool("BierreSansAlcool", 5.5, TypeBierre.sansAlcool);
        case "IndianPale":
            return new IndianPale("IndianPale", 6, TypeBierre.avecAlcool);
        default:
            return null;
    }
}
}
