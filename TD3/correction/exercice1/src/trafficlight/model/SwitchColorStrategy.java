package trafficlight.model;

interface SwitchColorStrategy {
	public LightColor switchColor( LightColor currentColor );
}
