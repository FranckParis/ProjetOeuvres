<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="refresh" content="0;URL=javascript:fermer();">
    <link rel="icon" href="/resources/img/painting-landscape-icon-7.ico" />
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
    <link rel='stylesheet' href='/webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel='stylesheet' href='/webjars/bootstrap-select/1.12.0/css/bootstrap-select.min.css'>
    <link rel='stylesheet' href='/webjars/datatables/1.10.12/css/dataTables.bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/main.css">

    <script type="text/javascript" src="/webjars/jquery/2.1.1/jquery.min.js"></script>

    <title>${param.title}</title>
</head>


<script language="JavaScript">
    function fermer() {
        if (confirm("Voulez-vous vraiment quitter ?")) {
            close();
        }
    }
</script>

<body>

<div id="page-wrapper">
    <header id="header">
        <nav class="navbar navbar-default navbar-fixed-top navbarCustom">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/index.htm">Médiathèque de POLYTECH</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/index.htm">Accueil</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Adhérents <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="ajouterAdherent.htm">Ajout Adhérent</a></li>
                                <li><a href="listerAdherent.htm">Lister les adhérents</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Oeuvres <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="ajouterOeuvrevente">ajouter une oeuvre</a></li>
                                <li><a href="listerOeuvresvente">lister les oeuvres</a></li>
                                <li><a href="listerReservations">lister les réservations</a></li>
                                <li><a href="ajouterReservation">Réserver une oeuvre</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div>
        </nav>
    </header>

    <section id="main">
