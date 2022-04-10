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
        pioche.piger();
        assertEquals(51, pioche.size());
    }

    @Test
    public void consulterDessus()
    {
        assertEquals("", pioche.consulterDessus());
    }

    @Test
    public void isEmpty()
    {
        for (int i = 0 ; i < pioche.size(); i++)
        {
            pioche.piger();
            System.gc();
        }

        assertEquals(0, pioche.size());
    }

    @Test
    public void size()
    {
        assertEquals(52, pioche.size());
    }
}