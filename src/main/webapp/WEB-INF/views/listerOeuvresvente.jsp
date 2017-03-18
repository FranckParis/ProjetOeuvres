<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Affichage de tous les Oeuvres</title>
</head>
<body>
<P>
    <A href="/index.htm"><FONT face="Arial" color="#004080">Retour
        Accueil</FONT></A>
</P>
<P align="center">
    <FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
        Oeuvres </STRONG></U></FONT>
</P>

<TABLE BORDER="1">
    <CAPTION>Tableau des Oeuvres</CAPTION>
    <TR>
        <TH>Titre</TH>
        <TH>Etat</TH>
        <TH>Prix</TH>
        <TH>Nom Propriétaire</TH>
        <TH>Prénom Propriétaire</TH>
        <TH>Réserver Oeuvre</TH>
    </TR>

    <c:forEach items="${mesOeuvresvente}" var="item">
        <tr>
            <td>${item.titreOeuvrevente}</td>
            <td>${item.etatOeuvrevente}</td>
            <td>${item.prixOeuvrevente}</td>
            <td>${item.proprietaire.nomProprietaire}</td>
            <td>${item.proprietaire.prenomProprietaire}</td>
            <c:choose>
                <c:when test="${item.etatOeuvrevente != 'R'}">
                    <td><a href="ajouterReservation"><font
                            face="Arial">Réserver</font></a></td>
                </c:when>
                <c:otherwise>
                    <td>Unavailable</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</TABLE>
</body>
</html>