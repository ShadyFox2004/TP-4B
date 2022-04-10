package cartes;

public enum ValeurCartes
{
	V_AS("A", 1), V_2("2", 2), V_3("3", 3), V_4("4", 4), V_5("5", 5), V_6("6",
			6), V_7("7", 7), V_8("8", 8), V_9("9", 9), V_10("10",
					10), V_JACK("J", 11), V_QUEEN("Q", 12), V_KING("K", 13);

	private String symbole = null;
	private int valeur = 0;

	private ValeurCartes(String symbole, int valeur)
	{
		setSymbole(symbole);
		setValeur(valeur);
	}

	public String getSymbole()
	{
		return symbole;
	}

	private void setSymbole(String symbole)
	{
		this.symbole = symbole;
	}

	public int getValeur()
	{
		return valeur;
	}

	private void setValeur(int valeur)
	{
		this.valeur = valeur;
	}

	@Override
	public String toString()
	{
		return getValeur() + " " + getSymbole();
	}
}
