package com.webappjena.modelo;

public class formateo {

	  public String eliminaOrigen(String t){
		    t=t.replace("http://www.owl-ontologies.com/Ontology1350356221.owl#", "");
		    t=t.replace("<uri>","");
		    t=t.replace("</uri>","");
		    t=t.replace("<literal datatype=\"http://www.w3.org/2001/XMLSchema#int\">", "");
		    t=t.replace("</literal>", "");
		    t=t.replace("<literal datatype=\"http://www.w3.org/2001/XMLSchema#string\">", "");
		    return t;
		    }

		    
	   public String tabuladorXML(String t){
		    t=t.replace("<?xml version=\"1.0\"?>","");
		    t=t.replace("<?xml-stylesheet","");
		    t=t.replace("http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#", "");
		    System.out.print("");
		    t=t.replace("-","");
		    t=t.replace("href=\"http://www.w3.org/TR/rdfsparqlXMLres/resulttohtml.xsl\"?>","");
		    t=t.replace(" xmlns=\"http://www.w3.org/2005/sparqlresults#\"", " border=\"1\"");
		    t=t.replace("sparql", "table");
		    t=t.replace("<head>", "<thead><tr>");
		    t=t.replace("</head>", "</tr></thead>");
		    t=t.replace("variable name=\"", "th>");
		    t=t.replace("\"/>", "</th>");
		    t=t.replace("results", "tbody");
		    t=t.replace("result", "tr");
		    t=t.replace("binding","td");
		    return t;
		    }

}
