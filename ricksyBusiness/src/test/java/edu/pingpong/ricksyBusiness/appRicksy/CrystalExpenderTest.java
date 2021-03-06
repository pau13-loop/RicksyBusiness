package edu.pingpong.ricksyBusiness.appRicksy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CrystalExpenderTest {

    private CreditCard card;
    private CrystalExpender crystal;
    private double delta = 0.01;
    
    @Before
    public void setupCrystal() {
        card = new CreditCard("Montgomeri Burns", "666777999");
        crystal = new CrystalExpender(10, 500.0);
    }

    @Test
    public void stockTest() {
        crystal.dispatch(card);
        crystal.dispatch(card);
        assertEquals(2000, card.credit(), delta);
        assertEquals(8, crystal.stock());
    }

    @Test
    public void noStockTest() {
        CrystalExpender noCrystal = new CrystalExpender(0, 500.0);
        noCrystal.dispatch(card);
        assertEquals(3000, card.credit(), delta);
        assertEquals(0, noCrystal.stock());
    }

    @Test
    public void toStringTest() {
        String expected = "Stock: 10\nCost: 500.0";
        assertEquals(expected, crystal.toString());
    }
}
