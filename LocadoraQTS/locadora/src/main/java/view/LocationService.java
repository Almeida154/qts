package view;
import java.util.Date;
import org.junit.Test;

import controller.LocationController;
import model.Client;
import model.Game;
import model.Location;
import util.Util;

public class LocationService {
	
	@Test
	public static void main(String[] args) {
		
		// Scenery
		Client client = new Client("David");
		Game game = new Game("Rocket League", 35.00, 5);
		
		// Action
		LocationController controller = new LocationController();
		Location location = controller.rentGame(client, game, 3);
		
		// Verification
		controller.verify(client, game, location);
	}
}

// CÓDIGO ORIGINAL:

//package qts.Locadora;
//
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
///**
//* Unit test for simple App.
//*/
//public class AppTest 
//  extends TestCase
//{
//  /**
//   * Create the test case
//   *
//   * @param testName name of the test case
//   */
//  public AppTest( String testName )
//  {
//      super( testName );
//  }
//
//  /**
//   * @return the suite of tests being tested
//   */
//  public static Test suite()
//  {
//      return new TestSuite( AppTest.class );
//  }
//
//  /**
//   * Rigourous Test :-)
//   */
//  public void testApp()
//  {
//      assertTrue( true );
//  }
//}