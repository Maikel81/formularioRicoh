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

package formulario.bussines.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Usuario}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Usuario
 * @generated
 */
public class UsuarioWrapper
	extends BaseModelWrapper<Usuario>
	implements ModelWrapper<Usuario>, Usuario {

	public UsuarioWrapper(Usuario usuario) {
		super(usuario);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("usuarioId", getUsuarioId());
		attributes.put("createDate", getCreateDate());
		attributes.put("nombre", getNombre());
		attributes.put("apellidos", getApellidos());
		attributes.put("correo", getCorreo());
		attributes.put("fecha_nac", getFecha_nac());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long usuarioId = (Long)attributes.get("usuarioId");

		if (usuarioId != null) {
			setUsuarioId(usuarioId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String apellidos = (String)attributes.get("apellidos");

		if (apellidos != null) {
			setApellidos(apellidos);
		}

		String correo = (String)attributes.get("correo");

		if (correo != null) {
			setCorreo(correo);
		}

		Date fecha_nac = (Date)attributes.get("fecha_nac");

		if (fecha_nac != null) {
			setFecha_nac(fecha_nac);
		}
	}

	@Override
	public Usuario cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the apellidos of this usuario.
	 *
	 * @return the apellidos of this usuario
	 */
	@Override
	public String getApellidos() {
		return model.getApellidos();
	}

	/**
	 * Returns the correo of this usuario.
	 *
	 * @return the correo of this usuario
	 */
	@Override
	public String getCorreo() {
		return model.getCorreo();
	}

	/**
	 * Returns the create date of this usuario.
	 *
	 * @return the create date of this usuario
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the fecha_nac of this usuario.
	 *
	 * @return the fecha_nac of this usuario
	 */
	@Override
	public Date getFecha_nac() {
		return model.getFecha_nac();
	}

	/**
	 * Returns the nombre of this usuario.
	 *
	 * @return the nombre of this usuario
	 */
	@Override
	public String getNombre() {
		return model.getNombre();
	}

	/**
	 * Returns the primary key of this usuario.
	 *
	 * @return the primary key of this usuario
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the usuario ID of this usuario.
	 *
	 * @return the usuario ID of this usuario
	 */
	@Override
	public long getUsuarioId() {
		return model.getUsuarioId();
	}

	/**
	 * Returns the uuid of this usuario.
	 *
	 * @return the uuid of this usuario
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the apellidos of this usuario.
	 *
	 * @param apellidos the apellidos of this usuario
	 */
	@Override
	public void setApellidos(String apellidos) {
		model.setApellidos(apellidos);
	}

	/**
	 * Sets the correo of this usuario.
	 *
	 * @param correo the correo of this usuario
	 */
	@Override
	public void setCorreo(String correo) {
		model.setCorreo(correo);
	}

	/**
	 * Sets the create date of this usuario.
	 *
	 * @param createDate the create date of this usuario
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the fecha_nac of this usuario.
	 *
	 * @param fecha_nac the fecha_nac of this usuario
	 */
	@Override
	public void setFecha_nac(Date fecha_nac) {
		model.setFecha_nac(fecha_nac);
	}

	/**
	 * Sets the nombre of this usuario.
	 *
	 * @param nombre the nombre of this usuario
	 */
	@Override
	public void setNombre(String nombre) {
		model.setNombre(nombre);
	}

	/**
	 * Sets the primary key of this usuario.
	 *
	 * @param primaryKey the primary key of this usuario
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the usuario ID of this usuario.
	 *
	 * @param usuarioId the usuario ID of this usuario
	 */
	@Override
	public void setUsuarioId(long usuarioId) {
		model.setUsuarioId(usuarioId);
	}

	/**
	 * Sets the uuid of this usuario.
	 *
	 * @param uuid the uuid of this usuario
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected UsuarioWrapper wrap(Usuario usuario) {
		return new UsuarioWrapper(usuario);
	}

}