package cartes;

import structures.pile.Pile;

/**
 * Classe permettant de représenter une pioche pour jouer aux cartes.
 * Essentiellement une pioche reçoit un paquet de cartes.
 * Elle ne doit pas changer ni l'ordre, ni la visibilité des cartes composant le paquet reçu.
 * Elle permet de piger une seule carte à la fois sur le dessus.
 * N.B.
 * Notre pioche sera basée sur une pile dynamique.
 *
 * @author Antoine-Matis Boudreau
 */
public class Pioche
{
    /**
     * la pile qui va représenter notre pioche
     */
    private Pile pioche;

    /**
     * Constructeur.
     * Met les cartes du paquet dans la pioche.
     * Faire attention de conserver l'ordre et la visibilité des cartes du paquet reçu en entrée, en les mettant dans la pioche.
     * Il ne faut pas inverser l'ordre des cartes.
     *
     * @param paquet le paquet de cartes à mettre dans la pioche. Peut être un pointeur "null", qui donne une pioche vide.
     */
    public Pioche(PaquetDeCartes paquet)
    {
        pioche = new Pile();
        for (int i = 0; i < paquet.size(); i++)
        {
            pioche.empiler(paquet.prendreCarte(i));
        }
    }

    /**
     * Permet de piger une carte sur le dessus du paquet. Ne modifie pas la visibilité de la carte pigée.
     *
     * @return la carte pigée ou null si le paquet est vide.
     */
    public Carte piger()
    {
        return (Carte) pioche.depiler();
    }

    /**
     * Permet de voir la carte du dessus sans la piger. Ne modifie pas la visibilité de la carte. Utilise la méthode "toStringCarte()"
     *
     * @return String, une chaîne qui représente la carte du dessus si la pioche n'est pas vide.
     * @throws exceptions.PiocheException
     */
    public String consulterDessus()
            throws exceptions.PiocheException
    {
        Carte temp = (Carte) pioche.getPremier();
        return temp.toStringCarte();
    }

    /**
     * Permet de savoir si la pioche est vide
     *
     * @return boolean, vrai si la pioche est vide.
     */
    public boolean isEmpty()
    {
       return pioche.isEmpty();
    }

    /**
     * Retourne la taille de la pioche
     *
     * @return int, la taille.
     */
    public int size()
    {
        return pioche.size();
    }
}