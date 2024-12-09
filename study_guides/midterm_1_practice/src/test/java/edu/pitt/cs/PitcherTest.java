package edu.pitt.cs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.*;

import org.junit.Test;

public class PitcherTest {
    /**
 * <pre>
 * Preconditions: A Pitcher pitcher is created.
 * Execution steps: Call pitcher.addStress(10).
 * Postconditions: pitcher.getStress() returns 10.
 * </pre>
 */
    @Test
    public void testAddStress() {
        Pitcher pitcher = new Pitcher();
        pitcher.addStress(10);
        assertEquals(10, pitcher.getStress());
    }

        /**
     * <pre>
     * Preconditions: A Pitcher pitcher is created.
     *                The pitcher always throws strikes.
     *                A Batter batter is created.
     *                The batter always swings bat.
     *                A BallGame game is created using pitcher and batter.
     * Execution steps: Call game.pitch().
     * Postconditions: The string "hit" is returned from the call.
     *                 Stress of 10 is added to the pitcher.
     * </pre>
     */
    @Test
    public void testPitch() {
        Pitcher pitcher = mock(Pitcher.class);
        Batter batter = mock(Batter.class);

        when(pitcher.throwBall()).thenReturn(true);
        when(batter.swingBat()).thenReturn(true);

        BallGame game = new BallGame(pitcher, batter);
        String result = game.pitch();
        game.pitch();
        game.pitch();
        assertEquals("hit", result);
        verify(pitcher).addStress(10);
    }
}
