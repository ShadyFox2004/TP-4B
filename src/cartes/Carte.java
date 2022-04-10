package cartes;

import exceptions.ConstructeurException;

/**
 * Classe permettant de représenter l'abstration d'une carte à jouer.
 * Les objets de cette classe peuvent servir à produire un paquet de cartes.
 *
 * @author Antoine-Matis Boudreau
 * @author Samuel Nguyen-Phok
 */
public class Carte implements Comparable<Carte>
{
    /**
     * Image du dos de la carte
     */
    public static char IMAGE_DOS;

    /**
     * La sorte de la carte (Coeur, carreau, pique et trèfle).
     */
    private SorteCartes sorte;

    /**
     * La valeur de la carte.
     */
    private ValeurCartes valeur;

    /**
     * Un boolean pour savoir si une carte est face visible (vrai) ou pas (faux)
     */
    private boolean visible;

    /**
     * Constructeur avec paramètres.
     *
     * @param valeur la valeur de la carte
     * @param sorte  la sorte de la carte (Coeur, carreau, pique et trèfle)
     * @throws exceptions.ConstructeurException
     */
    public Carte(ValeurCartes valeur,
                 SorteCartes sorte)
            throws exceptions.ConstructeurException
    {
        try
        {
            setValeur(valeur);
            setSorte(sorte);
            setVisible(false);
            IMAGE_DOS = ' ';
        } catch (ConstructeurException e)
        {
            throw new ConstructeurException("Paramètre invalide");
        }
    }


    /**
     * Permet de savoir si une carte est visible (face vers le haut ou pas)
     *
     * @return boolean, vrai si la face est vers le haut
     */
    public boolean estVisible()
    {
        return visible;
    }

    /**
     * Permet de modifier la visibilité d'une carte (retourne la carte), soit on voit le dos avec "false" ou sa face visible avec "true"
     *
     * @param visible vrai si on veut que la carte soit visible, faux sinon.
     */
    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    /**
     * Obtenir la représentation caractère pour la sorte de carte.
     *
     * @return char, le caractère représentant la sorte de carte.
     */
    public char getSorteSymbole()
    {
        return getSorte().getSymbole();
    }

    /**
     * Obtenir la sorte de carte (Coeur, carreau, pique et trèfle)
     *
     * @return SorteCartes, un objet énumération qui représente la sorte de la carte
     */
    public SorteCartes getSorte()
    {
        return sorte;
    }

    /**
     * Mettre à jour la sorte de carte
     *
     * @param sorte la nouvelle sorte de carte, null n'est pas accepté
     */
    private void setSorte(SorteCartes sorte)
    {
        this.sorte = sorte;
    }

    /**
     * Obtenir la représentation chaîne de caractères pour la valeur de la carte.
     *
     * @return String, la chaîne représentant la valeur de la carte.
     */
    public String getValeurSymbole()
    {
        return getValeur().getSymbole();
    }

    /**
     * Obtenir la valeur de la carte
     *
     * @return ValeurCartes un objet de l'énumération.
     */

    public ValeurCartes getValeur()
    {
        return valeur;
    }

    /**
     * Mettre à jour la valeur de la carte
     *
     * @param valeur la nouvelle valeur de la carte, null n'est pas accepté
     */
    private void setValeur(ValeurCartes valeur)
    {
        this.valeur = valeur;
    }

    /**
     * Compare 2 cartes selon leur valeur et leur sorte. Si la carte courante est < à celle reçue en entrée on retourne une valeur négative, si la carte courante est > à celle reçue en entrée on retourne une valeur positive, sinon on retourne 0.
     *
     * @param obj l'objet carte à comparer
     * @return int, une valeur négative ou = à 0 ou positive selon que l'objet courant est plus < ou = ou > que l'objet reçu en entrée.
     */
    public int compareTo(Carte obj)
    {
        int compare = -1;

        if (obj != null)
        {
            if (this.getSorte() == obj.getSorte())
            {
                compare = this.getValeur().getValeur() - obj.getValeur().getValeur();
            }
        }
        return compare;
    }

    /**
     * Permet de savoir si deux cartes sont égales en terme de valeur et de sorte. Attention pour pouvoir dire si deux cartes sont égales, il faut qu'elles soient les deux faces visibles, sinon on ne peut pas conclure qu'elles sont égales. Il ne faut pas modifier leur visibilité pour faire les comparaisons.
     *
     * @param obj l'objet à comparer avec l'objet courant "this"
     * @return boolean, vrai si les deux cartes sont visibles et qu'elles ont la même valeur et la même sorte.
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean compare = false;
        if (obj instanceof Carte)
        {
            compare = this.getSorte() == ((Carte) obj).getSorte() && this.getValeur() == ((Carte) obj).getValeur();
        }
        return compare;
    }

    /**
     * Obtenir une chaîne des infos au sujet d'une carte. Pour les tests
     */
    @Override
    public String toString()
    {
        return "Carte {" +
                "sorte = " + sorte +
                ", valeur = " + valeur +
                ", visible = " + visible +
                '}';
    }

    /**
     * Retourne l'image de la carte selon sa visibilité. Soit le dos de la carte ou sa face visible.
     *
     * @return String, l'image de la carte. Une concaténation du symbole de la valeur et du symbole de la sorte OU l'image du dos
     */
    public String toStringCarte()
    {
        // qu'est-ce que IMAGE_DOS est senser retourner ?
        String carte = "";

        if (estVisible())
        {
            carte = this.getValeurSymbole() + getSorteSymbole();
        } else
        {
            carte = String.valueOf(IMAGE_DOS);
        }
        return carte;
    }
}

