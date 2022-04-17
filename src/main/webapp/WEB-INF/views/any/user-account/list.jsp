<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<jstl:forEach var="r" items="username">
	<acme:box code="any.user-account.list.role">Roles</acme:box>
		<acme:list>
	    	<acme:list-column code="any.user-account.list.label.username" path="username" width="50%"/>
	    	<acme:list-column code="any.user-account.list.label.roles" path="roles" width="50%"/>
		</acme:list>
		
</jstl:forEach>