<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-select code="patron.patronage.form.label.status" path="status">
		<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
		<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
		<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}"/>
	</acme:input-select>
    <acme:input-textbox code="patron.patronage.form.label.code" path="code"/>
    <acme:input-textarea code="patron.patronage.form.label.legal-stuff" path="legalStuff"/>
    <acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
    <acme:input-textbox code="patron.patronage.form.label.inventor.name" path="fullName"/>
    <acme:input-email code="patron.patronage.form.label.inventor.email" path="email"/>
    <acme:input-moment code="patron.patronage.form.label.start-period" path="startPeriod"/>
    <acme:input-moment code="patron.patronage.form.label.end-period" path="endPeriod"/>
    <acme:input-url code="patron.patronage.form.label.link" path="link"/>
</acme:form>