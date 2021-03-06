package edu.pingpong.ricksyBusiness.appRicksy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MenuTest {
    
    private Menu menu;
    private double delta = 0.01;
    private CreditCard card1;
    private CreditCard card2;
    private CreditCard card3;
    
    @Before
    public void setupMenu() {
        menu = new Menu(50, 10);

        card1 = new CreditCard("Montgomeri Burns", "666777999");
        card2 = new CreditCard("Marge Simpson", "111222333");
        card3 = new CreditCard("Homer Simpson", "555444666");
    }

    @Test
    public void dispatchAndStockTest() {
        menu.dispatch(card1);
        menu.dispatch(card2);

        card3.pay(3000);
        menu.dispatch(card3);

        assertEquals(48, menu.stock());
        assertEquals(2, menu.getCustomersList().size());
        assertEquals(2990, card1.credit(), delta);
    }

    @Test
    public void noStockTest() {
        Menu noMenu = new Menu(0, 50);
        noMenu.dispatch(card1);

        assertEquals(0, noMenu.getCustomersList().size());
        assertEquals(3000, card1.credit(), delta);
    }

    @Test
    public void toStringTest() {
        menu.dispatch(card1);
        String expected = "Stock: 49\n[Montgomeri Burns]";
        assertEquals(expected, menu.toString());
    }
}
