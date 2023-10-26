package trafficlight.view;

import trafficlight.model.LightColor;
import trafficlight.model.TrafficLightObserver;

public class TrafficLightTextManager implements TrafficLightObserver {
	public TrafficLightTextManager() {}

	@Override
	public void updateOnOff( Boolean isOn ) {
		System.out.println( "Is on : " + isOn + System.lineSeparator() );
	}

	@Override
	public void updateColor( LightColor newColor ) {
		System.out.println( "Color : " + newColor + System.lineSeparator() );
	}
}
