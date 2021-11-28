<%@page import="negocioImpl.CuentasNegocioImpl"%>
<%@page import="entidad.Cuentas"%>
<%@page import="entidad.TipoCuentas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="negocioImpl.TiposCuentaNegocioImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page errorPage="errorCliente.jsp" %> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos</title> 
</head>
<body>
	<%
		HttpSession sessionUsuario = request.getSession();
		int dni = 0;

		if (sessionUsuario.getAttribute("SesionDNI") != null) {
			dni = Integer.parseInt(sessionUsuario.getAttribute("SesionDNI").toString());

		} else {
			response.sendRedirect("Login.jsp");
		}
	%>

	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterCliente.jsp"></jsp:include>
			</div>
			<div class="col">
				<h4>Prestamos</h4>

				<div class=".container-sm" style="width: 90%">
					<form action="servletClientePrestamos" method="get">
						<div class="form-row">
							<div class="col-md-3 mb-3">
								<label for="Importe">Importe</label> 
								<input type="text" class="form-control" id="Importe" name="Importe" placeholder="Importe" required>
							</div>
							<div class="col-md-3 mb-3">
								<label for="CantidadCuotas">Cantidad de cuotas</label> 
								<input type="text" class="form-control" id="Cantidad" name="CantidadCuotas" placeholder="Cantidad de cuotas" required>
							</div>
						</div> 
						
						<div class="col-md-3 mb-3">
							<label for="TipoCuenta">Cuenta a depositar</label> <select
								name="TipoCuenta">
								<%
									CuentasNegocioImpl cNimp = new CuentasNegocioImpl();

									ArrayList<Cuentas> ListC = cNimp.ListarCuentas(dni);

									if (cNimp != null) {
										for (Cuentas tpcLista : ListC) {
								%><option value="<%=tpcLista.getNumeroCuenta()%>"><%=tpcLista.getTipoCuenta().getDescripcion()%>
									-
									<%=tpcLista.getNumeroCuenta()%>
								</option>
								<%
									}
									}
								%>
							</select>
						</div>
						<br> 
						<input class="btn btn-outline-primary" type="submit" value="Aceptar" name="btnAceptar"> 
						<a	class="btn btn-outline-primary" href="clientePrestamos.jsp"	name="btnCancelar">Cancelar</a>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>