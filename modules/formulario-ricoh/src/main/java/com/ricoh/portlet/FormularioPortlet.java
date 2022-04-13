package com.ricoh.portlet;

import com.ricoh.constants.FormularioPortletKeys;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import formulario.bussines.model.Usuario;
import formulario.bussines.service.UsuarioLocalServiceUtil;

/**
 * @author Miguel Romero
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.miguel",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Formulario",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FormularioPortletKeys.FORMULARIO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FormularioPortlet extends MVCPortlet {
	
	@ProcessAction(name="addUser")
    public void addUser(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Usuario usuario = UsuarioLocalServiceUtil.createUsuario(CounterLocalServiceUtil.increment(Usuario.class.getName()));
		
		String nombre = ParamUtil.getString(actionRequest, "nombre");
		String apellidos = ParamUtil.getString(actionRequest, "apellidos");
		String correo = ParamUtil.getString(actionRequest, "correo");
		String fecha_nac = ParamUtil.getString(actionRequest, "fecha_nac");
		
		Date fecha = null;
		
		try {
			fecha = formatoFecha.parse(fecha_nac);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new IOException("No ha sido posible convertir la fecha",e);
		}
		try {
			CaptchaUtil.check(actionRequest);
		} catch (Exception e) {	
			throw new IOException("Comprueba si no eres un robot",e);
		}
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setCorreo(correo);
		usuario.setFecha_nac(fecha);
		
		UsuarioLocalServiceUtil.addUsuario(usuario);
		sendMail(usuario);
		SessionMessages.add(actionRequest, "success");
		
		
    }
	
	public void sendMail(Usuario usuario) {
		try {
            InternetAddress fromAdress = new InternetAddress("miguelromero8181@gmail.com");
            InternetAddress toAdress = new InternetAddress(usuario.getCorreo());

            MailMessage mailMessage = new MailMessage();
            mailMessage.setHTMLFormat(true);
            mailMessage.setTo(toAdress);
            mailMessage.setFrom(fromAdress);
            mailMessage.setSubject("Registro nuevo creado");
            mailMessage.setBody("El usuario se ha creado correctamente.<br>correo: " + usuario.getCorreo() + "<br>Nombre: " + usuario.getNombre() + " " + usuario.getApellidos());

            MailServiceUtil.sendEmail(mailMessage);
        } catch (AddressException e) {
            e.printStackTrace();
        }
	}
	
	@Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
        throws  IOException, PortletException {
        try {
            CaptchaUtil.serveImage(resourceRequest, resourceResponse);
        }catch(Exception e) {
            throw new IOException(e);
        }
    }

    protected boolean isCheckMethodOnProcessAction() {
        return _CHECK_METHOD_ON_PROCESS_ACTION;
    }
 
    private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
}