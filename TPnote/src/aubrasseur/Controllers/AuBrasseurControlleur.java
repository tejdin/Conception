package aubrasseur.Controllers;
import aubrasseur.Models.CashDesk;
public class AuBrasseurControlleur {
    private CashDesk model;
    public AuBrasseurControlleur(CashDesk model) {
        this.model = model;
    }
    public void addBierre(String nom) {
        model.addBierre(nom);
    }
    public void addTarte(String nom) {
        model.addTarte(nom);
    }

    public void reset() {
        model.reset();
    }

    public void encaisser() {
        model.encaisser();
    }


}
