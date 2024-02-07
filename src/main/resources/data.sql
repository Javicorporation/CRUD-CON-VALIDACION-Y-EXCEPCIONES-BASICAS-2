insert into medicos(nombre, especialidad, horario)values('maria perez','Quiropractico','13:00 - 22:00');
insert into medicos(nombre, especialidad, horario)values('luis paez','dentista','13:00 - 22:00');
insert into medicos(nombre, especialidad, horario)values('carlos duarte','cirugía general','13:00 - 22:00');
insert into medicos(nombre, especialidad, horario)values('felipe martir','Dermatología','13:00 - 22:00');
--------------------------
insert into paciente(nombre, genero, fecha_nacimiento)values('mario castañeda','masculino','1991-01-02');
insert into paciente(nombre, genero, fecha_nacimiento)values('carla ulloa','femenino','1991-01-02');
insert into paciente(nombre, genero, fecha_nacimiento)values('pablo lopez','masculino','1991-01-02');
insert into paciente(nombre, genero, fecha_nacimiento)values('melani morante','femenino','1991-01-02');
----------------------------
insert into citas (medico_id, paciente_id, fecha, hora, motivo)values(1,1,'2022-12-02','12:30:08','consulta general');
insert into citas (medico_id, paciente_id, fecha, hora, motivo)values(1,2,'2022-06-01','13:30:08','emergencias');
insert into citas (medico_id, paciente_id, fecha, hora, motivo)values(2,2,'2022-07-04','14:30:08','consulta general');
insert into citas (medico_id, paciente_id, fecha, hora, motivo)values(2,1,'2022-02-09','15:30:08','emergencias');
insert into citas (medico_id, paciente_id, fecha, hora, motivo)values(3,3,'2022-10-02','12:30:08','consulta general');
insert into citas (medico_id, paciente_id, fecha, hora, motivo)values(3,4,'2022-03-01','13:30:08','emergencias');
insert into citas (medico_id, paciente_id, fecha, hora, motivo)values(4,4,'2022-09-04','14:30:08','consulta general');
insert into citas (medico_id, paciente_id, fecha, hora, motivo)values(4,3,'2022-04-09','15:30:08','emergencias');
