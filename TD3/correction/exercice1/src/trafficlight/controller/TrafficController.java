package trafficlight.controller;

import trafficlight.model.SwitchFrance;
import trafficlight.model.SwitchGreenRed;
import trafficlight.model.TrafficLight;
import trafficlight.model.SwitchGermany;

public class TrafficController {

	private TrafficLight _light;

	public TrafficController( TrafficLight light ) {
		_light = light;
	}

	public void switchToFrenchTrafficLight() {
		_light.setSwitchColorStrategy( new SwitchFrance() );
	}

	public void switchToGermanTrafficLight() {
		_light.setSwitchColorStrategy( new SwitchGermany( _light.getColor() ) );
	}

	public void switchToBicolorTrafficLight() {
		_light.setSwitchColorStrategy( new SwitchGreenRed() );
	}

	public void run( Integer nbIterations, Integer sleepTime ) {
		try {
			for ( int i=0 ; i<nbIterations ; ++i ) {
				_light.switchColor();
				Thread.sleep(sleepTime);
			}
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
	}
	public void nextColor() {
		_light.switchColor();
	}

	public void onOff() {
		_light.onOff();
	}

}
