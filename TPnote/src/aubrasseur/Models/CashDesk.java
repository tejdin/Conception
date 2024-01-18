package aubrasseur.Models;

import aubrasseur.Models.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CashDesk {
    private List<Bierre> bierres= new ArrayList<>();
   private List<Tarte> tartes= new ArrayList<>();

   private List<Observer> observers = new ArrayList<>();

    private double total = 0;
    private double totalTarte = 0;
    private double totalBierre = 0;

    private int tables = 0;

    public void addBierre(String nom){
        Bierre bierre = FactoryBierre.createBierre(nom);
        bierres.add(bierre);
        getTotalBierre();
        notifyObservers();
    }

    public void addTarte(String nom){
        Tarte tarte = FactoryTarte.createTarte(nom);
        tartes.add(tarte);
        getTotalTarte();
        System.out.println(tartes);
        notifyObservers();
    }

    public double getTotal(){
        total = total + (totalBierre + totalTarte);
        return total;
    }
    public int getTables(){
        return tables;
    }

    public List<Bierre> getBierres(){
        return bierres;
    }

    public List<Tarte> getTartes(){
        return tartes;
    }

    public double getTotalBierre(){
        for (Bierre bierre : bierres) {
            totalBierre += bierre.getPrix();
        }
        return totalBierre;
    }

    public double getTotalTarte(){
        for (Tarte tarte : tartes) {
            totalTarte += tarte.getPrix();
        }
        return totalTarte;
    }

    public void reset(){
        bierres.clear();
        tartes.clear();
        total = 0;
        totalBierre = 0;
        totalTarte = 0;
        tables = 0;
        notifyObservers();
    }

    public void encaisser(){
        // calculer le total
        getTotal();
        tartes.clear();
        bierres.clear();
        totalBierre = 0;
        totalTarte = 0;
        tables++;
        notifyObservers();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

  public void notifyObservers(){
        for (Observer observer : observers) {
            observer.updateTotal(total);
            observer.updateTables(tables);
            observer.updateAffichage(bierres, tartes);
            observer.updateTotalBierre(totalBierre);
            observer.updateTotalTarte(totalTarte);
        }
    }
}
