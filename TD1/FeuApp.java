package cars;

public class FeuApp {
    public static void main(String[] args) {
        Feu feu = new Feu();
        System.out.println("Le feu est " + feu.getEtat() );
        feu.changeEtat();
        System.out.println("Le feu est " + feu.getEtat() );

        for (int i = 0; i < 10; i++) {
            feu.changeCouleur();
            System.out.println("Le feu est " + feu.getCouleur() );
        }
    }
}
