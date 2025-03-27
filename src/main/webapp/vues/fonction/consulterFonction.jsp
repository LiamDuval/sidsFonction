<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Fonction"%>
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
            Fonction f = (Fonction) request.getAttribute("pFonction");
            if (f != null) { 
        %>
                    <B>Lieu :</B>
                    <p><%= f.getLibelle() %></p>
         <a href="lister"><button>Retour</button></a>
        <% 
            } else if (errorMessage == null) { 
        %>
            <p>Aucune intervention trouvée.</p>
        <% } %>
    </body>
</html>
