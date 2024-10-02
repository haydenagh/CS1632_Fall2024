package edu.pitt.cs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.*;

import org.junit.Test;

public class DeathStarTest {

	/**
	 * Write an integration test for shoot.
	 * 
	 * <pre>
	 * Preconditions: A new DeathStar deathStar is created
	 *                A new Planet planet is created with hit points 10
	 * Execution Steps: Call deathStar.shoot(planet)
	 * PostConditions: Return value of call is "Wimpy planet was hit by the superlaser!"
	 *                 Planet receives a damage of 100 hit points
	 * </pre>
	 */
	@Test
	public void testShootPlanetIntegration() {
		// Preconditions: Create DeathStar and Planet objects
		DeathStar deathStar = new DeathStar();
		Planet planet = new Planet(10); // Planet with 10 hit points

		// Execution Step: Call shoot
		String result = deathStar.shoot(planet);

		// Postconditions
		assertEquals("Wimpy planet was hit by the superlaser!", result); // Check the return value
		assertEquals(-90, planet.getHitPoints()); // Planet should have received 100 damage, so hit points should be -90
	}

	/**
	 * Write an unit test for shoot.
	 * 
	 * <pre>
	 * Preconditions: A new DeathStar deathStar is created
	 *                A new Planet planet is created with hit points 10
	 * Execution Steps: Call deathStar.shoot(planet)
	 * PostConditions: Return value of call is "Wimpy planet was hit by the superlaser!"
	 *                 Planet receives a damage of 100 hit points
	 * </pre>
	 */
	@Test
	public void testShootPlanetUnit() {
		DeathStar deathStar = new DeathStar();

		Planet mockPlanet = mock(Planet.class);

		when(mockPlanet.toString()).thenReturn("Wimpy planet");

		String result = deathStar.shoot(mockPlanet);

		// Postconditions
		assertEquals("Wimpy planet was hit by the superlaser!", result); 

		verify(mockPlanet).damage(100);
	}
}
