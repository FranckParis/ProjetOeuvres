package com.epul.oeuvres.controle;

//import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
//import com.epul.metier.*;
//import com.epul.meserreurs.*;



import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.meserreurs.*;
import com.epul.oeuvres.metier.*;







import org.springframework.ui.Model;


import java.sql.*;
import java.sql.Date;
import java.util.*;

///
/// Les m�thode du contr�leur r�pondent � des sollicitations
/// des pages JSP

@Controller
public class MultiControleur {

//	private static final Logger logger = LoggerFactory.getLogger(MultiControleur.class);

	@RequestMapping(value = "listerAdherent.htm")
	public ModelAndView afficherLesStages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			Service unService = new Service();
			request.setAttribute("mesAdherents", unService.consulterListeAdherents());
			destinationPage = "listerAdherent";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "insererAdherent.htm")
	public ModelAndView insererAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			Adherent unAdherent = new Adherent();
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			Service unService = new Service();
			unService.insertAdherent(unAdherent);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";
		}
		destinationPage = "home";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "ajouterAdherent.htm")
	public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			destinationPage = "ajouterAdherent";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "rreur";
		}

		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "updateAdherent/{id}")
	public ModelAndView updateAdherent(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") int id) throws Exception {

		//String destinationPage = "";
		try {
			Adherent unAdherent = new Adherent();
			unAdherent.setIdAdherent(id);
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			Service unService = new Service();
			unService.updateAdherent(unAdherent);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			//destinationPage = "Erreur";
		}
		//destinationPage = "/listerAdherent";
		return new ModelAndView("redirect:/listerAdherent.htm");
	}

	@RequestMapping(value = "modifierAdherent/{id}")
	public ModelAndView modifierAdherent(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") int id) throws Exception {

		String destinationPage = "";
		try {
			Service unService = new Service();
			request.setAttribute("adherent", unService.consulterAdherent(id));
			request.setAttribute("idAdherent", id);
			destinationPage = "/modifierAdherent";

		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";
		}

		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "supprimerAdherent/{id}")
	public ModelAndView supprimerAdherent(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") int id) throws Exception {

		//String destinationPage = "";
		try {
			Service unService = new Service();
			unService.supprimerAdherent(id);
			//destinationPage = "modifierAdherent";

		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			//destinationPage = "Erreur";
		}

		return new ModelAndView("redirect:/listerAdherent.htm");
	}

	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "index.htm", method = RequestMethod.GET)
	public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("home");
	}

	// /
		// / Affichage de la page d'accueil
		// /
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return new ModelAndView("home");
		}
	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
	public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("Erreur");
	}

	@RequestMapping(value = "listerOeuvresvente")
	public ModelAndView listerOeuvresvente(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			Service unService = new Service();
			request.setAttribute("mesOeuvresvente", unService.consulterListeOeuvrevente());
			destinationPage = "listerOeuvresvente";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "listerReservations")
	public ModelAndView listerReservations(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			Service unService = new Service();
			request.setAttribute("reservations", unService.consulterListeReservation());
			destinationPage = "listerReservations";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";
		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "ajouterReservation")
	public ModelAndView ajouterReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			Service unService = new Service();
			request.setAttribute("adherents", unService.consulterListeAdherents());
			request.setAttribute("oeuvres", unService.consulterListeOeuvresventeLibres());
			destinationPage = "ajouterReservation";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";
		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "insererReservation")
	public ModelAndView insererReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//String destinationPage = "";
		try {
			Service unService = new Service();
			Reservation res = new Reservation();

			Adherent ad = unService.consulterAdherent(Integer.parseInt(request.getParameter("adherent")));
			Oeuvrevente ov = unService.rechercherOeuvreIdParam(Integer.parseInt(request.getParameter("oeuvre")));
			java.sql.Date date = new Date(System.currentTimeMillis());

			res.setDate(date);
			res.setAdherent(ad);
			res.setOeuvrevente(ov);
			res.setStatut("non confirmee");

			unService.insertReservation(res);

			ov.setEtatOeuvrevente("R");
			unService.updateOeuvre(ov);

		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			//destinationPage = "Erreur";
		}
		//destinationPage = "/listerReservations";
		return new ModelAndView("redirect:/listerReservations");
	}

	@RequestMapping(value = "supprimerReservation/{id}")
	public ModelAndView supprimerReservation(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") int id) throws Exception {

		//String destinationPage = "";
		try {
			Service unService = new Service();
			unService.supprimerReservation(id);
			Oeuvrevente ov = unService.rechercherOeuvreIdParam(id);
			ov.setEtatOeuvrevente("L");
			unService.updateOeuvre(ov);

			//destinationPage = "modifierAdherent";

		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			//destinationPage = "Erreur";
		}

		return new ModelAndView("redirect:/listerReservations");
	}

	@RequestMapping(value = "confirmerReservation/{id}")
	public ModelAndView confirmerReservation(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="id") int id) throws Exception {

		//String destinationPage = "";
		try {
			Service unService = new Service();
			Reservation res = unService.rechercherReservationIdParam(id);
			res.setStatut("confirmee");
			unService.updateReservation(res);

			//destinationPage = "modifierAdherent";

		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			//destinationPage = "Erreur";
		}

		return new ModelAndView("redirect:/listerReservations");
	}
}
