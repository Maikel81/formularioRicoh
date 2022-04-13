<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>

<portlet:actionURL name="addUser" var="addUser" />
<liferay-ui:success key="success" message="User saved succesfully!" />
<liferay-ui:error key="error" message="Sorry, you can´t use the form" />
<portlet:resourceURL id="captcha" var="captchaResourceURL"/>
<liferay-ui:error
    exception="<%= CaptchaTextException.class %>"
    message="captcha-verification-failed" />
<div class="container">
<aui:form action="<%= addUser %>" id="frmUser" name="<portlet:namespace />fm">

	<aui:fieldset>
		<c:set var="nombre"><liferay-ui:message key="formulario.nombre"/></c:set>
		<c:set var="apellidos"><liferay-ui:message key="formulario.apellidos"/></c:set>
		<c:set var="correo"><liferay-ui:message key="formulario.correo"/></c:set>
		<c:set var="fecha"><liferay-ui:message key="formulario.fecha"/></c:set>
		<c:set var="aceptar"><liferay-ui:message key="formulario.aceptar"/></c:set>
		<c:set var="cancelar"><liferay-ui:message key="formulario.cancelar"/></c:set>
		
		<aui:input name="nombre" type="text" label="${nombre}" required="true">
			<aui:validator name="maxLength">50</aui:validator>
		</aui:input>
		<aui:input name="apellidos" type="text" label="${apellidos}" required="true">
			<aui:validator name="maxLength">50</aui:validator>
		</aui:input>
		<aui:input name="correo" type="email" label="${correo}" required="true">
			<aui:validator name="maxLength">50</aui:validator>
		</aui:input>
		<aui:input name="fecha_nac" type="date" label="${fecha}" required="true">
		</aui:input>
		<liferay-captcha:captcha url="<%= captchaResourceURL %>"/>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" value="${aceptar}" />
        <aui:button type="reset" value="${cancelar}" />
	</aui:button-row>
</aui:form>
</div>