package fr.eni.papeterie.bll;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class AppliTestBLL
{

	public static void main(String[] args)
	{
		// j'ai tellement la flemme...
		
		
		
		System.out.println("###############TEST DE LA COUCHE BLL###############");
		System.out.println();
		System.out.println("Affichage du catalogue");
		try {
			for (Article art: CatalogueManager.getInstance().getCatalogue())
			  {
				  System.out.println(art.toString()); 
			  }
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
/*		System.out.println();
		System.out.println();
		System.out.println("Validation d'un article foireux");
		try
		{
//			CatalogueManager.getInstance().validerArticle(new Stylo( "Bic", "BBGreen","Bic bille Vert", 1.2f, -20, "vert"));
//			CatalogueManager.getInstance().validerArticle(new Ramette(  "Clairef", "CRA4S2", "Ramette A4 un peu moins Sup", 9f, 30, -60));
		}
		catch (BLLException e)
		{
			e.printStackTrace();
		}
*/		
/*		System.out.println();
		System.out.println();
		System.out.println("Ajout d'articles au catalogue");
		try
		{
			CatalogueManager.getInstance().addArticle(new Stylo( "Bic", "BBGreen","Bic bille Vert", 1.2f, 20, "vert"));
			CatalogueManager.getInstance().addArticle(new Ramette(  "Clairef", "CRA4S2", "Ramette A4 un peu moins Sup", 9f, 30, 60));
		}
		catch (BLLException e)
		{
			e.printStackTrace();
		}
*/		
/*		System.out.println();
		System.out.println();
		System.out.println("Affichage des deux derniers articles ajoutés");
		try
		{
			System.out.println(CatalogueManager.getInstance().getArticle(CatalogueManager.getInstance().getCatalogue().size()-2).toString());
			System.out.println(CatalogueManager.getInstance().getArticle(CatalogueManager.getInstance().getCatalogue().size()-1).toString());
		}
		catch (BLLException e)
		{
			e.printStackTrace();
		}
*/		
/*		System.out.println();
		System.out.println();
		System.out.println("MàJ d'un article");
		
		System.out.println();
		System.out.println();
		System.out.println("Suppression d'un article");
	*/
	
		
	}
}
