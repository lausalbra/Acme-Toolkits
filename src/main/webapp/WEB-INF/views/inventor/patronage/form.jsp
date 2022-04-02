<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-select code="inventor.patronage.form.label.status" path="status">
		<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
		<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
		<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}"/>
	</acme:input-select>
    <acme:input-textbox code="inventor.patronage.form.label.code" path="code"/>
    <acme:input-textarea code="inventor.patronage.form.label.legal-stuff" path="legalStuff"/>
    <acme:input-money code="inventor.patronage.form.label.budget" path="budget"/>
    <acme:input-textbox code="inventor.patronage.form.label.patron.name" path="patron.userAccount.identity.fullName"/>
    <acme:input-email code="inventor.patronage.form.label.patron.email" path="patron.userAccount.identity.email"/>
    <acme:input-moment code="inventor.patronage.form.label.start-period" path="startPeriod"/>
    <acme:input-moment code="inventor.patronage.form.label.end-period" path="endPeriod"/>
    <acme:input-url code="inventor.patronage.form.label.link" path="link"/>
</acme:form>