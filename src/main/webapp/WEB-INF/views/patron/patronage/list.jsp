<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="patron.patronage.list.label.code" path="code" width="70%"/>
    <acme:list-column code="patron.patronage.list.label.start-period" path="startPeriod" width="20%"/>
    <acme:list-column code="patron.patronage.list.label.end-period" path="endPeriod" width="20%"/>
</acme:list>