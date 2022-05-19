<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>

    <acme:list-column code="inventor.quantity.list.label.name" path="name" width="25%"/>
    <acme:list-column code="inventor.quantity.list.label.code" path="code" width="10%"/>
    <acme:list-column code="inventor.quantity.list.label.technology" path="technology" width="35%"/>
    <acme:list-column code="inventor.quantity.list.label.itemType" path="itemType" width="20%"/>
    <acme:list-column code="inventor.quantity.list.label.number" path="number" width="10%"/>
    
</acme:list>

<acme:button code="inventor.quantity.list.button.create" action="/inventor/quantity/create"/>