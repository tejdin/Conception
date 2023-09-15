package cars.Feu;

public class

StrategyFr implements Strategy {
    @Override
    public Color changeCouleur( Color couleur) {
        if (couleur.equals(Color.RED)) {
            return Color.GREEN;
        } else if (couleur.equals(Color.GREEN)) {
            return Color.ORANGE;
        } else {
            return Color.RED;
        }
    }
}


