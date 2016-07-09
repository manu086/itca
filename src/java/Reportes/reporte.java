/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

/**
 *
 * @author Manuel
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.reportes.entities.Vehiculo;
//import com.reportes.generadoresdatos.GeneraDatos;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

/**
 *
 * @author paul
 */
public class reporte extends HttpServlet {

//    private JRDataSource createReportDataSource() {
//        JRBeanArrayDataSource dataSource;
//
//        Collection coll = GeneraDatos.generarLista();
//        Vehiculo[] reportRows = (Vehiculo[]) coll.toArray();
//        dataSource = new JRBeanArrayDataSource(reportRows);
//        return dataSource;
//    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Reportes</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Reportes at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String parNameReport = request.getParameter("parNameReport");
        byte[] bytes;
        JRResultSetDataSource jrds;
        
        ServletOutputStream servletOutputStream = response.getOutputStream();
        //Forma 1 de cargar aarchivo
        //InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("/reportes/jrWebs.jasper");
        try {
            Context ctx= new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/rrhh");
            Connection cn = ds.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("Select * from cargo");
            jrds = new JRResultSetDataSource(rs);
            //Forma 2 de cargar archivos
            File reportFile = new File("C:\\Users\\Manuel\\Documents\\NetBeansProjects\\itca\\Reportes\\src\\reportes\\Cargos.jasper");
            InputStream is = new FileInputStream(reportFile);
            HashMap m =new HashMap();
            m.put("parameter1", "titulo x");
            bytes = JasperRunManager.runReportToPdf(is, m ,jrds);
            response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
                ouputStream.close();
        } catch (Exception e) {
            // display stack trace in the browser
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print(stringWriter.toString());
        }
        //processRequest(request, response);

//        ServletOutputStream servletOutputStream = response.getOutputStream();
//        //InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("/reports/BeanDSReport.jasper");
//        File reportFile = new File("/home/paul/Reportes/rptVehiculos.jasper");
//        InputStream reportStream = new FileInputStream(reportFile);
//        try {
//            JRDataSource dataSource = createReportDataSource();
//            JasperRunManager.runReportToPdfStream(reportStream,
//                    servletOutputStream, new HashMap(), dataSource);
//            response.setContentType("application/pdf");
//            servletOutputStream.flush();
//            servletOutputStream.close();
//        } catch (Exception e) {
//        }

    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
