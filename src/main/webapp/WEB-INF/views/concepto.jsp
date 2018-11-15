<%-- 
    Document   : conceptos
    Created on : Aug 12, 2018, 5:42:38 AM
    Author     : ISC. Cristian Enríquez
--%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<head>
    <title>Concepto Page</title>
    <style type="text/css">
        .tg {
            border-collapse:collapse;
            border-spacing:0;
            border-color:#ccc; 
            cellpadding:10;
            cellspacing:10;
        }
        .tg td{
            font-family:Arial, sans-serif;
            font-size:14px;
            padding:10px 5px;
            border-style:solid;
            border-width:1px;
            overflow:hidden;
            word-break:normal;
            border-color:#ccc;
            color:#333; 
            cellpadding:10;
            cellspacing:10;}
        .tg th{
            font-family:Arial, sans-serif;
            font-size:14px;
            font-weight:normal;
            padding:10px 5px;
            border-style:solid;
            border-width:1px;
            overflow:hidden;
            word-break:normal;
            border-color:#ccc;
            color:#333;
            background-color:#f0f0f0; 
            cellpadding:10;
            cellspacing:10;}
        .tg .tg-4eph{
            background-color:#f9f9f9;
        }
        a.button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 10px 15px 10px 8px;
        }
        a.btn{
            background-color: #f44336;
            border: none;
            color: white;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 10px 15px 10px 8px;
        }
        .table {
            border: 1px;
        }
        .th{ width:10%;
        }
        .value{
            margin: 10px 15px 10px 8px;
        }
    </style>
</head>

<h1>
    Add a Concepto
</h1>
<c:url var="addAction" value="/concepto/add" ></c:url>
<form:form action="${addAction}" commandName="concepto">
    <table>
        <c:if test="${!empty concepto.cve}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="cve">
                    <spring:message text="Clave"/>
                </form:label>
            </td>
            <td>
                <form:input path="cve" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="valor">
                    <spring:message text="Valor"/>
                </form:label>
            </td>
            <td>
                <form:input path="valor" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty concepto.cve}">
                    <input type="submit" value="<spring:message text="Edit Concepto"/>"/>
                </c:if>
                <c:if test="${empty concepto.cve}">
                    <input type="submit" value="<spring:message text="Add Concepto"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Conceptos List</h3>
<c:if test="${!empty listConceptos}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Concepto Clave</th>
            <th width="120">Valor</th>
            <th width="60">Action</th>
        </tr>
        <c:forEach items="${listConceptos}" var="concepto">
            <tr>
                <td>${concepto.id}</td>
                <td>${concepto.cve}</td>
                <td>${concepto.valor}</td>
                <td><a href="<c:url value='/edit/${concepto.id}' />" class="button">Edit</a>
                    <a href="<c:url value='/remove/${concepto.id}' />" class="btn">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>