<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,dao.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista tirocinanti</title>
</head>
<body class="bg-primary">
	<%@ include file="/header.jsp" %>
		<div class="wrapper">
			<header class="masthead bg-primary text-white text-center" >
				<div class="container">
   				    <table>
						<tbody>
							<tr>
								<td>Nome</td>
								<td>Cognome</td>
								<td>Matricola</td>
								<td>FeedBack</td>
								<td>Compila Registro</td>																
							</tr>
							<%Collection<?> studenti = (Collection<?>) request.getAttribute("studenti");
						   
							if (studenti != null && studenti.size() != 0) {
								Iterator<?> it = studenti.iterator();
								
								while (it.hasNext()) {
							
									Studente bean = (Studente) it.next();
									
							%>	
							<tr>
								<td><%=bean.getNome() %></td>
								<td><%=bean.getCognome() %></td>
								<td><%=bean.getMatricola() %></td>
								<td> <a class="btn btn-info" href="FeedBackStudenteControl?tipo=sendValutazione&matricola=<%=bean.getMatricola()%>">Invia FeedBack</a> </td>
								<td> <a class="btn btn-info" href="#">Compila Registro</a> </td>
							</tr>
							
							<%
								}
							}
							
							%>
						</tbody>
					</table>		
				</div>
			</header>
		</div>
	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp" %>
</body>
</html>