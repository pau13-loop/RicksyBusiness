package edu.pingpong.ricksyBusiness.appRicksy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

    private CreditCard creditCard;
    private double delta = 0.01;

    @Before
    public void setupCreditCard() {
        creditCard = new CreditCard("Montgomeri Burns", "666777999");
    }

    @Test
    public void payTrueTest() {
        assertTrue(creditCard.pay(1000));
        assertEquals(2000, creditCard.credit(), delta);
    }
    
    @Test
    public void payFalseTest() {
        assertFalse(creditCard.pay(5000));
    }

    @Test
    public void numberTest() {
        assertEquals("666777999", creditCard.number());
    }

    @Test
    public void cardOwnerTest() {
        assertEquals("Montgomeri Burns", creditCard.cardOwner());
    }

    @Test
    public void creditTest() {
        assertEquals(3000d, creditCard.credit(), delta);
    }

    @Test
    public void toStringTest() {
        String expected = "Owner: Montgomeri Burns\nNumber: 666777999\nCredit: 3000.0EZI";

        assertEquals(expected, creditCard.toString());
    }


}
