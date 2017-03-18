<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Réservation d'une oeuvre</title>
</head>
<SCRIPT language="Javascript" type="text/javascript"></SCRIPT>
    <script type="text/javascript" src="js/foncControle.js"></script>


<body>

<A href="index.htm"><FONT face="Arial" color="#004080">Retour
    Accueil</FONT></A>
<br/>
<A href="listerReservations"><FONT face="Arial" color="#004080">Retour
    liste réservations</FONT></A>

<H1> Réservation d'une oeuvre </H1>

<DIV align="center">
    <FORM  name='identification' method="post" action="insererReservation" onsubmit="return teste()">
        <P align="left"><FONT face="Arial" color="#004080"></FONT>

            <label for="adherent">Adherent :</label>
            <select name="adherent" value=""  id ="adherent">
                <c:forEach items="${adherents}" var="item">
                    <option value=${item.idAdherent}>${item.nomAdherent} ${item.prenomAdherent}</option>
                </c:forEach>
            </select>
            <br/>
            <label for="oeuvre">Oeuvre :</label>
            <select name="oeuvre" value=""  id ="oeuvre">
                <c:forEach items="${oeuvres}" var="item">
                    <option value=${item.idOeuvrevente}>${item.titreOeuvrevente}</option>
                </c:forEach>
            </select>

            <!-- Boutons Ajouter -->

            <INPUT type="submit" name="bt"  value="Réserver" >
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        </P></FORM>
</DIV>
<BR>
</body>
</html>