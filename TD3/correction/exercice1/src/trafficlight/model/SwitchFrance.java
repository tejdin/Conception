package trafficlight.model;

public class SwitchFrance implements SwitchColorStrategy {

	public SwitchFrance() {}

	@Override
	public LightColor switchColor( LightColor currentColor ) {
		LightColor newColor = currentColor;
		switch (currentColor) {
			case GREEN:
				newColor = LightColor.ORANGE;
				break;
			case ORANGE:
				newColor= LightColor.RED;
				break;
			case RED:
				newColor = LightColor.GREEN;
				break;
			default:
				break;
		}
		return newColor;
	}

}
