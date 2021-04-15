<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Affichage Utilisateur</title>


<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- CSS -->
<link rel="stylesheet" href="css/creationCompte.css">


</head>
<body>
<%@ include file="headerConnexion.jspf" %> <!-- code d'inclusion de la jspf header /!\ attention au chemin du fichier, il peut etre different -->
	
	<div class="container-fluid">
		
		<form action="" role="form">
			<div class="form-group">
		
				<div class="form-group row">
						<label for="pseudo" class="col-lg-1 col-sm-5 col-form-label">Pseudo</label>
						<div class="col-lg-5 col-sm-8">
						<input type="text" class="form-control" name="pseudo" id="pseudo" value="<c:out value="${user.pseudo}"/>" />
						<p class="font-italic text-danger"><small>${erreur['pseudo']}</small></p>
					</div>
						<label for="nom" class="col-lg-1 col-sm-5 col-form-label">Nom</label>
						<div class="col-lg-5 col-sm-8">
						<input type="text" class="form-control" name="nom"  id="nom" value="<c:out value="${user.nom}"/>" />
						<p class="font-italic text-danger"><small>${erreur['nom']}</small></p>
					</div>
				</div>
				
				<div class="form-group row">
						<label for="prenom" class="col-lg-1 col-sm-5 col-form-label">Prénom</label>
						<div class="col-lg-5 col-sm-8">
						<input type="text" class="form-control" name="prenom" id="prenom" value="<c:out value="${user.prenom}"/>" />
						<p class="font-italic text-danger"><small>${erreur['prenom']}</small></p>
					</div>

						<label for="email" class="col-lg-1 col-sm-5 col-form-label">Email</label>
						<div class="col-lg-5 col-sm-8">
						<input type="email" class="form-control" name="email" id="email" value="<c:out value="${user.email}"/>"/>
						<p class="font-italic text-danger"><small>${erreur['email']}</small></p>
					</div>
				</div>
				
				<div class="form-group row">	

						<label for="telephone" class="col-lg-1 col-sm-5 col-form-label">Téléphone</label>
						<div class="col-lg-5 col-sm-8">
						<input type="tel" class="form-control" name="telephone" id="telephone" value="<c:out value="${user.telephone}"/>"/>
						<p class="font-italic text-danger"><small>${erreur['telephone']}</small></p>
					</div>

						<label for="rue" class="col-lg-1 col-sm-5 col-form-label">Rue</label>
						<div class="col-lg-5 col-sm-8">
						<input type="text" class="form-control" name="rue" id="rue" value="<c:out value="${user.rue}"/>" />
						<p class="font-italic text-danger"><small>${erreur['rue']}</small></p>
					</div>
				</div>
				
				<div class="form-group row">
						<label for="cp" class="col-lg-1 col-sm-5 col-form-label">Code Postal</label>
						<div class="col-lg-5 col-sm-8">
						<input type="text" class="form-control" name="cp" id="cp" value="<c:out value="${user.code_postal}"/> "/>
						<p class="font-italic text-danger"><small>${erreur['cp']}</small></p>
					</div>

						<label for="ville" class="col-lg-1 col-sm-5 col-form-label">Ville</label>
						<div class="col-lg-5 col-sm-8">
						<input type="text" class="form-control" name="ville" id="ville" value="<c:out value="${user.ville}"/>" />
						<p class="font-italic text-danger"><small>${erreur['ville']}</small></p>
					</div>
				</div>
				</div>
							
		</form>
		</div>
	


<%@ include file="footer.jspf" %> <!-- code d'inclusion de la jspf footer /!\ attention au chemin du fichier, il peut etre different -->
</body>
</html>