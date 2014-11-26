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
import java.util.*;

public class KeyTaxonomic {
	OntModel model = null;
	java.io.InputStream in = null;
	
	public KeyTaxonomic() {
		//String ns = "http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf";	 
		model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM_RULE_INF );
		in = FileManager.get().open( "ontology/taxonomia.rdf" );
		model.read(in, "");
	}
	
	public ArrayList<String> getallofclase(String clase){
		ArrayList<String> recursos = new ArrayList<String>();
		ResultSet results;		
		if (in == null) {
			throw new IllegalArgumentException("Archivo no encontrado");
		}						
		//model.read(in, "");
		String queryString = 
		"PREFIX : <http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#> "+
		"SELECT ?subject "+
		"WHERE  "+
		"{  "+
		"   ?subject a :"+clase+" ."+
		"}";
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		try {
			   results = qe.execSelect();
			   String temp="";
			   while (results.hasNext()){
					QuerySolution soln = results.nextSolution();
					Resource name = soln.getResource("subject");
					temp = name.toString();
					if (temp.charAt(0)=='h'){
						temp = temp.replace("http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#", "");
						recursos.add(temp);
					}					
				}
		} finally { qe.close() ; }
		Collections.sort(recursos);
		return recursos;
		}
	
	public String getsubclassof(String clase){
		String subclase="";
		if(clase.equals("Reino")){
			subclase = "Phylum";			
		}else if(clase.equals("Phylum")){
			subclase = "Clase";			
		}else if(clase.equals("Clase")){
			subclase = "Orden";			
		}else if(clase.equals("Orden")){
			subclase = "Familia";			
		}else if(clase.equals("Familia")){
			subclase = "Genero";			
		}else if(clase.equals("Genero")){
			subclase = "Especie";			
		}
		return subclase;
	}
	
	public String getsuperclassof(String clase){
		String superclase="";
		if(clase.equals("Especie")){
			superclase = "Genero";			
		}else if(clase.equals("Genero")){
			superclase = "Familia";			
		}else if(clase.equals("Familia")){
			superclase = "Orden";			
		}else if(clase.equals("Orden")){
			superclase = "Clase";			
		}else if(clase.equals("Clase")){
			superclase = "Phylum";			
		}else if(clase.equals("Phylum")){
			superclase = "Reino";			
		}
		return superclase;
	}
	
	public ArrayList<String> getallofsubclase(String clase, String nombrec){
		String subclase = getsubclassof(clase); 
		ArrayList<String> recursos = new ArrayList<String>();
		ResultSet results;		
		if (in == null) {
			throw new IllegalArgumentException("Archivo no encontrado");
		}						
		//model.read(in, "");
		String queryString = 
		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
		"PREFIX : <http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#> "+
		"SELECT * "+
		"WHERE  "+
		"{  "+		
		"   ?subject :contienea ?object ."+
		"   ?subject a :"+clase+" ."+
		"   ?object a :"+subclase+" ."+
		"   ?subject :NombreCientifico ?name ."+
		"   FILTER ( str(?name)= \""+nombrec+"\" ) ."+
		//"FILTER regex(?object, \""+clase+"\")"+
		"}";
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		try {
			   results = qe.execSelect();
			   String temp="";
			   while (results.hasNext()){
					QuerySolution soln = results.nextSolution();
					Resource name = soln.getResource("object");
					temp = name.toString();
					if (temp.charAt(0)=='h'){
						temp = temp.replace("http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#", "");
						recursos.add(temp);
					}					
				}
		} finally { qe.close() ; }
		Collections.sort(recursos);
		return recursos;
		}
	
	public boolean havesuperclass(String clase){
		if(clase.equals("Reino") )
			return false;
		return true;
	}
	
	public boolean havesubclass(String clase){
		if(clase.equals("Especie"))
			return false;
		return true;
	}
	
	public ArrayList<String> getNamesuperclass(String clase, String nombrec){
		if(havesuperclass(clase)){
			if(nombrec.equals("Especie"))
				nombrec.replace("_", " ");
			String superclase = getsuperclassof(clase);
			ArrayList<String> recursos = new ArrayList<String>();
			recursos.add(superclase); 
			ResultSet results;		
			if (in == null) {
				throw new IllegalArgumentException("Archivo no encontrado");
			}						
			//
			String queryString = 
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
			"PREFIX : <http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#> "+
			"SELECT * "+
			"WHERE  "+
			"{  "+		
			"   ?subject :contienea ?object ."+
			"   ?subject a :"+superclase+" ."+
			"   ?object :NombreCientifico ?name ."+
			"   FILTER ( str(?name)= '"+nombrec+"' ) ."+
			//"FILTER regex(?object, \""+clase+"\")"+
			"}";				
			Query query = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(query, model);
			try {
				   results = qe.execSelect();
				   String temp="";
				   //temp=results.toString();
				   //recursos.add(temp);
				   
				   if (results.hasNext()){
						QuerySolution soln = results.nextSolution();
						Resource name = soln.getResource("subject");
						temp = name.toString();
						temp = temp.replace("http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#", "");
						recursos.add(temp);											
					}else{
						recursos.add("error");
					}
						
				   //recursos.add("agrega");
			} finally { qe.close() ; }
			return recursos;
		}
		return null;
	}
	
	/*
	 *Devuelve las caracteristicas que tienen entidades 
	 */
	
	public ArrayList<String> getLessSubclassofcaracteristics(){
		ArrayList<String> recursos = new ArrayList<String>();
		recursos.add("Piel");
		recursos.add("Esqueleto");
		recursos.add("Alas");
		recursos.add("Aletas");
		recursos.add("Patas");
		recursos.add("Locomocion");
		recursos.add("Sistema_circulatorio");
		recursos.add("Alimentacion");
		recursos.add("Celulas");
		Collections.sort(recursos);
		return recursos;
		}
		
	public ArrayList<String> getPhylumforCaracteristica(String caracteristica){
		    ArrayList<String> recursos = new ArrayList<String>();
			ResultSet results;		
			if (in == null) {
				throw new IllegalArgumentException("Archivo no encontrado");
			}						
			//
			String queryString =
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
			"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"+						
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
			"PREFIX : <http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#> "+
			"SELECT * "+
			"WHERE  "+
			"{  "+		
			"   ?subject :tienecomocaracteristica ?object ."+
			"   ?object :Descripciondelacaracteristica ?name ."+
			"   FILTER ( str(?name)= '"+caracteristica+"' ) ."+
			//"FILTER regex(?object, \""+clase+"\")"+
			"}";				
			Query query = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(query, model);
			try {
				   results = qe.execSelect();
				   String temp="";
				   while (results.hasNext()){
						QuerySolution soln = results.nextSolution();
						Resource name = soln.getResource("subject");
						temp = name.toString();
						if (temp.charAt(0)=='h'){
							temp = temp.replace("http://www.semanticweb.org/franklin/ontologies/2014/10/taxonomia_rdf#", "");
							recursos.add(temp);
						}					
					}
			} finally { qe.close() ; }
			Collections.sort(recursos);
			return recursos;
	}
}





