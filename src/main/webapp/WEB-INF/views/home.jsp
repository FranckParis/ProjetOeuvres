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
		<div class="row box box-primary flex--center-wrap">
			<div class="col-md-6 flex--center-wrap">
				<div>
					<h3>Fonctionnalité des adhérents:</h3>
					<ul>
						<li><a href="ajouterAdherent.htm">Ajouter un adhérent</a></li>
						<li><a href="listerAdherent.htm">Lister les adhérents</a></li>
						<li><a href="javascript:fermer()">Quitter</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-6 flex--center-wrap">
				<div>
					<h3>Fonctionnalité des oeuvres:</h3>
					<ul>
						<li><a href="ajouterOeuvrevente">Ajouter une oeuvre</a></li>
						<li><a href="listerOeuvresvente">Lister les oeuvres</a></li>
						<li><a href="listerReservations">Lister les réservations</a></li>
						<li><a href="ajouterReservation">Réserver une oeuvre</a></li>
						<li><a href="javascript:fermer()">Quitter</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="includes/footer.jsp" />
