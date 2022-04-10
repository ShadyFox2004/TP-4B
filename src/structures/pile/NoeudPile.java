package structures.pile;

/**
 * Classe d'implémentation d'un noeud auto-référencé d'une pile
 *
 * @author Antoine-Matis Boudreau et Samuel Nguyen-Phok
 * @version Printemps 2022
 */
public class NoeudPile
{
    /**
     * Élément à conserver
     */
    private Object element;

    /**
     * Pointeur sur le noeud qui est en dessous
     */
    private NoeudPile precedent;

    /**
     * Constructeur
     *
     * @param element l'élément à mettre dans le noeud
     */
    public NoeudPile(Object element)
    {
        setElement(element);
    }

    /**
     * Constructeur
     *
     * @param element   l'élément à mettre dans le noeud
     * @param precedent un pointeur sur un NoeudPile
     */
    public NoeudPile(Object element,
                     NoeudPile precedent)
    {
        setElement(element);
        setPrecedent(precedent);
    }

    /**
     * Obtenir l'élément contenu dans le noeud
     *
     * @return Object, l'objet dans le noeud
     */
    public Object getElement()
    {
        return element;
    }

    /**
     * Modifier la valeur de l'élément contenu dans le noeud
     *
     * @param element l'élément à mettre à jour
     */
    public void setElement(Object element)
    {
        this.element = element;
    }

    /**
     * Obtenir une référence sur le noeud précédent.
     *
     * @return NoeudPile, le pointeur sur le noeud précédent
     */
    public NoeudPile getPrecedent()
    {
        return precedent;
    }

    /**
     * Modifier la valeur de la référence du noeud précédent.
     *
     * @param precedent le pointeur du nouveau précédent
     */
    public void setPrecedent(NoeudPile precedent)
    {
        this.precedent = precedent;
    }
}
