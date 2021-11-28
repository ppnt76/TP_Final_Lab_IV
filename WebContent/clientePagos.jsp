<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import= "entidad.Prestamos" %>
<%@page import="dao.PrestamosDao" %>
<%@page import= "negocioImpl.PrestamosNegocioImpl" %>
<%@page import= "negocio.PrestamosNegocio" %>
<%@page import="java.util.ArrayList"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page errorPage="errorCliente.jsp" %> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagos</title>
</head>
<body>

<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterCliente.jsp"></jsp:include>	
		</div>		
		<div class="col">		
		
		 
<h4>Pagos pendientes</h4>
     

<div class=".container table-responsive-md">  
	<form class="formBusqueda"  style="display:flex;" action="servletclientesPagos" method= "get">
		<input type="number" class="form-control col-md-3" name="txtNprestamo" required>	     
		<input type="submit" class="btn btn-outline-primary" value="Buscar" name= "btnBuscarPrest" style="margin-left: 10px;">
	</form>
	<br>  
	<%ArrayList<Prestamos> ListarPrestamos = new ArrayList<Prestamos>();%>
	<table class="table table-sm table-hover table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">N° Solicitud</th>
	      <th scope="col">cuotas Pagas</th>
	      <th scope="col">Cuotas Total</th>
	      <th scope="col">Importe Cuota</th>
	     <th scope="col">Importe Total Pedido</th>
	     <th scope="col">Fecha Ultimo Pago</th>
	    </tr>
	  </thead>
	  	<%ArrayList<Prestamos> listaFiltrada= null;
	  	if(request.getAttribute("listafiltrada")!=null){
	  		listaFiltrada =(ArrayList<Prestamos>)request.getAttribute("listafiltrada");%>
	  
	  	<tr>
	  	
	  	<%try{
	  		 for(Prestamos pre : listaFiltrada){%>
	  		<td><%=pre.getId() %></td>
	  		<td><%=pre.getCuotasPagas() %></td>
	  		<td><%=pre.getCuotasTotal() %></td>	 
	  		<td><%=pre.getImporteCuota() %></td>	
	  		<td><%=pre.getImportePedidoTotal()%></td>
	  		<td><%=pre.getFechaUltimoPago() %></td>	
	  	<%}%>
	  
	  	<%}catch(Exception e ){%>
	  	<% %>
	  	<%}finally{}%>
	  	
	  	
		
	  	
	  	<%}else{%>
	  	<%PrestamosNegocio dao = new PrestamosNegocioImpl();
	  	 HttpSession sessionUsuario = request.getSession();
	  	 int dniUsuario =Integer.parseInt(sessionUsuario.getAttribute("SesionDNI").toString());
	  	
	  	 ListarPrestamos = dao.readAll(dniUsuario); %>
	    <tr>
	    <%for(Prestamos pres : ListarPrestamos){ %>
	      	<td><%=pres.getId() %></td>
	  		<td><%=pres.getCuotasPagas() %></td>
	  		<td><%=pres.getCuotasTotal() %></td>	 
	  		<td><%=pres.getImporteCuota() %></td>	
	  		<td><%=pres.getImportePedidoTotal()%></td>
	  		<td><%=pres.getFechaUltimoPago() %></td>	
	      
	    </tr>
	      <%}%>
	    <%}%>
	     
	
	</table>
</div> 
 	
		<form class="formBusqueda"  style="display:flex;" action="servletclientesPagos" method= "get" >
	  	<p>Cantidad de cuotas <input type="number" class="form-control col-md-3" value="Cantidad de cuotas" name="txtCantCuotas" required >	</p>     
		<input type="submit" class="btn btn-outline-primary" value="Pagar" name= "btnPagar" style="margin-left: 10px;" >
		</form>
		
		</div>		
	</div>	
</div>

     
</body>
</html>