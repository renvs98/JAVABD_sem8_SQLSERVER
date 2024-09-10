create database ejercicio8_JAVADB
go
use ejercicio8_JAVADB

create table Cita(
Codigo int not null identity (1,1) primary key,
Paciente varchar (50) not null,
FechAtencion date not null,
Doctor varchar(50),
Especialidad varchar(50)
)
go
select*from Cita
