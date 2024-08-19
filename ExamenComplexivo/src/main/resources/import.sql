INSERT INTO administrador (usuario, password) VALUES ('admin1', 'password1');
INSERT INTO administrador (usuario, password) VALUES ('admin2', 'password2');
INSERT INTO administrador (usuario, password) VALUES ('admin3', 'password3');
INSERT INTO administrador (usuario, password) VALUES ('admin4', 'password4');

INSERT INTO categoria (nombre) VALUES ('Tipo Habitacion 1');
INSERT INTO categoria (nombre) VALUES ('Tipo Habitacion 2');
INSERT INTO categoria (nombre) VALUES ('Tipo Habitacion 3');
INSERT INTO categoria (nombre) VALUES ('Tipo Habitacion 4');

INSERT INTO habitacion (numero, descripcion, precio, estado, id_administrador, id_categoria) VALUES (101, 'Habitación sencilla', 50.00, 'Disponible', 1, 1);
INSERT INTO habitacion (numero, descripcion, precio, estado, id_administrador, id_categoria) VALUES (102, 'Habitación doble', 80.00, 'Ocupado', 2, 2);
INSERT INTO habitacion (numero, descripcion, precio, estado, id_administrador, id_categoria) VALUES (103, 'Habitación suite', 120.00, 'Disponible', 3, 3);
INSERT INTO habitacion (numero, descripcion, precio, estado, id_administrador, id_categoria) VALUES (104, 'Habitación familiar', 150.00, 'Mantenimiento', 4, 4);
