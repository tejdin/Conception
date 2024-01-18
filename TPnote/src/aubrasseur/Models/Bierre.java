package aubrasseur.Models;

public abstract class Bierre {

    private String nom;
    private double prix;
    private TypeBierre type;

    public Bierre(String nom, double prix, TypeBierre type) {
        this.nom = nom;
        this.prix = prix;
        this.type = type;
    }

    public String getNom() {
        return this.nom;
    }

    public double getPrix() {
        return this.prix;
    }

    public TypeBierre getType() {
        return this.type;
    }

    public String desc(){
        return "Nom : " + this.nom +" " + "Prix : " + this.prix + " " + "Type : " + this.type + "\n";

    }

}
