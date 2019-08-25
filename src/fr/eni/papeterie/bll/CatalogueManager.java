package fr.eni.papeterie.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.papeterie.bo.*;
import fr.eni.papeterie.dal.*;
import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

public final class CatalogueManager
{	
	private List <Article> catalogue= new ArrayList <Article>();
	ArticleDAO articleDAO = (ArticleDAO) new ArticleDAOJdbcImpl();
	
	//Single instance
	private static CatalogueManager instance;

	
	public void setCatalogue(List<Article> catalogue) {
		this.catalogue = catalogue;
	}

	//Constructor
	private CatalogueManager() throws BLLException
	{
		try
		{
			setCatalogue(articleDAO.selectAll());
		}
		catch (Exception e)
		{
			throw new BLLException("Catalog failed to be generated - " , e);
		}
	}
	
	//Pseudo-Constructor
	public static synchronized CatalogueManager getInstance() throws BLLException
	{
		if (instance==null)
		{
			instance= new CatalogueManager();
		}
		return instance;
	}
	
	//Methods
	public List<Article> getCatalogue()
	{
		return catalogue;
	}

	public int addArticle (Article a) throws BLLException
	{
		try
		{
			this.validerArticle(a);
			articleDAO.insert(a);
			this.getCatalogue().add(a);
			return this.getCatalogue().size();
		}
		catch (DALException e)
		{
			throw new BLLException("Article add failed - " , e);
		}
		
	}
	
	public void updateArticle (Article a) throws BLLException
	{
		try
		{
			this.validerArticle(a);
			articleDAO.update(a);
		}
		catch (Exception e)
		{
			throw new BLLException("Article update failed - " , e);
		}
	}
	
	public void removeArticle (int index) throws BLLException
	{
		try
		{
			articleDAO.delete(index);
			this.getCatalogue().remove(index);
		}
		catch (DALException e)
		{
			throw new BLLException("Article removal failed - " , e);
		}
		
	}
	
	public void validerArticle (Article a) throws BLLException
	{
		try
		{
			if (a.getQteStock()<0)
			{
				throw new BLLException ("Invalid article");
			}
			if (a instanceof Stylo && ((Stylo) a).getCouleur()==null)
			{
				throw new BLLException ("Invalid article");
			}
			if (a instanceof Ramette && (((Ramette) a).getGrammage()<0))
			{
				throw new BLLException ("Invalid article");
			}
		}
		catch (Exception e)
		{
			throw new BLLException("Article validation failed - " , e);
		}
	}
	
	public Article getArticle (int index) throws BLLException
	{
		try
		{
			return this.getCatalogue().get(index);
		}
		catch (Exception e)
		{
			throw new BLLException("Article selection failed - " , e);
		}
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
}
