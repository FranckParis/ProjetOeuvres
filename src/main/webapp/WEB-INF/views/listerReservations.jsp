<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" >
    <jsp:param name="title" value="Affichage de toutes les réservations"/>
</jsp:include>

<div id="list" class="container mainContainer">
    <div class="title">
        <h1>Listing des Réservations</h1>
    </div>
    <div class="col-xs-12 col-md-10 col-md-offset-1 col-lg-12 col-lg-offset-0">
        <TABLE id="listReservations" class="table table-striped table-bordered table-hover customTable">
            <thead>
                <TR>
                    <TH>Nom adherent</TH>
                    <TH>Prenom adherent</TH>
                    <TH>Date</TH>
                    <TH>Oeuvre</TH>
                    <TH>Nom propriétaire</TH>
                    <TH>Prenom propriétaire</TH>
                    <TH>Statut</TH>
                    <TH data-orderable="false">Options</TH>
                </TR>
            </thead>

            <tbody>
                <c:forEach items="${reservations}" var="item">
                    <tr>
                        <td>${item.adherent.nomAdherent}</td>
                        <td>${item.adherent.prenomAdherent}</td>
                        <td>${item.date}</td>
                        <td>${item.oeuvrevente.titreOeuvrevente}</td>
                        <td>${item.oeuvrevente.proprietaire.nomProprietaire}</td>
                        <td>${item.oeuvrevente.proprietaire.prenomProprietaire}</td>
                        <td>${item.statut}</td>
                        <td>
                            <div class="btn-group btn-group-sm" role="group">
                        <c:choose>
                            <c:when test="${item.statut != 'confirmee'}">
                                <a class="btn btn-primary" href="confirmerReservation/${item.oeuvrevente.idOeuvrevente}">Confirmer</a>
                            </c:when>
                        </c:choose>
                        <a class="btn btn-danger" href="supprimerReservation/${item.oeuvrevente.idOeuvrevente}">Supprimer</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </TABLE>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $('#listReservations').dataTable( {
            "order": [[0, "asc"]],
            "autoWidth": false,
            fixedHeader: true
        });
    });
</script>

<jsp:include page="includes/footer.jsp" />