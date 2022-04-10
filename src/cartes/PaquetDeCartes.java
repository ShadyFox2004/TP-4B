package cartes;

import java.util.ArrayList;

/**
 * Classe permettant de représenter un paquet de cartes à jouer.
 * Peut créer un paquet de cartes complet ou prendre un vecteur de carte comme paquet.
 * Offre des services pour brasser le paquet,
 * piger une carte dans le paquet, regarder une carte du paquet, retourner toutes les cartes du paquet. N.B.
 * Notre paquet sera basé sur une liste dynamique.
 *
 * @author Antoine-Matis Boudreau
 * @author Samuel Nguyen-Phok
 */
public class PaquetDeCartes
{
    /**
     * Nombre d'échanges pour brasser un paquet de carte
     */
    public static final int NBR_ECHANGE = 1000; // La valeur est trouver dans la javadoc

    /**
     * Le paquet de cartes, une structure qui hérite de l'interface java "List"
     */
    private java.util.List<Carte> paquet;

    /**
     * Constructeur permettant de créer un paquet complet de cartes de 4 sortes X 13 cartes.
     * Utilise les énumérations "SorteCartes" et "ValeurCartes".
     */
    public PaquetDeCartes()
    {
        paquet = new ArrayList<Carte>();

        for (SorteCartes sorte : SorteCartes.values())
        {
            for (ValeurCartes valeur : ValeurCartes.values())
            {
                paquet.add(new Carte(valeur, sorte));
            }
        }
    }

    /**
     * Constructeur avec paramètre permettant de faire des tests.
     * On donne une liste de cartes organisée à notre goût.
     *
     * @param pPaquet un paquet de cartes. Ne peut-être "null"
     * @throws exceptions.ConstructeurException
     */
    public PaquetDeCartes(java.util.List<Carte> pPaquet)
            throws exceptions.ConstructeurException
    {
        paquet = new ArrayList<Carte>();

        if (pPaquet != null)
        {
            for (Carte carte : pPaquet)
            {
                paquet.add(carte);
            }
        }
    }

    /**
     * Brasse le paquet de cartes en provoquant un certain nombre d'échanges entre les cartes du paquet.
     * Plus le nombre d'échanges est grand, mieux le paquet sera brassé.
     * Utilise permuterCarte.
     */
    public void brasser()
    {
        for (int i = 0; i < NBR_ECHANGE; i++)
        {
            permuterCarte(randomNum(1, paquet.size()-1), randomNum(1, paquet.size()-1));
        }
    }

    /**
     * Permet de permuter 2 cartes dans le paquet selon leur position
     *
     * @param index1 index d'une carte
     * @param index2 index d'une autre carte
     */
    private void permuterCarte(int index1,
                               int index2)
    {
        paquet.set(index2, paquet.set(index1, paquet.get(index2)));
    }

    /**
     * Consulte, sans la retirer, une carte du paquet selon la position voulue.
     * Ne modifie pas la visibilité de la carte consultée.
     *
     * @param position la position voulue entre 1 et le nombre de cartes dans le paquet.
     * @return Carte, la carte choisie ou "null" si le paquet est vide ou si la position est invalide.
     */
    public Carte consulterCarte(int position)
    {
        return paquet.get(position);
    }

    /**
     * Retire une carte du paquet selon la position voulue.
     * Ne modifie pas la visibilité de la carte retirée.
     *
     * @param position la position voulue entre 1 et le nombre de cartes dans le paquet.
     * @return Carte, la carte enlevée ou "null" si le paquet est vide ou si la position est invalide.
     */
    public Carte prendreCarte(int position)
    {
        Carte carte = paquet.get(position);
        paquet.remove(position);
        return carte;
    }

    /**
     * Rend toutes les cartes du paquet visibles ou invisibles (face cachée).
     *
     * @param visible vrai pour visible et faux pour face cachée
     */
    public void retournerToutesLesCartes(boolean visible)
    {
        for (Carte carte : paquet)
        {
            carte.setVisible(visible);
        }
    }

    /**
     * Permet de savoir le nombre de cartes dans le paquet.
     *
     * @return int, le nombre de cartes.
     */
    public int size()
    {
        // methode de arraylist
        // alternative: return paquet.size();
        int nbr = 0;
        for (Carte carte : paquet)
        {
            nbr++;
        }
        return nbr;
    }

    /**
     * Permet de savoir si le paquet de cartes est vide
     *
     * @return boolean, vrai si le paquet est vide
     */
    public boolean isEmpty()
    {
        // methode de arraylist
        // alternative: return paquet.isEmpty();
        return paquet.size() == 0;
    }

    /**
     * Valide si l'entier reçu en entrée est valide selon le nombre de cartes dans le paquet.
     * Attention on parle ici de la position et non de l'index.
     *
     * @param position une position dans le paquet entre 1 et la taille du paquet
     * @return vrai si l'entier est valide selon le nombre de cartes dans le paquet
     */
    private boolean validerPosition(int position)
    {
        return position <= paquet.size();
    }

    /**
     * Retourne un int aleatoire
     *
     * @param min minimum
     * @param max maximum
     * @return int aleatoire
     */
    private int randomNum(int min, int max)
    {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
