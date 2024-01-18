package aubrasseur.Models;

public abstract class Tarte {

        private String nom;
        private double prix;


        public Tarte(String nom, double prix) {
            this.nom = nom;
            this.prix = prix;
        }

        public String getNom() {
            return this.nom;
        }

        public double getPrix() {
            return this.prix;
        }
        public String desc(){
            return "Nom : " + this.nom + "Prix : " + this.prix + "\n";
        }
}
