<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	<acme:input-textbox code="inventor.quantity.form.label.name" path="name" readonly="${true}"/>
    <acme:input-textbox code="inventor.quantity.form.label.itemType" path="itemType" readonly="${true}"/>
    <acme:input-textbox code="inventor.quantity.form.label.code" path="code" readonly="${true}"/>
	<acme:input-textbox code="inventor.quantity.form.label.number" path="number"/>
    <acme:input-textarea code="inventor.quantity.form.label.technology" path="technology" readonly="${true}"/>
    <acme:input-textarea code="inventor.quantity.form.label.description" path="description" readonly="${true}"/>
	<acme:input-textarea code="inventor.quantity.form.label.retailPrice" path="retailPrice" readonly="${true}"/>
    <acme:input-url code="inventor.quantity.form.label.link" path="optionalLink" readonly="${true}"/>
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && draft == true}">
			<acme:submit code="inventor.toolkit.form.button.update" action="/inventor/toolkit/update"/>
			<acme:submit code="inventor.toolkit.form.button.delete" action="/inventor/toolkit/delete"/>
		</jstl:when>	
		
		<jstl:when test="${command == 'create'}">
			<acme:submit code="inventor.toolkit.form.button.create" action="/inventor/toolkit/create"/>
		</jstl:when>
	</jstl:choose>
	
</acme:form>
