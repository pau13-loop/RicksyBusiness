package edu.pingpong.ricksyBusiness.appRicksy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReceptivoTest {

    private Receptivo receptivo = null;
    private CrystalExpender crystal = null;
    private UfosPark ufosPark = null;
    private double delta = 0.01;

    @Before
    public void setupReceptivo() {
        receptivo = new Receptivo();
        crystal = new CrystalExpender(5, 50.0);
        ufosPark = new UfosPark();

        receptivo.registra(crystal);
        receptivo.registra(ufosPark);

        // Setup UfosPark
        ufosPark.add("Ovni1");
        ufosPark.add("Ovni2");
        ufosPark.add("Ovni3");
    }

    @Test
    public void dispatchTest() {
        CreditCard card = new CreditCard("asterix", "555222888");
        receptivo.dispatch(card);

        assertEquals(2450, card.credit(), delta);
        assertEquals(4, crystal.stock());
        assertTrue(ufosPark.containsCard("555222888"));
    }

}
