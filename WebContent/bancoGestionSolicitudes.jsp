<%@page import="negocio.SolicitudNegocio"%>
<%@page import="negocioImpl.SolicitudNegocioImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Solicitud"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Solicitudes</title>
</head>
<body>
	<%@ page errorPage="errorBanco.jsp"%>

	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterBanco.jsp"></jsp:include>
			</div>

			<div class="col">
				<h4>Gestion Solicitudes</h4>
				<br> <br>
				<form class="formBusqueda" action="servletBancoGestionSolicitudes"
					method="get">

					<%
						int Nsoli = 0;
						if (request.getParameter("Nsoli") != null) {
							Nsoli = Integer.parseInt(request.getParameter("Nsoli").toString());
							HttpSession pepito = request.getSession();
							pepito.setAttribute("Nsoli", Nsoli);
							SolicitudNegocio dao = new SolicitudNegocioImpl();
							Solicitud solicitud = (Solicitud) dao.buscarSolicitud(Nsoli);
					%>
					<br> <br>
					<div>
						<h5>
							Numero de solicitud:
							<%=solicitud.getNumeroSolicitud()%>
						</h5>
						<br>
						<h5>
							Numero de cuenta:
							<%=solicitud.getNumeroCuenta()%>
						</h5>
						<br>
						<h5>
							Cantidad de cuotas:
							<%=solicitud.getCantCuotasSolicitado()%>
						</h5>
						<br>
						<h5>
							Monto solicitado:
							<%=solicitud.getMontoSolicitado()%>
						</h5>
						<br>
						<h5>
							Estado:
							<%=solicitud.getEstadoSolicitud()%>
						</h5>
						<br>
					</div>
					<%
						}
					%>

				</form>
				<br>
				<form class="formBusqueda" action="servletBancoGestionSolicitudes"
					method="get">

					<input class="btn btn-primary col-md-2" type="submit"
						value="Autorizar" name="btnAceptar"> <input
						class="btn btn-primary col-md-2" type="submit" value="Rechazar"
						name="btnRechazar">
				</form>
			</div>

		</div>

	</div>


</body>
</html>