<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<a href="ServletListadoClientes">Gestionar clientes</a>&nbsp;
<a href="ServletListadoJuguetes">Gestionar juguetes</a>&nbsp;
<a href="ServletListadoCategorias">Gestionar categorias</a>&nbsp;
<a href="ServletLogOutAdmin">Salir</a>
