package trafficlight;

import trafficlight.model.TrafficLight;
import trafficlight.controller.TrafficController;
import trafficlight.view.TrafficLightTextManager;
import trafficlight.view.TrafficLightWindow;

public class TrafficLightApp {

	public static void main(String[] args) {

		TrafficLight light = new TrafficLight();
		TrafficController controller = new TrafficController( light );

		TrafficLightTextManager textManager = new TrafficLightTextManager();
		TrafficLightWindow window = new TrafficLightWindow( light, controller );
		light.addObserver( textManager );
		light.addObserver( window );

		//controller.onOff();
		// controller.run( 5, 1000 );
		// controller.switchToGermanTrafficLight();
		// controller.run( 5, 1000 );
		// controller.switchToBicolorTrafficLight();
		// controller.run( 5, 1000 );
		// controller.onOff();
	}

}
