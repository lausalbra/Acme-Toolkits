<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
    <acme:input-textbox code="patron.patronage-dashboard.form.label.proposed" path="totalNumberOfProposedPatronages"/>
    <acme:input-textbox code="patron.patronage-dashboard.form.label.accepted" path="totalNumberOfAcceptedPatronages"/>
    <acme:input-textbox code="patron.patronage-dashboard.form.label.denied" path="totalNumberOfDeniedPatronages"/>
</acme:form>