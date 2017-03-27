package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;

import java.sql.Date;
import java.util.*;

import com.epul.oeuvres.metier.*;
import com.epul.oeuvres.persistance.*;
import org.springframework.util.SocketUtils;

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

	public void supprimerAdherent(int numero) throws MonException {

		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "DELETE FROM adherent WHERE id_adherent = "+numero;
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	public Oeuvrevente rechercherOeuvreIdParam(int id) throws MonException
	{
		String mysql = "";
	 	List<Object> rs;
		Oeuvrevente uneOeuvre = null;

		try
		{
			mysql = "SELECT id_oeuvrevente, titre_oeuvrevente, etat_oeuvrevente,prix_oeuvrevente,id_proprietaire";
			mysql += " FROM oeuvrevente WHERE id_oeuvrevente = "+id;
			rs=DialogueBd.getInstance().lecture(mysql);
			System.out.println(rs);

			if (rs.size() > 0) {
				uneOeuvre = new Oeuvrevente();
				uneOeuvre.setIdOeuvrevente(Integer.parseInt(rs.get(0).toString()));
				uneOeuvre.setTitreOeuvrevente(rs.get(1).toString());
				uneOeuvre.setEtatOeuvrevente(rs.get(2).toString());
				uneOeuvre.setPrixOeuvrevente(Float.parseFloat(rs.get(3).toString()));
				int num = Integer.parseInt(rs.get(4).toString());
				// On appelle la recherche d'un propri�taire
				uneOeuvre.setProprietaire(rechercherProprietaire(num));
				System.out.println(uneOeuvre.getProprietaire().getNomProprietaire());
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

	public List<Oeuvrevente> consulterListeOeuvresventeLibres() throws MonException {
		String mysql = "SELECT * FROM oeuvrevente JOIN proprietaire ON oeuvrevente.id_proprietaire = proprietaire.id_proprietaire WHERE etat_oeuvrevente != 'R'";
		return consulterListeOeuvrevente(mysql);
	}

	private List<Oeuvrevente> consulterListeOeuvrevente(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrevente> mesOeuvresvente = new ArrayList<Oeuvrevente>();
		int index = 0;

		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = unDialogueBd.lecture(mysql);
			//System.out.println(rs);

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

				/*System.out.println(uneOeuvrevente.getIdOeuvrevente());
				System.out.println(uneOeuvrevente.getTitreOeuvrevente());
				System.out.println(uneOeuvrevente.getEtatOeuvrevente());
				System.out.println(uneOeuvrevente.getPrixOeuvrevente());
				System.out.println(uneOeuvrevente.getProprietaire().getNomProprietaire());
				System.out.println(uneOeuvrevente.getProprietaire().getPrenomProprietaire());
				System.out.println("\n");*/

				// On incr�mente tous les 4 champs
				index = index + 8;
				mesOeuvresvente.add(uneOeuvrevente);
			}

			return mesOeuvresvente;

		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public void updateOeuvre(Oeuvrevente ov) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "UPDATE oeuvrevente SET id_oeuvrevente = \"" + ov.getIdOeuvrevente()
					+ "\", titre_oeuvrevente = \"" + ov.getTitreOeuvrevente()
					+ "\", etat_oeuvrevente = \"" + ov.getEtatOeuvrevente()
					+ "\", prix_oeuvrevente = \"" + ov.getPrixOeuvrevente()
					+ "\", id_proprietaire = \"" + ov.getProprietaire().getIdProprietaire()
					+ "\" WHERE id_oeuvrevente = " + ov.getIdOeuvrevente();

			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	 
	public Proprietaire rechercherProprietaire(int id) throws MonException
	{
		String mysql = "";
	 	List<Object> rs;
		Proprietaire unProprietaire = null;

		mysql = " select * from proprietaire where id_proprietaire = "+id;

		try 
		{
			rs=DialogueBd.getInstance().lecture(mysql);
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

	// Consultation des réservations
	// Fabrique et renvoie une liste d'objets Reservation contenant le r�sultat de
	// la requ�te BDD
	public List<Reservation> consulterListeReservation() throws MonException {
		String mysql = "SELECT * FROM reservation JOIN adherent ON reservation.id_adherent = adherent.id_adherent JOIN oeuvrevente ON oeuvrevente.id_oeuvrevente = reservation.id_oeuvrevente JOIN proprietaire ON oeuvrevente.id_proprietaire = proprietaire.id_proprietaire";
		//System.out.println(mysql);
		return consulterListeReservation(mysql);
	}

	private List<Reservation> consulterListeReservation(String mysql) throws MonException {

		List<Object> rs;
		List<Reservation> reservations = new ArrayList<>();
		int index = 0;
		int cpt = 0;

		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = unDialogueBd.lecture(mysql);
			//System.out.println(rs);

			while (index < rs.size()) {
				Reservation res = new Reservation();

				// Date
				res.setDate(Date.valueOf(rs.get(index + 2).toString()));

				//Statut
				res.setStatut(rs.get(index + 3).toString());

				//Adherent
				Adherent ad = new Adherent();
				ad.setIdAdherent(Integer.parseInt(rs.get(index + 4).toString()));
				ad.setNomAdherent(rs.get(index + 5).toString());
				ad.setPrenomAdherent(rs.get(index + 6).toString());
				ad.setVilleAdherent(rs.get(index + 7).toString());

				//Oeuvrevente
				Oeuvrevente ov = new Oeuvrevente();
				ov.setIdOeuvrevente(Integer.parseInt(rs.get(index + 8).toString()));
				ov.setTitreOeuvrevente(rs.get(index + 9).toString());
				ov.setEtatOeuvrevente(rs.get(index + 10).toString());
				ov.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 11).toString()));

				//Proprietaire
				Proprietaire prop = new Proprietaire();
				prop.setIdProprietaire(Integer.parseInt(rs.get(index + 12).toString()));
				prop.setNomProprietaire(rs.get(index + 14).toString());
				prop.setPrenomProprietaire(rs.get(index + 15).toString());

				//Assignations
				res.setAdherent(ad);
				ov.setProprietaire(prop);
				res.setOeuvrevente(ov);

				// On incr�mente tous les 15 champs
				index = index + 16;

				reservations.add(res);
				//Display
				//System.out.println(cpt);
				//cpt++;
			}

			return reservations;

		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public void insertReservation(Reservation res) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "INSERT INTO reservation (id_oeuvrevente, id_adherent, date_reservation, statut) VALUES('"
					+res.getOeuvrevente().getIdOeuvrevente()+"', '"
					+res.getAdherent().getIdAdherent()+"', '"
					+res.getDate()+"', '"
					+res.getStatut()+"')";

			System.out.println(mysql);

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public void supprimerReservation(int numeroOeuvre) throws MonException {

		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "DELETE FROM reservation WHERE id_oeuvrevente = "+numeroOeuvre;
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	public void updateReservation(Reservation res) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "UPDATE reservation SET id_oeuvrevente = \"" + res.getOeuvrevente().getIdOeuvrevente()
					+ "\", id_adherent = \"" + res.getAdherent().getIdAdherent()
					+ "\", date_reservation = \"" + res.getDate()
					+ "\", statut = \"" + res.getStatut()
					+ "\" WHERE id_oeuvrevente = " + res.getOeuvrevente().getIdOeuvrevente();

			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	public Reservation rechercherReservationIdParam(int id) throws MonException
	{
		String mysql = "";
		List<Object> rs;
		Reservation res = null;

		try
		{
			mysql = "SELECT id_oeuvrevente, id_adherent, date_reservation, statut";
			mysql += " FROM reservation WHERE id_oeuvrevente = "+id;
			rs=DialogueBd.getInstance().lecture(mysql);
			System.out.println(rs);

			if (rs.size() > 0) {
				res = new Reservation();

				Oeuvrevente ov = rechercherOeuvreIdParam(Integer.parseInt(rs.get(0).toString()));
				Adherent ad = consulterAdherent(Integer.parseInt(rs.get(1).toString()));

				res.setDate(Date.valueOf(rs.get(2).toString()));
				res.setStatut(rs.get(3).toString());
				res.setOeuvrevente(ov);
				res.setAdherent(ad);
			}
		}

		catch (MonException e)
		{
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
		return res;
	}

	// Consultation des propriétaires
	// Fabrique et renvoie une liste d'objets Propriétaire contenant le r�sultat de
	// la requ�te BDD
	public List<Proprietaire> consulterListeProprietaires() throws MonException {
		String mysql = "SELECT * FROM proprietaire";
		return consulterListeProprietaires(mysql);
	}

	private List<Proprietaire> consulterListeProprietaires(String mysql) throws MonException {

		List<Object> rs;
		List<Proprietaire> props = new ArrayList<>();
		int index = 0;
		int cpt = 0;

		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = unDialogueBd.lecture(mysql);
			//System.out.println(rs);

			while (index < rs.size()) {
				Proprietaire prop = new Proprietaire();

				// Id
				prop.setIdProprietaire(Integer.parseInt(rs.get(index).toString()));

				//Nom
				prop.setNomProprietaire(rs.get(index + 1).toString());

				//Prenom
				prop.setPrenomProprietaire(rs.get(index + 2).toString());


				// On incr�mente tous les 15 champs
				index = index + 3;

				props.add(prop);

			}

			return props;

		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public void insertOeuvrevente(Oeuvrevente ov) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "INSERT INTO oeuvrevente (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire) VALUES('"
					+ov.getTitreOeuvrevente()+"', '"
					+ov.getEtatOeuvrevente()+"', '"
					+ov.getPrixOeuvrevente()+"', '"
					+ov.getProprietaire().getIdProprietaire()+"')";

			System.out.println(mysql);

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public void supprimerOeuvrevente(int numeroOeuvre) throws MonException {

		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "DELETE FROM oeuvrevente WHERE id_oeuvrevente = "+numeroOeuvre;
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	public void supprimerReservationsOeuvre(int numeroOeuvre) throws MonException {

		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "DELETE FROM reservation WHERE id_oeuvrevente = "+numeroOeuvre;
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
}
