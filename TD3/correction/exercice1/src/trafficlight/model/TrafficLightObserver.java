package trafficlight.model;

public interface TrafficLightObserver {
	public void updateOnOff( Boolean isOn );
	public void updateColor( LightColor newColor );
}
