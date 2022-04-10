package structures.pile;

import exceptions.PileException;

/**
 * Classe définissant une pile d'objets à partir d'un "NoeudPile" dynamique.
 * @author Antoine-Matis Boudreau
 */
public class Pile {
    /**
     * Pointeur pour le sommet de la pile
     */
    private NoeudPile sommet;

    /**
     * Conserve le nombre d'éléments dans la pile
     */
    private int taille;

    /**
     * Construit une pile vide
     */
    public Pile() {
        taille = 0;
        sommet = null;
    }

    /**
     * Vérifie si la pile est vide
     * @return boolean, vrai si elle est vide
     */
    public boolean isEmpty() {
        return taille == 0;
    }

    /**
     * Vide la pile
     */
    public void vider() {
        taille = 0;
        sommet = null;
        System.gc();
    }

    /**
     * Empile un objet dans la pile.
     * @param element l'élément à empiler
     */
    public void empiler(Object element){
        if(element != null) {
            sommet = new NoeudPile(element, sommet);
            taille++;
        }
    }

    /**
     * Retourne l'objet contenu dans le noeud sur le dessus de la pile sans le dépiler.
     * Lève une exceptions si la pile est vide.
     * @return Object, l'objet sur le dessus de la pile.
     * @throws exceptions.PileException
     */
    public java.lang.Object getPremier()
            throws exceptions.PileException {
        if(isEmpty()) {
            throw new PileException();
        }

        return sommet.getElement();
    }

    /**
     * Retourne l'objet dépilé.
     * Lève une exceptions si la pile est vide.
     * Se sert de getPremier()
     * @return Object, l'élément dépilé
     * @throws exceptions.PileException
     */
    public java.lang.Object depiler()
            throws exceptions.PileException {
        NoeudPile noeudPile;

        if (isEmpty()) {
            throw new PileException();
        }

        noeudPile = sommet;
        sommet = noeudPile.getPrecedent();
        taille--;

        return noeudPile.getElement();
    }

    /**
     * Retourne le nombre d'éléments dans la pile
     * @return int, le nombre d'éléments dans la pile
     */
    public int size() {
        return taille;
    }

    /**
     * Permet de créer une chaîne représentant les éléments qui sont dans la pile.
     */
    @Override
    public java.lang.String toString() {
        String message = "";
        NoeudPile currentNode = sommet;

        while (currentNode != null) {
            message = currentNode.getElement() + ", " + message;
            currentNode = currentNode.getPrecedent();
        }

        return message + "\n";
    }
}
