 
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<acme:form>

	<c:choose>
		<c:when test="${command == 'create'}">
			<acme:form-textbox code="worker.applications.form.label.reference" path="reference"/> 
			<acme:form-textarea code="worker.applications.form.label.statement" path="statement"/>
			<acme:form-textarea code="worker.applications.form.label.skills" path="skills"/>
			<acme:form-textarea code="worker.applications.form.label.qualification" path="qualifications"/>
	
	
			<acme:form-submit test="${command=='create' }" code="worker.applications.form.button.create"
				action="/worker/applications/create"/>
			<acme:form-return code="worker.applications.form.button.return"/> 
			
		</c:when>
		<c:otherwise>
			<acme:form-textbox readonly="true" code="worker.applications.form.label.reference" path="reference"/>
			<acme:form-moment  readonly="true" code="worker.applications.form.label.moment" path = "moment"/>
			<acme:form-textbox readonly="true" code="worker.applications.form.label.status" path="status" placeholder="PENDING"/> 
			<acme:form-textarea readonly="true" code="worker.applications.form.label.statement" path="statement"/>
			<acme:form-textarea readonly="true" code="worker.applications.form.label.skills" path="skills"/>
			<acme:form-textarea readonly="true" code="worker.applications.form.label.qualification" path="qualifications"/>
		
			<acme:form-return code="worker.applications.form.button.return"/> 
		</c:otherwise>
	</c:choose>
	
</acme:form>