package tests;

import cartes.Carte;
import cartes.PaquetDeCartes;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Cette classe test le paquet de carte
 *
 * @author Samuel Nguyen-Phok
 */
public class PaquetDeCartesTest
{
    private PaquetDeCartes paquet;

    @Before
    public void setUp() throws Exception
    {
        paquet = new PaquetDeCartes();
    }

    @Test
    public void brasser()
    {
        PaquetDeCartes compare = new PaquetDeCartes();
        boolean isEqual = false;
        for (int i = 0; i < paquet.size(); i++)
        {
            isEqual = paquet.consulterCarte(i).equals(compare.consulterCarte(i));
        }
        assertTrue(isEqual);
        paquet.brasser();
        boolean isEqual2 = false;
        for (int i = 0; i < paquet.size(); i++)
        {
            isEqual2 = paquet.consulterCarte(i).equals(compare.consulterCarte(i));
        }
        assertNotEquals(paquet, compare);
    }

    @Test
    public void consulterCarte()
    {
        Carte carte = paquet.consulterCarte(paquet.size()-1);
        //TODO peut pas tester sans le code de la classe carte
        assertEquals(paquet.prendreCarte(paquet.size() -1), carte);
    }

    @Test
    public void prendreCarte()
    {
        paquet.prendreCarte(0);
        assertEquals(51, paquet.size());
    }

    @Test
    public void retournerToutesLesCartes()
    {
        boolean isRetourner = false;
        paquet.retournerToutesLesCartes(true);
        for (int i = 0; i < paquet.size(); i++)
        {
            isRetourner = paquet.consulterCarte(i).estVisible();
        }
        assertTrue(isRetourner);
    }

    @Test
    public void size()
    {
        assertEquals(52, paquet.size());
        paquet.prendreCarte(0);
        assertEquals(51, paquet.size());
    }

    @Test
    public void isEmpty()
    {
        assertFalse(paquet.isEmpty());

        while (!paquet.isEmpty()) {
            paquet.prendreCarte(0);
        }

        assertTrue(paquet.isEmpty());
    }
}