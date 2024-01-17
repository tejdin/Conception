package trafficlight;

public class TrafficLightApp {

	public static void main(String[] args) {

		TrafficLight light = new TrafficLight();
		TrafficLightTextManager textManager = new TrafficLightTextManager();
		light.addObserver( textManager );

		light.onOff();
		for ( int i=0 ; i<5 ; ++i )
			light.switchColor();

		light.setSwitchColorStrategy( new SwitchGermany( light.getColor() ) );

		for ( int i=0 ; i<5 ; ++i )
			light.switchColor();

		light.setSwitchColorStrategy( new SwitchGreenRed() );

		for ( int i=0 ; i<5 ; ++i )
			light.switchColor();

	}

}
