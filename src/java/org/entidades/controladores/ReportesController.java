/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entidades.controladores;

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
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
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
	private CargoFacade cargoFacade;

	/**
	 * Creates a new instance of ReportesController
	 */
	public String verReporte() {
		try {

			HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance()
.getExternalContext().getResponse();
InputStream fileReport = FacesContext.getCurrentInstance()
.getExternalContext().getResourceAsStream("/Reportes/Cargos.jasper");
HashMap h = new HashMap(); //Parametros
h.put("parameter1", "valorParametro"); //solo necesario si hay parametros en el reporte
JRBeanArrayDataSource ds = getOrigenDatosReporte();
byte[] bytesReportes = JasperRunManager
.runReportToPdf(fileReport, h, ds);
ServletOutputStream out = res.getOutputStream();
out.write(bytesReportes, 0, bytesReportes.length);
out.flush();
out.close();
} catch (Exception ex) {
}
return "";
}

private JRBeanArrayDataSource getOrigenDatosReporte() {
	List lista = cargoFacade.listarTodos();
Cargo[] listacargo = (Cargo[]) lista.toArray();
JRBeanArrayDataSource ds = new JRBeanArrayDataSource(listacargo);
return ds;
} 
} 	

