package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier
{
	private float montant;
	private List <Ligne> lignesPanier= new ArrayList <Ligne>();
	
	//Getters/Setters
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public Ligne getLigne(int index) {
		return this.lignesPanier.get(index);
	}
//	public void setLigne(Ligne ligne) {
//		this.ligne = ligne;
//	}
	public List<Ligne> getlignesPanier() {
		return lignesPanier;
	}
//	public void setLignesPanier(List<Ligne> lignesPanier) {
//		lignesPanier = lignesPanier;
//	}
	
	public void addLigne (Article article, int qte)
	{
		this.lignesPanier.add(new Ligne(article, qte));
	}
	public void updateLigne (int index, int newQte)
	{
		this.lignesPanier.get(index).setQte(newQte);
	}
	public void removeLigne(int index)
	{
		this.lignesPanier.remove(index);
	}
	
	public Panier ()
	{
		this.montant=0;
	}
	
	@Override
	public String toString() {
		String msg="";
		String msg1="";
		String msg2="";
		int total= 0;
		for (Ligne l:lignesPanier)
		{
			msg1+=" Ligne " + lignesPanier.indexOf(l)+ ": " + l.toString()+"] " + "\n";
			total+=l.getPrix();
			msg2="\nValeur du panier : " + total;
		}		
		msg=msg1+msg2;
		return msg;
	}

}