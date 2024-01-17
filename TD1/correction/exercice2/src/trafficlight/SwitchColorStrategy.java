package trafficlight;

interface SwitchColorStrategy {
	public LightColor switchColor( LightColor currentColor );
}