<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@page import="com.webappjena.modelo.*"%>
<%@page import="java.util.*" %>
    <!DOCTYPE html>
    <html>
    <head>
        <link rel="shortcut icon" href="/favicon.png" /> -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HOMEPAGE - Taxon Project</title>
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
                        <h1>Clave Taxonómica</h1>
                    </div>
                    <div class="col-md-5 instructor-header-bar">
                    <a href="#">muy pronto se incluira una clave taxonomica</a>
            <%
                KeyTaxonomic ea= new KeyTaxonomic();
                ArrayList<String> caracteristicas = new ArrayList<String>();
                caracteristicas = ea.getLessSubclassofcaracteristics();
                ArrayList<String> contenido = new ArrayList<String>();
            %>
                        <form action='/webappjena' method='post' >
                           <fieldset>
                             <legend>Selecciona las caracteristicas de tu especimen</legend>
                             <% 
                             Integer num=0;
                             for(int j = 0; j < caracteristicas.size(); j++){
                                contenido = ea.getallofclase(caracteristicas.get(j));
                                out.println("<h3>En cuanto a: "+caracteristicas.get(j)+"</h3></br>");
                                for( int i = 0 ; i < contenido.size() ; i++ ){
                                    num++;
                                    out.print("<p><label>"+num+" : "+contenido.get( i )+"</label><input type = 'checkbox' name='currency[]' id='' value='"+contenido.get( i )+"'/></p>" );
                                }
                             }
                            %>                             
                           </fieldset>
                           <input type="submit" value="ENVIAR">
                        </form>
                                  
                    </div>
                    
                </div>
            </div>
            <br>
           
            <br>
        
    </body>
    </html>
