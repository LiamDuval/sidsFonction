<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Intervention"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) { 
        %>
            <p style="color: red;"><%= errorMessage %></p>
        <% 
            }
            Intervention i = (Intervention) request.getAttribute("pIntervention");
            if (i != null) { 
        %>
                    <B>Lieu :</B>
                    <p><%= i.getLieu() %></p>
                    <B>Date :</B>
                    <p><%= i.getDate() %></p>
                    <B>Heure d'appel :</B>
                    <p><%= i.getHeure_appel() %></p>
                    <B>Heure d'arrivée :</B>
                    <p><%= i.getHeure_arrivee() %></p>
                    <B>Durée :</B>
                    <p><%= i.getDuree() %></p>
         <a href="lister"><button>Retour</button></a>
        <% 
            } else if (errorMessage == null) { 
        %>
            <p>Aucune intervention trouvée.</p>
        <% } %>
    </body>
</html>
