package com.webappjena.modelo;

import java.util.ArrayList;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;
import com.webappjena.modelo.*;

import java.util.*;

public class taxonomiaAPI {
	
	public String Consulta1(){
		ResultSet results;
		// TODO Auto-generated method stub
		OntModel model = null;
		String ns = "http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf";	 
		// crear un modelo utilizando como razonador OWL_MEM_RULE_INF
		
		model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM_RULE_INF );
		
		// abrir el archivo con la ontología
		
		java.io.InputStream in = null;//FileManager.get().open( "http://localhost:8888/ontology/taxonomia.rdf" );
		//in = FileManager.get().open( "C:/Users/FRANKLIN/workspace/WebAppJena/war/ontology/taxonomia.rdf" );
		in = FileManager.get().open( "ontology/taxonomia.rdf" );
		//in = FileManager.get().open( "http://1-dot-webappjena-unsa.appspot.com/ontology/taxonomia.rdf";
		if (in == null) {
			throw new IllegalArgumentException("Archivo no encontrado");
		}		 
		
		
		// leer el archivo RDF/XML				
		model.read(in, "");
		//La consulta
		String queryString = 
		"PREFIX po: <http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#> "+
		"SELECT ?especie "+
		"WHERE  "+
		"{  "+
		"   ?especie a po:Especie ."+
		"}";
		Query query = QueryFactory.create(queryString);		 
		// Ejecutar la consulta y obtener los resultados
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		String s="";
		
		try {
			   results = qe.execSelect();
				//f= new formateo();
				//s = f.tabuladorXML(f.eliminaOrigen(t) );
			   String temp="";
			   while (results.hasNext()){
					QuerySolution soln = results.nextSolution();
					Resource name = soln.getResource("especie");
					temp = name.toString();
					if (temp.charAt(0)=='h'){
						temp = temp.replace("http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#", "");
						s = s + temp +" \n ";
					}					
					//System.out.println(name.toString());
				}
		} finally { qe.close() ; }
		return s;
		}
		
	public String getdato(String d){
		return d;
	}
	
}




