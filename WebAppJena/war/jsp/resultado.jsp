<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@page import="com.webappjena.modelo.taxonomiaAPI"%>
<%@page import="com.webappjena.modelo.formateo"%>
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
              <%
                taxonomiaAPI ea= new taxonomiaAPI();
                String f="Franklin";
                String result = ea.Consulta1();
                out.print("resultado: "+result);
        %>
                    </div>
                    
                </div>
            </div>
            <br>
           
            <br>
        
    </body>
    </html>
