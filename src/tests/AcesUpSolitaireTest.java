package tests;

import application.AcesUpSolitaire;
import cartes.PaquetDeCartes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AcesUpSolitaireTest
{
    private AcesUpSolitaire jeu;

    @Before
    public void setUp() throws Exception
    {
        PaquetDeCartes paquet = new PaquetDeCartes();
        paquet.brasser();
        jeu = new AcesUpSolitaire(paquet);
    }

    @Test
    public void gestionDeplacerListe()
    {
        // vide une colonne
        jeu.getColonneCartes(1).clear();

        // deplace la carte vers une colonne vide
        jeu.gestionDeplacerListe(0);

        assertEquals(0, jeu.getColonneCartes(0).size());
        assertEquals(1, jeu.getColonneCartes(1).size());

    }

    @Test
    public void gestionEnleverListe()
    {
    }

    @Test
    public void gestionPiger()
    {
    }

    @Test
    public void partieGagner()
    {
    }

    @Test
    public void enregistrerInfoPartie()
    {
    }

    @Test
    public void lireInfoPartie()
    {
    }
}