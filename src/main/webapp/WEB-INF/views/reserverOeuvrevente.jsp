<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" >
    <jsp:param name="title" value="Réserver une oeuvre"/>
</jsp:include>

<div id="form" class="container mainContainer marginTop">

    <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h2>Réserver une oeuvre</h2>
            </div>
            <form name='identification' method="post" action="/insererReservation">
                <div class="panel-body">
                    <div class="row form-group">
                        <label class="col-xs-12" for="adherent">Adherent</label>
                        <select class="col-xs-12 selectpicker" name="adherent"id="adherent" data-live-search="true">
                            <c:forEach items="${adherents}" var="item">
                                <option value=${item.idAdherent}>${item.nomAdherent} ${item.prenomAdherent}</option>
                            </c:forEach>
                        </select>                    </div>
                    <div class="row form-group">
                        <label class="col-xs-12" for="oeuvre">Oeuvre</label>
                        <select class="col-xs-12 selectpicker" name="oeuvre" id="oeuvre" data-live-search="true">
                            <c:forEach items="${oeuvres}" var="item">
                                <c:choose>
                                    <c:when test="${item.idOeuvrevente == oeuvre.idOeuvrevente}">
                                        <option value=${item.idOeuvrevente} selected>${item.titreOeuvrevente}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value=${item.idOeuvrevente}>${item.titreOeuvrevente}</option>
                                    </c:otherwise>
                                </c:choose>
                                <option value=${item.idOeuvrevente}>${item.titreOeuvrevente}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="panel-footer">
                    <input class="btn btn-primary" type="submit" name="bt" value="Réserver">
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="includes/footer.jsp" />