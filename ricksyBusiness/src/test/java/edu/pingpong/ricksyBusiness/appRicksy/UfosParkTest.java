package edu.pingpong.ricksyBusiness.appRicksy;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class UfosParkTest {

    private UfosPark ufosPark;
    private CreditCard creditCard;
    private double delta = 0.01;

    @Before
    public void setupUfosPark() {
        creditCard = new CreditCard("Montgomeri Burns", "666777999");
        ufosPark = new UfosPark();
        ufosPark.add("Ovni1");
        ufosPark.add("Ovni2");
        ufosPark.add("Ovni3");
    }

    @Test
    public void dispatchTest() {
        ufosPark.dispatch(creditCard);
        assertEquals(2500, creditCard.credit(), delta);
        assertEquals("Ovni2", ufosPark.getUfoOf("666777999"));
    }

    @Test
    public void dispatchNullTest() {
        assertEquals(null, ufosPark.getUfoOf("666777999"));
    }

    @Test
    public void dispatchNotCreditTest() {
        creditCard.pay(3000);
        ufosPark.dispatch(creditCard);
        assertFalse(ufosPark.containsCard("666777999"));
    }

    @Test
    public void dispatchAsignedUfoTest() {
        ufosPark.dispatch(creditCard);
        ufosPark.dispatch(creditCard);
        assertEquals(2500, creditCard.credit(), delta);
        assertEquals("Ovni2", ufosPark.getUfoOf("666777999"));
        assertTrue(ufosPark.containsCard("666777999"));
    }

    @Test
    public void dispatchNoAvaliableTest() {
        CreditCard nonAvaliable = new CreditCard("Mortadelo", "666555444");
        ufosPark.dispatch(creditCard);
        ufosPark.dispatch(new CreditCard("Super Lopez", "111222333"));
        ufosPark.dispatch(new CreditCard("Tintín", "999888777"));
        ufosPark.dispatch(nonAvaliable);

        assertEquals(3000, nonAvaliable.credit(), delta);
        assertFalse(ufosPark.containsCard("666555444"));
    }

    @Test
    public void toStringTest() {
        String expected = "[Ovni1, Ovni2, Ovni3]";
        assertEquals(expected, ufosPark.toString());
    }

    @Test
    public void containsCardTest() {
        ufosPark.dispatch(creditCard);
        assertTrue(ufosPark.containsCard("666777999"));
    }

    @Test
    public void notContainsCardTest() {
        assertFalse(ufosPark.containsCard("666777999"));
    }
}
