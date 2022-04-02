<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="anonymous.item.form.label.name" path="name"/>
	<acme:input-textbox code="anonymous.item.form.label.code" path="code"/>
	<acme:input-textbox code="anonymous.item.form.label.technology" path="technology"/>
	<acme:input-textarea code="anonymous.item.form.label.description" path="description"/>
	<acme:input-money code="anonymous.item.form.label.retailPrice" path="retailPrice"/>
	<acme:input-url code="anonymous.item.form.label.optionalLink" path="optionalLink"/>
	
</acme:form>

