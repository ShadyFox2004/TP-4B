package tests;

import cartes.PaquetDeCartes;
import cartes.Pioche;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PiocheTest
{
    private Pioche pioche;

    @Before
    public void setUp() throws Exception
    {
        pioche = new Pioche(new PaquetDeCartes());
    }

    @Test
    public void piger()
    {
        assertEquals(52, pioche.size());
        pioche.piger();
        assertEquals(51, pioche.size());
    }

    @Test
    public void consulterDessus()
    {
        assertEquals(pioche.piger().toStringCarte(), pioche.consulterDessus());
    }

    @Test
    public void isEmpty()
    {
        assertFalse(pioche.isEmpty());

        while (pioche.size() != 0) // Until
        {
            pioche.piger();
        }

        assertTrue(pioche.isEmpty());
    }

    @Test
    public void size()
    {
        assertEquals(52, pioche.size());
    }
}