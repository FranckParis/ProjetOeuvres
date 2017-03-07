<%--
  Created by IntelliJ IDEA.
  User: franck
  Date: 3/1/17
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modifier un  adhérent</title>
</head>
<SCRIPT language="Javascript" type="text/javascript">
    <script type="text/javascript" src="js/foncControle.js"></script>


<body>
<H1> Modification d'un adhérent </H1>

<DIV align="center">
    <FORM  name='identification' method="post" action="Controleur?action=updateAdherent?id=${adherent.idAdherent}" onsubmit="return teste()">
        <P align="left"><FONT face="Arial" color="#004080"></FONT>
            <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Nom de l'adherent : </FONT>
            <INPUT type="text" name="txtnom" value="${adherent.nomAdherent}"  id ="nom"> <BR>
            <FONT face="Arial" color="#004080">
                <BR>Prenom de l'adherent : </FONT>
            <INPUT type="text" name="txtprenom"  id ="prenom" value="${adherent.prenomAdherent}" > <BR>

            <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Ville de l'adherent :</FONT>
            <INPUT type="text" name="txtville" id ="ville" value="${adherent.villeAdherent}">
            <FONT face="Arial" color="#004080">	<BR></FONT><BR>

            <!-- Boutons Modifier -->

            <INPUT type="submit" name="bt"  value="Modifier" >
            <FONT face="Arial" color="#004080"></FONT>
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        </P></FORM>

    <button type="button"><a href="Controleur?action=listerAdherent">Retour</a></button>
</DIV>
<BR>
</body>
</html>
