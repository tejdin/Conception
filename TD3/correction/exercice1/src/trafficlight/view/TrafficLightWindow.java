package trafficlight.view;

import trafficlight.model.LightColor;
import trafficlight.model.TrafficLight;
import trafficlight.model.TrafficLightObserver;
import trafficlight.controller.TrafficController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightWindow extends JFrame implements TrafficLightObserver {

	private JLabel _greenLabel;
	private JLabel _orangeLabel;
	private JLabel _redLabel;

	private Color _offColor = Color.gray;
	private Color _selectedBackground = Color.blue;
	private Color _selectedForeground = Color.white;

	public TrafficLightWindow( TrafficLight light, TrafficController controller ) {

		setTitle( "Feu" );
		setSize( 150, 540 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );

		_greenLabel = new JLabel();
		_greenLabel.setOpaque( true );
		_orangeLabel = new JLabel();
		_orangeLabel.setOpaque( true );
		_redLabel = new JLabel();
		_redLabel.setOpaque( true );

		JButton switchButton = new JButton("->");
		switchButton.setFocusPainted( false );
		switchButton.addActionListener( actionEvent -> {
				controller.run( 1, 0 );
			}
		);

		JButton onOffButton = new JButton("+/-");
		onOffButton.setFocusPainted( false );
		onOffButton.addActionListener( actionEvent -> {
				controller.onOff();
		});

		JButton germanButton = new JButton("Ge");
		germanButton.setFocusPainted( false );
		JButton frenchButton = new JButton("Fr");
		frenchButton.setFocusPainted( false );
		JButton bicolorButton = new JButton("Bi");
		bicolorButton.setFocusPainted( false );

		germanButton.addActionListener( actionEvent -> {
				controller.switchToGermanTrafficLight();
				frenchButton.setBackground( null );
				frenchButton.setForeground( Color.black );
				germanButton.setBackground( _selectedBackground );
				germanButton.setForeground( _selectedForeground );
				bicolorButton.setBackground( null );
				bicolorButton.setForeground( Color.black );
		});

		frenchButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				controller.switchToFrenchTrafficLight();
				frenchButton.setBackground( _selectedBackground );
				frenchButton.setForeground( _selectedForeground );
				germanButton.setBackground( null );
				germanButton.setForeground( Color.black );
				bicolorButton.setBackground( null );
				bicolorButton.setForeground( Color.black );
			}
		});

		bicolorButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				controller.switchToBicolorTrafficLight();
				frenchButton.setBackground( null );
				frenchButton.setForeground( Color.black );
				germanButton.setBackground( null );
				germanButton.setForeground( Color.black );
				bicolorButton.setBackground( _selectedBackground );
				bicolorButton.setForeground( _selectedForeground );
			}
		});

		setLayout( new GridBagLayout() );

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipadx = 150;
		constraints.ipady = 150;

		constraints.gridwidth = 6;
		constraints.gridx = 0;
		constraints.gridy = 0;
		add( _greenLabel, constraints );
		constraints.gridy = 1;
		add( _orangeLabel, constraints );
		constraints.gridy = 2;
		add( _redLabel, constraints );

		constraints.gridwidth = 3;
		constraints.gridy = 3;
		constraints.ipady = 0;
		constraints.ipadx = 0;
		add( switchButton, constraints );
		constraints.gridx = 3;
		add( onOffButton, constraints );

		constraints.gridwidth = 2;
		constraints.gridy = 4;
		constraints.gridx = 0;
		add( frenchButton, constraints );
		constraints.gridx = 2;
		add( germanButton, constraints );
		constraints.gridx = 4;
		add( bicolorButton, constraints );

		updateColor( light.getColor() );
		updateOnOff( light.isOn() );

		setVisible( true );
	}

	@Override
	public void updateOnOff( Boolean isOn ) {
		if ( isOn ) {
			_greenLabel.setBackground( _offColor );
			_orangeLabel.setBackground( _offColor );
			_redLabel.setBackground( Color.red );
		}
		else {
			_greenLabel.setBackground( _offColor );
			_orangeLabel.setBackground( _offColor );
			_redLabel.setBackground( _offColor );
		}
	}

	@Override
	public void updateColor( LightColor newColor ) {
		switch ( newColor ) {
			case GREEN:
				_greenLabel.setBackground( Color.green );
				_orangeLabel.setBackground( _offColor );
				_redLabel.setBackground( _offColor );
				break;
			case ORANGE:
				_greenLabel.setBackground( _offColor );
				_orangeLabel.setBackground( Color.orange );
				_redLabel.setBackground( _offColor );
				break;
			case RED:
				_greenLabel.setBackground( _offColor );
				_orangeLabel.setBackground( _offColor );
				_redLabel.setBackground( Color.red );
				break;
			default:
				break;
		}
	}
}
