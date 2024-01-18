package cars;

public class CarApp {

	public static void main( String[] args ) {
 		CarFactory factory = new CarFactory();
		Car car =  factory.getCar( "JEEP" );
		System.out.println( car.getClass().getName() +" créée." );
		car.refuel();
		System.out.println( "Plein de la Subaru effectué." );
		System.out.println( car.honk() + " !" );
		System.out.println(car.speedUp() + " !" );

	}

}
