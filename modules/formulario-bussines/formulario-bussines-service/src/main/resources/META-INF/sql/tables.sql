create table USUARIO_Usuario (
	uuid_ VARCHAR(75) null,
	usuarioId LONG not null primary key,
	createDate DATE null,
	nombre VARCHAR(75) null,
	apellidos VARCHAR(75) null,
	correo VARCHAR(75) null,
	fecha_nac DATE null
);