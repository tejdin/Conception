package trafficlight;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight {

	private Boolean _isOn = false;
	private LightColor _color = LightColor.RED;
	private SwitchColorStrategy _switchAlgorithm;
	private List<TrafficLightObserver> _observers;

	public TrafficLight() {
		_switchAlgorithm = new SwitchFrance();
		_observers = new ArrayList<>();
	}

	public void addObserver( TrafficLightObserver observer ) {
		_observers.add( observer );
	}

	public void notifyObservers( TrafficLight trafficLight ) {
		for ( TrafficLightObserver observer : _observers )
			observer.updateTrafficLight( this );
	}

	public Boolean isOn() {
		return _isOn;
	}

	public LightColor getColor() {
		return _color;
	}

	public void onOff() {
		_isOn = !_isOn;
		_color = LightColor.RED;
		notifyObservers( this );
	}

	public void switchColor() {
		_color = _switchAlgorithm.switchColor(_color);
		notifyObservers( this );
	}

	public void setSwitchColorStrategy( SwitchColorStrategy algorithm ) {
		_switchAlgorithm = algorithm;
	}

}

