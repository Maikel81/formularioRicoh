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

package formulario.bussines.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import formulario.bussines.model.Usuario;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Usuario in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UsuarioCacheModel implements CacheModel<Usuario>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UsuarioCacheModel)) {
			return false;
		}

		UsuarioCacheModel usuarioCacheModel = (UsuarioCacheModel)object;

		if (usuarioId == usuarioCacheModel.usuarioId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, usuarioId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", usuarioId=");
		sb.append(usuarioId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", apellidos=");
		sb.append(apellidos);
		sb.append(", correo=");
		sb.append(correo);
		sb.append(", fecha_nac=");
		sb.append(fecha_nac);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Usuario toEntityModel() {
		UsuarioImpl usuarioImpl = new UsuarioImpl();

		if (uuid == null) {
			usuarioImpl.setUuid("");
		}
		else {
			usuarioImpl.setUuid(uuid);
		}

		usuarioImpl.setUsuarioId(usuarioId);

		if (createDate == Long.MIN_VALUE) {
			usuarioImpl.setCreateDate(null);
		}
		else {
			usuarioImpl.setCreateDate(new Date(createDate));
		}

		if (nombre == null) {
			usuarioImpl.setNombre("");
		}
		else {
			usuarioImpl.setNombre(nombre);
		}

		if (apellidos == null) {
			usuarioImpl.setApellidos("");
		}
		else {
			usuarioImpl.setApellidos(apellidos);
		}

		if (correo == null) {
			usuarioImpl.setCorreo("");
		}
		else {
			usuarioImpl.setCorreo(correo);
		}

		if (fecha_nac == Long.MIN_VALUE) {
			usuarioImpl.setFecha_nac(null);
		}
		else {
			usuarioImpl.setFecha_nac(new Date(fecha_nac));
		}

		usuarioImpl.resetOriginalValues();

		return usuarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		usuarioId = objectInput.readLong();
		createDate = objectInput.readLong();
		nombre = objectInput.readUTF();
		apellidos = objectInput.readUTF();
		correo = objectInput.readUTF();
		fecha_nac = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(usuarioId);
		objectOutput.writeLong(createDate);

		if (nombre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombre);
		}

		if (apellidos == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(apellidos);
		}

		if (correo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(correo);
		}

		objectOutput.writeLong(fecha_nac);
	}

	public String uuid;
	public long usuarioId;
	public long createDate;
	public String nombre;
	public String apellidos;
	public String correo;
	public long fecha_nac;

}