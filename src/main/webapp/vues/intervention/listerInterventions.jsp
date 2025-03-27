<%-- 
    Document   : lister_pompiers.jsp
    Created on : 15 mars 2024, 16:50:49
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Intervention"%>
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
        <h1>Liste des interventions</h1>
            <%
                ArrayList<Intervention> lesInterventions = (ArrayList)request.getAttribute("pLesInterventions");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th></th>
                    <th>Lieu</th>
                    <th></th>
                    <th>Date</th>
                    <th></th>
                    <th>Heure appel</th>
                    <th></th>
                    <th>Heure arrivee</th>
                    <th></th>
                    <th>Duree</th>
              
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Intervention i : lesInterventions)
                        {              
                            out.println("<tr><td>");
                            out.println(i.getId());
                            out.println("</a></td>");

                            out.println("<td><td>");
                            out.println(i.getLieu());
                            out.println("</td>");;
                            
                            out.println("<td><td>");
                            out.println(i.getDate());
                            out.println("</td>");;
                            
                            out.println("<td><td>");
                            out.println(i.getHeure_appel());
                            out.println("</td>");;
                            
                            out.println("<td><td>");
                            out.println(i.getHeure_arrivee());
                            out.println("</td>");;
                            
                            out.println("<td><td>");
                            out.println(i.getDuree());
                            out.println("</td>");;
                            
                            out.println("<td><a href ='../ServletIntervention/consulter?idIntervention="+ i.getId()+ "'>");
                            out.println("Consulter");
                            out.println("</td>");;
                            
                            
                               
                        }
   
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>
