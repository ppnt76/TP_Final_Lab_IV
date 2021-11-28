<%@page import="negocioImpl.CuentasNegocioImpl"%>
<%@page import="negocio.CuentasNegocio"%>
<%@page import="entidad.Cuentas"%>
<%@page import="negocioImpl.TiposCuentaNegocioImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.TipoCuentas"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuentas</title>
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
 

<%@ page errorPage="errorBanco.jsp"%>
	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterBanco.jsp"></jsp:include>
			</div>
			<div class="col">
			
				<!--  -->
				<h4>Cuentas</h4> 
				<label for="cliente">Busqueda cliente</label>
				<form action="servletbancoModificacionCuenta" method="post">
					<div class="busquedaForm"> 
						<input type="text" class="form-control col-md-3 mb-3" placeholder="DNI" name="DNI" required> 
						<input type="submit" class="btn btn-outline-primary" value="Buscar" name="btnBuscar" style="margin-left: 10px;">
					</div>
				</form>
				<br> 
				<!--  -->	 
				
				<% 
					Cuentas CMod = null;
					int LabelDNI = 0;
					double LabelSaldo = 0;

					if (request.getAttribute("Cuentas") != null) {
						CMod = (Cuentas) request.getAttribute("Cuentas");
						LabelDNI = CMod.getDniCliente().getDni();
						LabelSaldo = CMod.getSaldo();
					}
 
				%> 
				
				<form action="servletbancoModificacionCuenta" method="post">
					<div class="col-md-5 mb-3"> 
						<input for="DNICliente" type="hidden" name="LabelDNI" value="<%=LabelDNI%>"></input> 
						<label for="DNICliente">DNI Cliente: <%=LabelDNI %></label>  
						<br>
						<label for="TipoCuenta">Cuenta activa</label> <select	name="TipoCuentaActiva">
							<%
							
							try{
							  	CuentasNegocio Nac = new CuentasNegocioImpl(); 
					 			ArrayList<Cuentas> ListaC =  Nac.ListarCuentas(CMod.getDniCliente().getDni()); 
								if(Nac != null)
								{
									for(Cuentas CuLista : ListaC){
								       %><option value="<%=CuLista.getNumeroCuenta() %>"><%=CuLista.getTipoCuenta().getDescripcion() %> - <%=CuLista.getNumeroCuenta() %> - $<%=LabelSaldo %> </option><%
								       }		
								}
							}
							catch(Exception e){
								System.out.println(e);
							}
							%>
						</select>
					</div>
					<br> 

					<div class="form-row">
						
						<div class="col-md-2 mb-3">
							<label for="TipoCuenta">Tipo Cuenta</label> <br> <select
								name="TipoCuenta">
								<%
									TiposCuentaNegocioImpl tp = new TiposCuentaNegocioImpl();
									ArrayList<TipoCuentas> Listatp = tp.readAll();
									if (tp != null) {
										for (TipoCuentas ltp : Listatp) {
								%><option value="<%=ltp.getId()%>"><%=ltp.getDescripcion()%>
								</option>
								<%
									}
									}
								%>
							</select>
						</div>
						<div class="col-md-3 mb-3">
							<label for="Saldo">Saldo</label> 
							<input type="text" class="form-control" name="Saldo" placeholder="Saldo" required>
						</div>
					</div>
					<br> 
					<input class="btn btn-outline-primary" type="submit" value="Aceptar" name="btnAceptar"> 
					<a class="btn btn-outline-primary" href="bancoCuentaModificacion.jsp" name="btnCancelar">Cancelar</a>
				</form> 
			</div>
		</div>
	</div>
</body>
</html>