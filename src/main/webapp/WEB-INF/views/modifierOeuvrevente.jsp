<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" >
    <jsp:param name="title" value="modifier une oeuvre"/>
</jsp:include>

<div id="form" class="container mainContainer marginTop">

    <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h2>Modification d'une oeuvre</h2>
            </div>
            <form name='identification' method="post" action="/updateOeuvrevente/${oeuvre.idOeuvrevente}">
                <div class="panel-body">
                    <div class="form-group">
                        <label for="titre">Titre de l'oeuvre</label>
                        <input type="text" class="form-control" name="titre" id ="titre" value="${oeuvre.titreOeuvrevente}" placeholder="Titre" required="required" autofocus>
                    </div>
                    <div class="form-group">
                        <label for="prix">Prix de l'oeuvre</label>
                        <input type="text" class="form-control" name="prix" id ="prix" value="${oeuvre.prixOeuvrevente}" placeholder="Prix" required="required">
                    </div>
                    <div class="row form-group">
                        <label class="col-xs-12" for="prop">Propriétaire</label>
                        <select class="col-xs-12 selectpicker" name="prop" id="prop" data-live-search="true">
                            <c:forEach items="${props}" var="item">
                                <c:choose>
                                    <c:when test="${item.idProprietaire == oeuvre.proprietaire.idProprietaire}">
                                        <option value=${item.idProprietaire} selected>${item.nomProprietaire} ${item.prenomProprietaire}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value=${item.idProprietaire}>${item.nomProprietaire} ${item.prenomProprietaire}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="panel-footer">
                    <input class="btn btn-primary" type="submit" name="bt" value="Modifier">
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="includes/footer.jsp" />