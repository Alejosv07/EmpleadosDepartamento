package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.Departamento;
import Clases.Departamentobd;
import java.sql.Timestamp;
import java.util.ArrayList;
import Clases.Empleado;
import Clases.Empleadobd;

public final class Ejercicio2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons+Outlined\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <title>Laboratorio #1 (25 %) Segundo Periodo</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <main class=\"main\">\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <nav class=\"navBar\">\n");
      out.write("                <span class=\"material-icons-outlined iconoAsideBar\">\n");
      out.write("                    corporate_fare\n");
      out.write("                </span>\n");
      out.write("                <ul class=\"ul\">\n");
      out.write("                    <a href=\"#\" class=\"link\">\n");
      out.write("                        <li class=\"item\">Ejercicio 1</li>\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"#\" class=\"link\">\n");
      out.write("                        <li class=\"item\">Ejercicio 2</li>\n");
      out.write("                    </a>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <!-- Ejercicio 1 -->\n");
      out.write("        <div class=\"container1\">\n");
      out.write("            <div class=\"containerMain\">\n");
      out.write("                <div class=\"dataImportant\">\n");
      out.write("                    <h3 class=\"dataImportant__title\">Datos importantes</h3>\n");
      out.write("                    <p class=\"lb\">Departamento: ");

                        if (session.getAttribute("departamento")!=null) {
                            out.print(session.getAttribute("departamento"));
                        }else{
                            out.print("-");
                        }
                        
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">Salario medio todos: $");
  
                                Empleadobd emp = new Empleadobd();
                                out.print(emp.salarioMedioTodos());
                        
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">Salario mayor todos: $");
out.print(emp.salarioMaximoTodos());
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">Salario menor todos: $");
out.print(emp.salarioMenorTodos());
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">Número de Empleados departamento: ");

                        if (session.getAttribute("departamento")!=null) {
                            out.print(emp.nEmpleadosDepartamento((String)session.getAttribute("departamento")));
                        }else{
                            out.print("-");
                        }
                    
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">Salario promedio departamento: $");

                        if (session.getAttribute("departamento")!=null) {
                            out.print(emp.salarioMedioEmpleadosDepartamento((String)session.getAttribute("departamento")));
                        }else{
                            out.print("-");
                        }
                        
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"container__table\">\n");
      out.write("                    <h4 class=\"table__title\">Lista de empleados</h4>\n");
      out.write("                    <table class=\"table\">\n");
      out.write("                        <thead class=\"thead\">\n");
      out.write("                            <tr class=\"tr\">\n");
      out.write("                                <th class=\"th\">Apellido</th>\n");
      out.write("                                <th class=\"th\">Oficio</th>\n");
      out.write("                                <th class=\"th\">Dir</th>\n");
      out.write("                                <th class=\"th\">Fecha alt</th>\n");
      out.write("                                <th class=\"th\">Salario</th>\n");
      out.write("                                <th class=\"th\">Comisión</th>\n");
      out.write("                                <th class=\"th\">Departamento</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody class=\"tbody\">\n");
      out.write("                            ");

                                ArrayList<Empleado> alEmp;
                                if ((int)session.getAttribute("tablaEmpleados")==1) {
                                    alEmp = emp.mostarTodosEmpleados();
                                }else{
                                    if (session.getAttribute("departamento")!=null) {
                                        alEmp = emp.mostarPorDepartamento((String)session.getAttribute("departamento"));
                                    }else{
                                        out.print(session.getAttribute("departamento"));
                                        alEmp = new ArrayList<>();
                                    }
                                }
                                
                                 for (Empleado e : alEmp) {
                                        out.write("<tr class=\"tr\">");
                                            out.write("<td class=\"td\">"+e.getApellido()+"</td>");
                                            out.write("<td class=\"td\">"+e.getOficio()+"</td>");
                                            out.write("<td class=\"td\">"+e.getDir()+"</td>");
                                            Timestamp ts = new Timestamp(e.getFecha_alt().getTime());
                                            out.write("<td class=\"td\">"+ts+"</td>");
                                            out.write("<td class=\"td\">"+e.getSalario()+"</td>");
                                            out.write("<td class=\"td\">"+e.getComision()+"</td>");
                                            out.write("<td class=\"td\">"+e.getDepartamento().getDnombre()+"</td>");
                                        out.write("</tr class=\"tr\">");
                                    }
                            
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                        <tfoot class=\"tfoot\">\n");
      out.write("                            <tr class=\"tr\">\n");
      out.write("                                <td class=\"tfoot__brand\" colspan=\"7\" style=\"border-color: red;\">star sd</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tfoot>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
