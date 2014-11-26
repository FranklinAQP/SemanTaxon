<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@page import="com.webappjena.modelo.*"%>
<%@page import="java.util.*" %>
    <!DOCTYPE html>
    <html>
    <head>
        <link rel="shortcut icon" href="/favicon.png" /> -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <% 
            String clase ="";
            if(request.getParameter("class") != null) {  
                clase = request.getParameter("class");
            }
            %>
        <title>SEMANTAXON - CATEGORIA:<%= clase %></title>
        <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="/bootstrap/css/bootstrap-theme.min.css" type="text/css"/>
        <link rel="stylesheet" href="/stylesheets/teammatesCommon.css" type="text/css"/>
        
       
        <script type="text/javascript"  src="/bootstrap/js/bootstrap.min.js"></script>
        
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    
    <body>
        <%@ include file="header.jsp" %>
        <div id="frameBodyWrapper" class="container theme-showcase">
            <div id="topOfPage"></div>
            <div class="inner-container">
                <div class="row">
                    <div class="col-md-5">
                        <h1>Categoría: <%= clase %></h1>
                    </div>
                    <div class="col-md-5 instructor-header-bar">
              <%
                KeyTaxonomic ea= new KeyTaxonomic();
                ArrayList<String> contenido = new ArrayList<String>();
                contenido = ea.getallofclase(clase);
                
                
        %>
                
                <table class="table table-responsive table-striped table-bordered margin-0">
            <thead class="background-color-medium-gray text-color-gray font-weight-normal">
            <tr id="resultsHeader-0"><th>Nro.</th><th><%= clase %></th></tr></thead><tbody>
            <% 
            for( int i = 0 ; i < contenido.size() ; i++ ){
                out.print("<tr class='instructor'><td>"+i+"</td><td><a href='/jsp/ubicacion_taxonomica.jsp?class="+clase+"&name="+contenido.get( i )+"'>"+contenido.get( i )+"</a></td></tr>" );
            }
            %>
            </tbody></table>
                
                    </div>
                    
                </div>
            </div>
            <br>
           
            <br>
        
    </body>
    </html>
