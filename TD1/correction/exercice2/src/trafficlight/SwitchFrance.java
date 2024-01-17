package trafficlight;

public class SwitchFrance implements SwitchColorStrategy {

	public SwitchFrance() {}

	@Override
	public LightColor switchColor( LightColor currentColor ) {
		return switch (currentColor) {
			case GREEN -> LightColor.ORANGE;
			case ORANGE -> LightColor.RED;
			case RED -> LightColor.GREEN;
			default -> currentColor;
		};
	}

}