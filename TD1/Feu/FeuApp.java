package cars.Feu;

public class FeuApp {
    public static void main(String[] args) {

        Strategy strategy = new StrategyDE();
        Feu feu = new Feu(strategy);
        System.out.println("Le feu est " + feu.getEtat() );
        feu.changeEtat();
        System.out.println("Le feu est " + feu.getEtat() );

        for (int i = 0; i < 5; i++) {
            feu.changeCouleur();
             System.out.println("Le feu est " + feu.getCouleur() );
        }
    }
}
