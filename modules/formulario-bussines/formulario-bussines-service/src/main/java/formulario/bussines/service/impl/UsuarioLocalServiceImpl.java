/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package formulario.bussines.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import java.util.Date;

import formulario.bussines.model.Usuario;
import formulario.bussines.model.impl.UsuarioImpl;
import formulario.bussines.service.base.UsuarioLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=formulario.bussines.model.Usuario",
	service = AopService.class
)
public class UsuarioLocalServiceImpl extends UsuarioLocalServiceBaseImpl {
	
	public void addNewUsuario(String nombre,String apellidos,String correo,Date fecha_nac) {
		Usuario usuario = createUsuario(CounterLocalServiceUtil.increment(Usuario.class.getName()));
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setCorreo(correo);
		usuario.setFecha_nac(fecha_nac);
		usuario.setCreateDate(new Date());
		
		addUsuario(usuario);
	}
	
	
}