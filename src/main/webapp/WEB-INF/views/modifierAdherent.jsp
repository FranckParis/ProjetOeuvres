<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" >
    <jsp:param name="title" value="Modifier un adhérent"/>
</jsp:include>

<div id="form" class="container mainContainer marginTop">

    <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default box-primary">
            <div class="panel-heading">
                <h2>Modifier un adhérent</h2>
            </div>
            <form name='identification' method="post" action="/updateAdherent/${adherent.idAdherent}">
                <div class="panel-body">
                    <div class="form-group">
                        <label for="nom">Nom de l'adherent</label>
                        <input type="text" class="form-control" name="txtnom" id ="nom" value="${adherent.nomAdherent}" placeholder="Nom" required="required" autofocus>
                    </div>
                    <div class="form-group">
                        <label for="prenom">Prenom de l'adherent</label>
                        <input type="text" class="form-control" name="txtprenom" id ="prenom" value="${adherent.prenomAdherent}" placeholder="Prènom" required="required">
                    </div>
                    <div class="form-group">
                        <label for="nom">Ville de l'adherent</label>
                        <input type="text" class="form-control" name="txtville" id ="ville" value="${adherent.villeAdherent}" placeholder="Ville" required="required">
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