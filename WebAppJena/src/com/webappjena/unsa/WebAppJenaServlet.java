package com.webappjena.unsa;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.*;

import com.webappjena.modelo.*;
//import com.hp.hpl.jena.rdf.model.Model;

/** Servlet que validar� 
 * */
@SuppressWarnings("serial")
public class WebAppJenaServlet extends HttpServlet {
	taxonomiaAPI mitx = null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//Se obtienen las variables
				String categoria = req.getParameter("cat");
				//Se crea un objeto de conexion de usuario en base al correo
				//mitx = new taxonomiaAPI();
				//String res = mitx.getdato("ok");
				//String resb = mitx.Consulta1();
				resp.sendRedirect("jsp/resultado.jsp?m=ok");				
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//Se obtienen las variables
		//String categoria = req.getParameter("cat");
		//Se crea un objeto de conexion de usuario en base al correo
		//mitx = new taxonomiaAPI();
		//String res = mitx.getdato("ok");
		//String resb = mitx.Consulta1();
		String[] caracteristicas = req.getParameterValues("currency[]");
		//String prueba = caracteristicas[0];
		String prueba = "Eucariota";

		KeyTaxonomic ea= new KeyTaxonomic();
        ArrayList<String> contenido = new ArrayList<String>();
        contenido = ea.getPhylumforCaracteristica(prueba);
        
		String texto="";
		for (int i = 0; i< caracteristicas.length; i++) {
			texto = texto + caracteristicas[i]; 
			}
		String resultado="";
		for (int i = 0; i< contenido.size(); i++) {
			texto = resultado +"#"+ contenido.get(i); 
			}
		resp.sendRedirect("jsp/resultado.jsp?m="+caracteristicas[0]);
	}
}
