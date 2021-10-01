<%@page import="Clases.Departamento"%>
<%@page import="Clases.Departamentobd"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Empleado"%>
<%@page import="Clases.Empleadobd"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Laboratorio #1 (25 %) Segundo Periodo</title>
</head>

<body>
    <main class="main">
        <header class="header">
            <nav class="navBar">
                <span class="material-icons-outlined iconoAsideBar">
                    corporate_fare
                </span>
                <ul class="ul">
                    <a href="Ejercicio1.jsp" class="link">
                        <li class="item">Ejercicio 1</li>
                    </a>
                    <a href="Ejercicio2.jsp" class="link">
                        <li class="item">Ejercicio 2</li>
                    </a>
                </ul>
            </nav>
        </header>
        <!-- Ejercicio 1 -->
        <div class="container1">
            <form action="Ejercicio01Serv" method="post" class="frmBusqueda">
                <label for="presentacion" class="frmBusqueda__title">star sd</label>

                <!-- barra de busqueda -->
                <div class="barraBuscar">
                    <!-- 1.1 Cree una consulta que muestre todos los empleados -->
                    <button class="btn btnRestablecer" name="btnRestablecer" type="submit"><span class="material-icons-outlined">
                        restart_alt
                        </span></button>

                    <!-- 1.2 Filtre la consulta por departamento. -->
                    <select name="departamento" class="select">
                        <%
                            Departamentobd dep = new Departamentobd();
                            ArrayList<Departamento> alDep = dep.mostarDepartamentos();
                            
                            if (alDep==null) {
                                    alDep = new ArrayList<>();
                                }
                            
                            for (Departamento e : alDep) {
                                out.print("<option value=\""+e.getDnombre()+"\" class=\"option\">"+
                                        e.getDnombre()+"</option>");
                            }
                        %>
                      </select>
                    <!-- <input type="text" placeholder="Departamento" class="input inputSearch" name="txtSearch"> -->

                    <!-- btn busqueda -->
                    <button class="btn btnBusqueda" name="btnBusqueda" type="submit"><span class="material-icons-outlined">
                        search
                            </span></button>
                </div>

                <!-- 1.3 Calcula el salario medio de todos los empleados. -->
                <!-- <button class="btn btn--simple">Salario Medio</button> -->

                <!-- 1.4 Muestre el salario mayor de los empleados. -->
                <!-- <button class="btn btn--simple">Salario Mayor</button> -->

                <!-- 1.5 Muestre el salario menor de los empleados. -->
                <!-- <button class="btn btn--simple">Salario Menor</button> -->

                <!-- 1.6 El formulario debe mostrar además una consulta de la cantidad de empleados por
                        departamento y salario promedio. -->
                <!-- <label for="nEmpleados" class="label">nEmpleados</label>
                <label for="nEmpleados" class="label">sPromedio</label> -->
            </form>
            <div class="containerMain">
                <div class="dataImportant">
                    <h3 class="dataImportant__title">Datos importantes</h3>
                    <p class="lb">Departamento: <%
                        if (session.getAttribute("departamento")!=null) {
                            out.print(session.getAttribute("departamento"));
                        }else{
                            out.print("-");
                        }
                        %></p>
                    <p class="lb">Salario medio todos: $<%  
                                Empleadobd emp = new Empleadobd();
                                out.print(emp.salarioMedioTodos());
                        %></p>
                    <p class="lb">Salario mayor todos: $<%out.print(emp.salarioMaximoTodos());%></p>
                    <p class="lb">Salario menor todos: $<%out.print(emp.salarioMenorTodos());%></p>
                    <p class="lb">Número de Empleados departamento: <%
                        if (session.getAttribute("departamento")!=null) {
                            out.print(emp.nEmpleadosDepartamento((String)session.getAttribute("departamento")));
                        }else{
                            out.print("-");
                        }
                    %></p>
                    <p class="lb">Salario promedio departamento: $<%
                        if (session.getAttribute("departamento")!=null) {
                            out.print(emp.salarioMedioEmpleadosDepartamento((String)session.getAttribute("departamento")));
                        }else{
                            out.print("-");
                        }
                        %></p>
                </div>
                <div class="container__table">
                    <h4 class="table__title">Lista de empleados</h4>
                    <table class="table">
                        <thead class="thead">
                            <tr class="tr">
                                <th class="th">Apellido</th>
                                <th class="th">Oficio</th>
                                <th class="th">Dir</th>
                                <th class="th">Fecha alt</th>
                                <th class="th">Salario</th>
                                <th class="th">Comisión</th>
                                <th class="th">Departamento</th>
                            </tr>
                        </thead>
                        <tbody class="tbody">
                            <%
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
                                if (alEmp.size()>0) {
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
                                            out.write("</tr>");
                                        }
                                    }else{
                                        out.write("<tr>");
                                        out.write("<td colspan=\"7\" style=\"text-align: center; padding: 1em 0;\">Sin datos</td>");
                                        out.write("</tr>");
                                }
                            %>
                        </tbody>
                        <tfoot class="tfoot">
                            <tr class="tr">
                                <td class="tfoot__brand" colspan="7">star sd</td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </main>
</body>

</html>