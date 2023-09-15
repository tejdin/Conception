package cars.Feu;

public class StrategyDE implements Strategy {
    public Color ColeurAvantOrange = null;
    @Override
    public Color changeCouleur( Color couleur) {

        if (couleur.equals(Color.RED)) {
            ColeurAvantOrange = couleur;
            return Color.ORANGE;
        } else if (couleur.equals(Color.ORANGE)) {
            if (ColeurAvantOrange.equals(Color.RED)) {
                return Color.GREEN;
            } else {
                return Color.RED;
            }
        }
        else {
            return Color.RED;
        }
    }

}
