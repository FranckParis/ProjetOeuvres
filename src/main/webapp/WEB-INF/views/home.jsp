<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" >
	<jsp:param name="title" value="Expo : Médiathèque De POLYTECH"/>
</jsp:include>

<div id="index">
	<div class="title flex-start-center-wrap">
		<div class="col-md-7">
			<img src="/resources/img/banniere-deco-mediatheque_0.jpg" class="img-responsive" alt="Responsive image">
		</div>
		<div class="col-md-5">
			<h1>Médiathèque de POLYTECH</h1>
			<h2>Gestion de l'exposition 2016</h2>
		</div>
	</div>

	<div class="container mainContainer">
		<div class="row jumbotron">
			<div class="col-md-6">
				<h3>Sélectionnez la fonctionnalité voulue:</h3>
				<ul>
					<li><a href="ajouterAdherent.htm">Ajout Adhérent</a></li>
					<li><a href="listerAdherent.htm">lister les adhérents</a></li>
					<li><a href="javascript:fermer()">Quitter</a></li>
				</ul>
			</div>
			<div class="col-md-6">
				<h3>Sélectionnez la fonctionnalité voulue:</h3>
				<ul>
					<li><a href="ajouterOeuvrevente">ajouter une oeuvre</a></li>
					<li><a href="listerOeuvresvente">lister les oeuvres</a></li>
					<li><a href="listerReservations">lister les réservations</a></li>
					<li><a href="ajouterReservation">Réserver une oeuvre</a></li>
					<li><a href="javascript:fermer()">Quitter</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<jsp:include page="includes/footer.jsp" />
