<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="inventor.patronage.list.label.code" path="code" width="40%"/>
    <acme:list-column code="inventor.patronage.list.label.start-period" path="startPeriod" width="30%"/>
    <acme:list-column code="inventor.patronage.list.label.end-period" path="endPeriod" width="30%"/>
</acme:list>