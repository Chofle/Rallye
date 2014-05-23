create database rallye;
use Rallye;

create table Categoria(
	codCategoria int primary key,
	nombre varchar(25)
);

create table Inscripcion (
	id int unsigned AUTO_INCREMENT primary key,
	escuderia varchar(50),
	piloto varchar(25),
	vehiculo varchar(50),
	categoria int,
	tiempo time,
	fecha date,
	autorizado boolean,
	foreign key (categoria) references Categoria(codCategoria) 
	on delete no action on update no action 

);

