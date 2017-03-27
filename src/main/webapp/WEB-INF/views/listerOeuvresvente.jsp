<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" >
    <jsp:param name="title" value="Listing des oeuvres"/>
</jsp:include>


<div id="list" class="container mainContainer">
    <div class="title">
        <h1 class="centralTitle">Listing des oeuvres</h1>
    </div>
    <div class="col-xs-12 col-md-10 col-md-offset-1 col-lg-12 col-lg-offset-0">
        <TABLE id="listOeuvres" class="table table-striped table-bordered table-hover customTable">
            <thead>
                <TR>
                    <TH>Titre</TH>
                    <TH>Prix</TH>
                    <TH>Nom Propriétaire</TH>
                    <TH>Prénom Propriétaire</TH>
                    <TH data-orderable="false" class="large">Options</TH>
                </TR>
            </thead>

            <tbody>
                <c:forEach items="${mesOeuvresvente}" var="item">
                    <tr>
                        <td>${item.titreOeuvrevente}</td>
                        <td>${item.prixOeuvrevente} €</td>
                        <td>${item.proprietaire.nomProprietaire}</td>
                        <td>${item.proprietaire.prenomProprietaire}</td>
                        <td>
                            <div class="btn-group btn-group-sm btn-group-justified" role="group">
                                <c:choose>
                                    <c:when test="${item.etatOeuvrevente != 'R'}">
                                        <a class="btn btn-primary" href="/reserverOeuvrevente/${item.idOeuvrevente}">Réserver</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="btn btn-default disabled" href="/ajouterReservation" disabled>Réservé</a>
                                    </c:otherwise>
                                </c:choose>
                                <a class="btn btn-warning" href="/modifierOeuvrevente/${item.idOeuvrevente}">Modifier</a>
                                <a class="btn btn-danger" href="/supprimerOeuvrevente/${item.idOeuvrevente}">Supprimer</a>
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
        $('#listOeuvres').dataTable( {
            "order": [[0, "asc"]],
            "autoWidth": false,
            fixedHeader: true
        });
    });
</script>

<jsp:include page="includes/footer.jsp" />
