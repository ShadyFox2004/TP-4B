package application;

import cartes.Carte;
import cartes.PaquetDeCartes;
import cartes.Pioche;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class qui guerre les methode d'une partie.
 * Est sérialisable.
 * @author Antoine-Matis Boudreau
 */
public class Partie implements Serializable {

    private int nbTriche;

    private Pioche pioche;

    private List[] colonneCartes = new ArrayList[AcesUpSolitaire.NBR_COLONNES_DE_CARTES];

    public Partie (PaquetDeCartes pPDC) {
        nbTriche = 0;
        Carte carteTemp = null;
        pPDC.brasser();
        pioche = new Pioche(pPDC);

        for (int i = 0; i < AcesUpSolitaire.NBR_COLONNES_DE_CARTES; i++) {
            colonneCartes[i] = new ArrayList();

            // La pioche peut être vide
            if (!pioche.isEmpty()) {
                carteTemp = pioche.piger();
                carteTemp.setVisible(true);
                colonneCartes[i].add(0, carteTemp);
            }
        }
    }

    public int getNbTriche() {
        return nbTriche;
    }

    public void setNbTriche(int nbTriche) {
        this.nbTriche = nbTriche;
    }

    public Pioche getPioche() {
        return pioche;
    }

    public void setPioche(Pioche pioche) {
        this.pioche = pioche;
    }

    public List[] getColonneCartes() {
        return colonneCartes;
    }

    public void setColonneCartes(List[] colonneCartes) {
        this.colonneCartes = colonneCartes;
    }

    /**
     * Permet de savoir, lorsque la pioche est vide, s'il y a une victoire. Donc
     * qu'il y ait seulement 1 carte, un as, en haut de chacune des colonnes de
     * cartes
     *
     * @return boolean, vrai si on a une victoire.
     */
    // TODO Complétez le code de la méthode : partieGagne
    public boolean partieGagner()
    {
        return true;
    }

    /**
     * Permet de savoir, lorsque la pioche est vide, s'il est possible de jouer
     * encore un coup ou si la partie est terminée.
     *
     * @return boolean, vrai s'il n'est pas possible de jouer un autre coup,
     *         donc que la partie est terminée.
     */
    public boolean partieTerminer()
    {
        Carte carteTemp = null;
        int compteSorte = 0;
        boolean colonneDeplacable = false;

        if (pioche.isEmpty())
        {
            // Vérifier si je peux encore enlever des cartes, trouver s'il y a
            // au moins une colonne vide et trouver si une colonne a plus d'une
            // carte, donc encore déplaçable.
            for (int i = 0; i < colonneCartes.length; i++)
            {
                if (!colonneCartes[i].isEmpty())
                {
                    colonneDeplacable = (colonneDeplacable
                            || (colonneCartes[i].size() > 1));
                    carteTemp = (Carte) colonneCartes[i].get(0);
                    // Addition de bits (bitwise)
                    compteSorte += Math.pow(2,
                            (carteTemp.getSorte().ordinal()));
                }
            }
        }

        return (!(compteSorte != (Math.pow(2, colonneCartes.length) - 1))
                || !colonneDeplacable);
    }
}
