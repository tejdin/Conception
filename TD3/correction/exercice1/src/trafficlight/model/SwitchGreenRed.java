package trafficlight.model;

public class SwitchGreenRed implements SwitchColorStrategy {

	public SwitchGreenRed() {}

	@Override
	public LightColor switchColor( LightColor currentColor ) {
		LightColor newColor = currentColor;
		switch (currentColor) {
			case GREEN:
				newColor = LightColor.RED;
				break;
			case RED:
				newColor = LightColor.GREEN;
				break;
			case ORANGE:
			default:
				break;
		}
		return newColor;
	}

}
