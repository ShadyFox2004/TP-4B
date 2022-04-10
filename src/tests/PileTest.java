package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cartes.Carte;
import cartes.SorteCartes;
import cartes.ValeurCartes;
import exceptions.PileException;
import structures.pile.Pile;


/**
 * @author Antoine-Matis Boudreau
 */
public class PileTest {
    private Pile pile;

    @Before
    public void setup() {
        pile = new Pile();
    }

    @Test
    public void depiler() {
        try {
            pile.depiler();
            fail();
        } catch (PileException ignore) {
        }

        pile.empiler(2);

        assertEquals(2, pile.depiler());

        Carte carte = new Carte(null, null);

        pile.empiler(carte);

        assertEquals(carte, pile.depiler());
    }

    @Test
    public void empiler() {
        pile.empiler(null);
        assertEquals(0, pile.size());

        pile.empiler(34);
        pile.empiler(new Carte(ValeurCartes.V_10, SorteCartes.COEUR));
    }

    @Test
    public void getPremier() {
        try {
            pile.getPremier();
            fail();
        } catch (PileException ignore) {
        }

        pile.empiler(3);
        
        assertEquals(3, pile.getPremier());
    }


    @Test
    public void isEmpty() {
        assertEquals(true, pile.isEmpty());
        
        pile.empiler(3);

        assertEquals(false, pile.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(0, pile.size());

        pile.empiler(3);

        assertEquals(1, pile.size());

        pile.empiler(null);

        assertEquals(1, pile.size());        
    }

    @Test
    public void ToString() {
        pile.empiler(2);
        pile.empiler(3);
        pile.empiler(28);

        assertEquals("2, 3, 28, \n", pile.toString());
    }

    @Test
    public void vider() {
        pile.empiler(34);
        pile.empiler(new Double(2));

        assertEquals(false, pile.isEmpty());
        
        pile.vider();

        assertEquals(true, pile.isEmpty());
    }
}
