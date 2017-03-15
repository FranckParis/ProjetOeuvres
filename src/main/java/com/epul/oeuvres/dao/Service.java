package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import java.util.*;

import com.epul.oeuvres.metier.*;
import com.epul.oeuvres.persistance.*;

public class Service {

	// Mise � jour des caract�ristiques d'un adh�rent
	// Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
	// une cr�ation

	public void insertAdherent(Adherent unAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ unAdherent.getNomAdherent();
			mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	// gestion des adherents
	// Consultation d'un adh�rent par son num�ro
	// Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
	// BDD
	public Adherent consulterAdherent(int numero) throws MonException {
		
		 //Map mParams = new HashMap();
	     //Map mParam;
	  try
	  {
		String mysql = "select * from adherent where id_adherent = "+numero;
		 //mParam = new HashMap();
	     //mParam.put(1, numero);
	     //mParams.put(0, mParam);
		List<Adherent> mesAdh = consulterListeAdherents(mysql);
		if (mesAdh.isEmpty())
			return null;
		else {
			return mesAdh.get(0);
		}
	  } catch (MonException e)
		{
			throw e;
		}
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Adherent> consulterListeAdherents() throws MonException {
		String mysql = "select * from adherent";
		return consulterListeAdherents(mysql);
	}

	private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
		List<Object> rs;
		List<Adherent> mesAdherents = new ArrayList<Adherent>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs =unDialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Adherent unA = new Adherent();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setNomAdherent(rs.get(index + 1).toString());
				unA.setPrenomAdherent(rs.get(index + 2).toString());
				unA.setVilleAdherent(rs.get(index + 3).toString());
				// On incr�mente tous les 3 champs
				index = index + 4;
				mesAdherents.add(unA);
			}

			return mesAdherents;
		} catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public void updateAdherent(Adherent unAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "UPDATE adherent SET nom_adherent = \""+unAdherent.getNomAdherent()
					+ "\", prenom_adherent = \""+ unAdherent.getPrenomAdherent()
					+ "\", ville_adherent = \""+ unAdherent.getVilleAdherent()
					+ "\" WHERE id_adherent = "+ unAdherent.getIdAdherent();

			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	public Oeuvrevente rechercherOeuvreIdParam(int id) throws MonException
	{
		
		String mysql = "";
		 Map mParams = new HashMap();
	     Map mParam;
	 	List<Object> rs;
		Oeuvrevente uneOeuvre=null;;
		try
		{
			mysql = "SELECT id_oeuvrevente, titre_oeuvrevente, etat_oeuvrevente,prix_oeuvrevente,id_proprietaire";
			mysql += " FROM Oeuvrevente WHERE id_Oeuvrevente = ? ";
		     mParam = new HashMap();
		     mParam.put(1, id);
		     mParams.put(0, mParam);  
		     rs=DialogueBd.getInstance().lectureParametree(mysql, mParams);
		     if (rs.size() > 0) {
					
					uneOeuvre = new Oeuvrevente();
					uneOeuvre.setIdOeuvrevente(Integer.parseInt(rs.get(0).toString()));
					uneOeuvre.setTitreOeuvrevente(rs.get(1).toString());
					uneOeuvre.setEtatOeuvrevente(rs.get(2).toString());
					uneOeuvre.setPrixOeuvrevente(Float.parseFloat(rs.get(3).toString()));
					int num = Integer.parseInt(rs.get(4).toString());
					// On appelle la recherche d'un propri�taire
					uneOeuvre.setProprietaire(rechercherProprietaire(num));
				}
		} 
		
		catch (MonException e)
		{
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
		return uneOeuvre;
		
	}

	// Consultation des Oeuvresvente
	// Fabrique et renvoie une liste d'objets Oeuvrevente contenant le r�sultat de
	// la requ�te BDD
	public List<Oeuvrevente> consulterListeOeuvrevente() throws MonException {
		String mysql = "SELECT * FROM oeuvrevente JOIN proprietaire ON oeuvrevente.id_proprietaire = proprietaire.id_proprietaire";
		return consulterListeOeuvrevente(mysql);
	}

	private List<Oeuvrevente> consulterListeOeuvrevente(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrevente> mesOeuvresvente = new ArrayList<Oeuvrevente>();
		int index = 0;

		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = unDialogueBd.lecture(mysql);
			System.out.println(rs);

			while (index < rs.size()) {
				Oeuvrevente uneOeuvrevente = new Oeuvrevente();
				// il faut redecouper la liste pour retrouver les lignes
				uneOeuvrevente.setIdOeuvrevente(Integer.parseInt(rs.get(index + 0).toString()));
				uneOeuvrevente.setTitreOeuvrevente(rs.get(index + 1).toString());
				uneOeuvrevente.setEtatOeuvrevente(rs.get(index + 2).toString());
				uneOeuvrevente.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));

				Proprietaire prop = new Proprietaire();
				prop.setIdProprietaire(Integer.parseInt(rs.get(index + 4).toString()));
				prop.setNomProprietaire(rs.get(index + 6).toString());
				prop.setPrenomProprietaire(rs.get(index + 7).toString());

				uneOeuvrevente.setProprietaire(prop);

				System.out.println(uneOeuvrevente.getIdOeuvrevente());
				System.out.println(uneOeuvrevente.getTitreOeuvrevente());
				System.out.println(uneOeuvrevente.getEtatOeuvrevente());
				System.out.println(uneOeuvrevente.getPrixOeuvrevente());
				System.out.println(uneOeuvrevente.getProprietaire().getNomProprietaire());
				System.out.println(uneOeuvrevente.getProprietaire().getPrenomProprietaire());
				System.out.println("\n");

				// On incr�mente tous les 4 champs
				index = index + 8;
				mesOeuvresvente.add(uneOeuvrevente);
			}

			return mesOeuvresvente;

		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	
	 
	public Proprietaire rechercherProprietaire(int  id) throws MonException
	{
		
		String mysql = "";
		 Map mParams = new HashMap();
	     Map mParam;
	 	List<Object> rs;
		Proprietaire  unProprietaire=null;
		String requete = " select * from Proprietaire where id_Proprietaire ?";
		try 
		{
			 mParam = new HashMap();
		     mParam.put(1, id);
		     mParams.put(0, mParam);  
		     rs=DialogueBd.getInstance().lectureParametree(mysql, mParams);
			if (rs.size() > 0) {
			
				unProprietaire = new Proprietaire();
				
				unProprietaire.setIdProprietaire(Integer.parseInt(rs.get(0).toString()));
				unProprietaire.setNomProprietaire(rs.get(1).toString());
				unProprietaire.setPrenomProprietaire(rs.get(2).toString());
			}
		}

		catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
		return unProprietaire;
	}	

	
	

}
