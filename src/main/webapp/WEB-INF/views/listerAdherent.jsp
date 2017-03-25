<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" >
	<jsp:param name="title" value="Affichage de tous les adhérents"/>
</jsp:include>

<div id="list" class="container mainContainer">
	<div class="title">
		<h1>Listing des Adhérents</h1>
	</div>
	<div class="col-xs-12 col-md-10 col-md-offset-1 col-lg-12 col-lg-offset-0">
		<TABLE id="listAdherents" class="table table-striped table-bordered table-hover customTable">
			<thead>
			<TR>
				<TH class="tiny">Numero</TH>
				<TH>Nom</TH>
				<TH>Prénom</TH>
				<TH>Ville</TH>
				<TH data-orderable="false" class="medium">Options</TH>
			</TR>
			</thead>

			<tbody>
			<c:forEach items="${mesAdherents}" var="item">
				<tr>
					<td>${item.idAdherent}</td>
					<td>${item.nomAdherent}</td>
					<td>${item.prenomAdherent}</td>
					<td>${item.villeAdherent}</td>
					<td>
						<div class="btn-group btn-group-sm btn-group-justified" role="group">
							<a class="btn btn-primary" href="modifierAdherent/${item.idAdherent}">Modifier
							</a>
							<a class="btn btn-danger" href="supprimerAdherent/${item.idAdherent}">Supprimer</a>
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
        $('#listAdherents').dataTable( {
            "order": [[0, "asc"]],
            "autoWidth": false,
            fixedHeader: true
        });
    });
</script>

<jsp:include page="includes/footer.jsp" />
