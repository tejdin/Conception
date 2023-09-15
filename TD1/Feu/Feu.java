package cars.Feu;


import javax.swing.plaf.PanelUI;

public class Feu {
    public Color couleur = Color.RED;

    Strategy strategy;
    public String etat = "eteint";

    public Feu(Strategy strategy) {
        this.strategy = strategy;
    }



    public void changeEtat() {
        if (etat == "eteint") {
            etat = "allume";
        } else {
            etat = "eteint";
        }
    }
    public void changeCouleur() {
        couleur = strategy.changeCouleur(couleur);

    }

    public String getCouleur() {
        return couleur.toString();
    }

    public String getEtat() {
        return etat;
    }
}
