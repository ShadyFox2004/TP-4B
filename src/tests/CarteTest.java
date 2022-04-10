package tests;

import cartes.Carte;
import cartes.SorteCartes;
import cartes.ValeurCartes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Cette classe test la classe Carte
 *
 * @author Samuel Nguyen-Phok
 */
public class CarteTest
{
    private Carte carte1, carte2, carte3, carte4, carte1Clone;

    @Before
    public void setUp() throws Exception
    {
        carte1 = new Carte(ValeurCartes.V_AS, SorteCartes.COEUR);
        carte2 = new Carte(ValeurCartes.V_KING, SorteCartes.CARREAU);
        carte3 = new Carte(ValeurCartes.V_5, SorteCartes.PIQUE);
        carte4 = new Carte(ValeurCartes.V_2, SorteCartes.TREFLE);
        carte1Clone = new Carte(ValeurCartes.V_AS, SorteCartes.COEUR);
    }

    @Test
    public void estVisible()
    {
        assertEquals(false, carte1.estVisible());
        assertEquals(false, carte2.estVisible());
        assertEquals(false, carte3.estVisible());
        assertEquals(false, carte4.estVisible());
    }

    @Test
    public void setVisible()
    {
        carte1.setVisible(true);
        assertEquals(true, carte1.estVisible());
        carte2.setVisible(true);
        assertEquals(true, carte2.estVisible());
        carte3.setVisible(true);
        assertEquals(true, carte3.estVisible());
        carte4.setVisible(true);
        assertEquals(true, carte4.estVisible());
    }

    @Test
    public void getSorteSymbole()
    {
        assertEquals('♥', carte1.getSorteSymbole());
        assertEquals('\u2666', carte2.getSorteSymbole());
        assertEquals('♠', carte3.getSorteSymbole());
        assertEquals('♣', carte4.getSorteSymbole());
    }

    @Test
    public void getSorte()
    {
        assertEquals(SorteCartes.COEUR, carte1.getSorte());
        assertEquals(SorteCartes.CARREAU, carte2.getSorte());
        assertEquals(SorteCartes.PIQUE, carte3.getSorte());
        assertEquals(SorteCartes.TREFLE, carte4.getSorte());
    }

    @Test
    public void getValeurSymbole()
    {
        assertEquals("A", carte1.getValeurSymbole());
        assertEquals("K", carte2.getValeurSymbole());
        assertEquals("5", carte3.getValeurSymbole());
        assertEquals("2", carte4.getValeurSymbole());
    }

    @Test
    public void getValeur()
    {
        assertEquals(ValeurCartes.V_AS, carte1.getValeur());
        assertEquals(ValeurCartes.V_KING, carte2.getValeur());
        assertEquals(ValeurCartes.V_5, carte3.getValeur());
        assertEquals(ValeurCartes.V_2, carte4.getValeur());
    }

    @Test
    public void compareTo()
    {
        assertEquals(0, carte1.compareTo(carte1Clone));
        assertEquals(-1, carte1.compareTo(carte2));
        Carte carte = new Carte(ValeurCartes.V_4, SorteCartes.PIQUE);
        assertEquals(1, carte3.compareTo(carte));
    }

    @Test
    public void testEquals()
    {
        assertEquals(false, carte1.equals(carte2));
        assertEquals(true, carte1.equals(carte1Clone));
    }

    @Test
    public void testToString()
    {
        assertEquals("Carte {sorte = ♥, valeur = 1 A, visible = false}", carte1.toString());
        assertEquals("Carte {sorte = \u2666, valeur = 13 K, visible = false}", carte2.toString());
        assertEquals("Carte {sorte = ♠, valeur = 5 5, visible = false}", carte3.toString());
        assertEquals("Carte {sorte = ♣, valeur = 2 2, visible = false}", carte4.toString());
    }

    @Test
    public void toStringCarte()
    {
        assertEquals(" ", carte1.toStringCarte());
        carte1.setVisible(true);
        assertEquals("A♥", carte1.toStringCarte());

        assertEquals(" ", carte2.toStringCarte());
        carte2.setVisible(true);
        assertEquals("K\u2666", carte2.toStringCarte());

        assertEquals(" ", carte3.toStringCarte());
        carte3.setVisible(true);
        assertEquals("5♠", carte3.toStringCarte());

        assertEquals(" ", carte4.toStringCarte());
        carte4.setVisible(true);
        assertEquals("2♣", carte4.toStringCarte());
    }
}