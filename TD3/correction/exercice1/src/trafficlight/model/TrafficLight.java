package trafficlight.model;

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

	protected void notifyOnOff() {
		for ( TrafficLightObserver observer : _observers ) {
			observer.updateOnOff( _isOn );
		}
	}

	protected void notifyChangeColor() {
		for ( TrafficLightObserver observer : _observers ) {
			observer.updateColor( _color );
		}
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
		notifyOnOff();
	}

	public void switchColor() {
		_color = _switchAlgorithm.switchColor(_color);
		notifyChangeColor();
	}

	public void setSwitchColorStrategy( SwitchColorStrategy algorithm ) {
		_switchAlgorithm = algorithm;
	}

}
