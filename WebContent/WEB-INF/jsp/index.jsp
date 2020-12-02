<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Eni-Enchère</title>
    </head>

    <body>
    <h1>Liste des enchères</h1>
    <p>
    	<label for="choix">Catégorie :</label>
    	<br>
    	<select id="choix">
    		<option value="Informatique">Informatique</option>
    		<option value="Ameublement">Ameublement</option>
    		<option value="Vêtement">Vêtement</option>
    		<option value="Sport&Loisirs">SportLoisirs</option>
    	</select>
    </p>
    <label for="Le nom de l'article contient">Le nom de l'article contient:</label>
<input type="search" id="site-search" name="q"
       aria-label="Search through site content">

<button>Search</button>
    </body>
</html>