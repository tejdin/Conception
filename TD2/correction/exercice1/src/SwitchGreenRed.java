package trafficlight;

public class SwitchGreenRed implements SwitchColorStrategy {

	public SwitchGreenRed() {}

	@Override
	public LightColor switchColor( LightColor currentColor ) {
		LightColor newColor;
		switch (currentColor) {
			case GREEN:
				newColor = LightColor.RED;
				break;
			case RED:
				newColor = LightColor.GREEN;
				break;
			case ORANGE:
			default:
				newColor = currentColor;
				break;
		}
		return newColor;
	}

}