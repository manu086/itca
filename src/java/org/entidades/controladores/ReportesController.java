/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades.controladores;

import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.entidades.Cargo;
import org.entidades.procesos.CargoFacade;

/**
 *
 * @author Manuel
 */
@Named(value = "reportesController")
@SessionScoped
public class ReportesController implements Serializable {

	@EJB
	 CargoFacade em;
	private List<Cargo> lista;
	JasperPrint jasperPrint;

	public List<Cargo> getLista() {
		lista = em.findAll();
		return lista;
	}

	public void setLista(List<Cargo> lista) {
		this.lista = lista;
	}
	
	
public void init() throws JRException {
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource (lista);
		String rerportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Cargo.jasper");
		jasperPrint = JasperFillManager.fillReport(rerportPath, new HashMap(), beanCollectionDataSource);
		
}

public void pdf() throws JRException, IOException{
	init();
	HttpServletResponse HttpServletResponse= (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	HttpServletResponse.addHeader("Content-disposition", "attachment:filename=report.pdf");
	ServletOutputStream servletOutputStream = HttpServletResponse.getOutputStream();
	JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
	FacesContext.getCurrentInstance().responseComplete();
}	

}	
	

	
	
	
	
	
	
	

