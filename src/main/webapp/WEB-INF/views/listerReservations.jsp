<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Affichage de toutes les réservations</title>
</head>
<body>
<P>
    <A href="/index.htm"><FONT face="Arial" color="#004080">Retour
        Accueil</FONT></A>
    <br/>
    <A href="ajouterReservation"><font
            face="Arial">Créer une réservation</font></A>
</P>
<P align="center">
    <FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
        Réservations </STRONG></U></FONT>
</P>

<TABLE BORDER="1">
    <CAPTION>Tableau des Réservations</CAPTION>
    <TR>
        <TH>Nom adherent</TH>
        <TH>Prenom adherent</TH>
        <TH>Date</TH>
        <TH>Oeuvre</TH>
        <TH>Nom propriétaire</TH>
        <TH>Prenom propriétaire</TH>
        <TH>Statut</TH>
        <TH>Confirmer</TH>
        <TH>Supprimer</TH>
    </TR>

    <c:forEach items="${reservations}" var="item">
        <tr>
            <td>${item.adherent.nomAdherent}</td>
            <td>${item.adherent.prenomAdherent}</td>
            <td>${item.date}</td>
            <td>${item.oeuvrevente.titreOeuvrevente}</td>
            <td>${item.oeuvrevente.proprietaire.nomProprietaire}</td>
            <td>${item.oeuvrevente.proprietaire.prenomProprietaire}</td>
            <td>${item.statut}</td>
            <c:choose>
                <c:when test="${item.statut != 'confirmee'}">
                    <td><a href="confirmerReservation/${item.oeuvrevente.idOeuvrevente}"><font
                        face="Arial">Confirmer</font></a></td>
                </c:when>
                <c:otherwise>
                    <td>Unavailable</td>
                </c:otherwise>
            </c:choose>
            <td><a href="supprimerReservation/${item.oeuvrevente.idOeuvrevente}"><font
                    face="Arial">Supprimer</font></a></td>
        </tr>
    </c:forEach>
</TABLE>
</body>
</html>