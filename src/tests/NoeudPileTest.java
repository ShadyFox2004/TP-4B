package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import structures.pile.NoeudPile;

import static org.junit.Assert.assertEquals;

/**
 * Cette classe test NoeudPile
 *
 * @author Samuel Nguyen-Phok
 * @version Printemps 2022
 */
public class NoeudPileTest
{
    private NoeudPile noeudPile1, noeudPile2;

    @Before
    public void setUp() throws Exception
    {
        noeudPile1 = new NoeudPile(new Integer(5));
        noeudPile2 = new NoeudPile(new Integer(2));
    }

    @Test
    public void getElement()
    {
        assertEquals(5, noeudPile1.getElement());
    }

    @Test
    public void setElement()
    {
        assertEquals(5, noeudPile1.getElement());
        noeudPile1.setElement(new Integer(3));
        assertEquals(3, noeudPile1.getElement());
    }

    @Test
    public void getPrecedent()
    {
        assertEquals(null, noeudPile1.getPrecedent());
    }

    @Test
    public void setPrecedent()
    {
        noeudPile1.setPrecedent(noeudPile2);
        assertEquals(noeudPile2, noeudPile1.getPrecedent());
    }
}