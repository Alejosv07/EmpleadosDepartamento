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

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            <form action=\"Ejercicio01Serv\" method=\"post\" class=\"frmBusqueda\">\n");
      out.write("                <label for=\"presentacion\" class=\"frmBusqueda__title\">star sd</label>\n");
      out.write("\n");
      out.write("                <!-- barra de busqueda -->\n");
      out.write("                <div class=\"barraBuscar\">\n");
      out.write("                    <!-- 1.1 Cree una consulta que muestre todos los empleados -->\n");
      out.write("                    <button class=\"btn btnRestablecer\" name=\"btnRestablecer\" type=\"submit\"><span class=\"material-icons-outlined\">\n");
      out.write("                        restart_alt\n");
      out.write("                        </span></button>\n");
      out.write("\n");
      out.write("                    <!-- 1.2 Filtre la consulta por departamento. -->\n");
      out.write("                    <select name=\"departamento\" class=\"select\">\n");
      out.write("                        ");

                            Departamentobd dep = new Departamentobd();
                            ArrayList<Departamento> alDep = dep.mostarDepartamentos();
                            
                            if (alDep==null) {
                                    alDep = new ArrayList<>();
                                }
                            
                            for (Departamento e : alDep) {
                                out.print("<option value=\""+e.getDnombre()+"\" class=\"option\">"+
                                        e.getDnombre()+"</option>");
                            }
                        
      out.write("\n");
      out.write("                      </select>\n");
      out.write("                    <!-- <input type=\"text\" placeholder=\"Departamento\" class=\"input inputSearch\" name=\"txtSearch\"> -->\n");
      out.write("\n");
      out.write("                    <!-- btn busqueda -->\n");
      out.write("                    <button class=\"btn btnBusqueda\" name=\"btnBusqueda\" type=\"submit\"><span class=\"material-icons-outlined\">\n");
      out.write("                        search\n");
      out.write("                            </span></button>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- 1.3 Calcula el salario medio de todos los empleados. -->\n");
      out.write("                <!-- <button class=\"btn btn--simple\">Salario Medio</button> -->\n");
      out.write("\n");
      out.write("                <!-- 1.4 Muestre el salario mayor de los empleados. -->\n");
      out.write("                <!-- <button class=\"btn btn--simple\">Salario Mayor</button> -->\n");
      out.write("\n");
      out.write("                <!-- 1.5 Muestre el salario menor de los empleados. -->\n");
      out.write("                <!-- <button class=\"btn btn--simple\">Salario Menor</button> -->\n");
      out.write("\n");
      out.write("                <!-- 1.6 El formulario debe mostrar adem??s una consulta de la cantidad de empleados por\n");
      out.write("                        departamento y salario promedio. -->\n");
      out.write("                <!-- <label for=\"nEmpleados\" class=\"label\">nEmpleados</label>\n");
      out.write("                <label for=\"nEmpleados\" class=\"label\">sPromedio</label> -->\n");
      out.write("            </form>\n");
      out.write("            <div class=\"containerMain\">\n");
      out.write("                <div class=\"dataImportant\">\n");
      out.write("                    <h3 class=\"dataImportant__title\">Datos importantes</h3>\n");
      out.write("                    <p class=\"lb\">Departamento: ");

                        if (request.getParameter("departamento")!=null) {
                            out.print(request.getParameter("departamento"));
                        }else{
                            out.print("-");
                        }
                        
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">Salario medio todos: $");
  
                                 Empleadobd emp = new Empleadobd();
                                 out.print("holi");
                        
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">Salario mayor todos: $");
out.print(emp.salarioMaximoTodos());
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">Salario menor todos: $");
out.print(emp.salarioMenorTodos());
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">N??mero de Empleados departamento: ");

                        if (request.getParameter("departamento")!=null) {
                            out.print(emp.nEmpleadosDepartamento(request.getParameter("departamento")));
                        }else{
                            out.print("-");
                        }
                    
      out.write("</p>\n");
      out.write("                    <p class=\"lb\">Salario promedio departamento: $");

                        if (request.getParameter("departamento")!=null) {
                            out.print(emp.salarioMedioEmpleadosDepartamento(request.getParameter("departamento")));
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
      out.write("                                <th class=\"th\">Comisi??n</th>\n");
      out.write("                                <th class=\"th\">Departamento</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody class=\"tbody\">\n");
      out.write("                            ");

                                ArrayList<Empleado> alEmp = emp.mostarTodosEmpleados();
                                if (alEmp==null) {
                                        alEmp = new ArrayList<>();
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
