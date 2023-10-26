package trafficlight;

public class TrafficLightTextManager implements TrafficLightObserver {
	public TrafficLightTextManager() {}

	@Override
	public void updateTrafficLight( TrafficLight trafficLight ) {
		System.out.println(
				"Is on : " + trafficLight.isOn() + System.lineSeparator() +
				"Color : " + trafficLight.getColor() + System.lineSeparator() );
	}
}
