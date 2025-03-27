<%-- 
    Document   : lister_pompiers.jsp
    Created on : 15 mars 2024, 16:50:49
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Fonction"%>
<%@page import="model.Caserne"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APPLICATION DE GESTION SDIS CALVADOS</title>
    </head>
    <body>
        <h1>Liste des Fonctions</h1>
            <%
                ArrayList<Fonction> lesFonctions = (ArrayList)request.getAttribute("pLesFonctions");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>id</th>

                    <th>Libelle</th>
              
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Fonction f : lesFonctions)
                        {              
                            out.println("<tr><td>");
                            out.println(f.getId());
                            out.println("</a></td>");

                            out.println("<td><a href ='../ServletFonction/consulter?idFonction="+ f.getId()+ "'>");
                            out.println(f.getLibelle());
                            out.println("</a></td>");;
                        }
   
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>
