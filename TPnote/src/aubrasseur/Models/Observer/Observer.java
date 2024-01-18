package aubrasseur.Models.Observer;

import aubrasseur.Models.Bierre;
import aubrasseur.Models.Tarte;

import java.util.List;

public interface Observer {
    public void updateTotal(double total);

    public void updateAffichage(List<Bierre> bierres, List<Tarte> tartes);
    public void updateTotalBierre(double totalBierre);
    public void updateTotalTarte(double totalTarte);
    public void updateTables(int tables);

}
