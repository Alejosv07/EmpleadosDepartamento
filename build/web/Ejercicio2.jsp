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
        <!-- Ejercicio 2 -->
        <div class="container1">
            <div class="containerMain2">
                <div class="dataImportant2">
                    <h3 class="dataImportant__title">Departamento</h3>
                    <form action="#" class="frmAgregar">
                        <input type="text" required="true" placeholder="Nombre Departamento" class="inputAgregar" name="txtNDepartamento">
                        <input type="text" required="true" placeholder="Localización" class="inputAgregar" class="txtLoc">
                        <button type="submit" class="btn btnAgregar" name="btnAgregar">
                            <span class="material-icons-outlined">
                                add
                            </span>Agregar</button>
                    </form>
                </div>
                <div class="container__table2">
                    <h4 class="table__title">Lista Departamentos</h4>
                    <table class="table">
                        <thead class="thead">
                            <tr class="tr">
                                <th class="th">dnombre</th>
                                <th class="th">loc</th>
                            </tr>
                        </thead>
                        <tbody class="tbody">
                            <%
                                ArrayList<Departamento> alDep;
                                Departamentobd dep = new Departamentobd();
                                    alDep = dep.mostarDepartamentos();
                                    if (alDep==null) {
                                        alDep = new ArrayList<>();
                                    }
                                if (alDep.size()>0) {
                                     for (Departamento e : alDep) {
                                            out.write("<tr class=\"tr\">");
                                                out.write("<td class=\"td\">"+e.getDnombre()+"</td>");
                                                out.write("<td class=\"td\">"+e.getLoc()+"</td>");
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