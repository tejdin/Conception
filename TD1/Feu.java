package cars;

import javax.swing.plaf.PanelUI;

public class Feu {
    public String couleur = "rouge";
    public String etat = "eteint";

    public void changeEtat() {
        if (etat == "eteint") {
            etat = "allume";
        } else {
            etat = "eteint";
        }
    }
    public void changeCouleur() {
        if (couleur == "rouge") {
            couleur = "vert";
        }
        else if (couleur == "vert") {
            couleur = "orange";
        }
        else {
            couleur = "rouge";
        }
    }

    public String getCouleur() {
        return couleur;
    }

    public String getEtat() {
        return etat;
    }
}
