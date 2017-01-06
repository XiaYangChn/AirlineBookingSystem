
/* create database */
drop database if exists AIRLINE_1;
drop database if exists AIRLINE_2;
drop database if exists AIRLINE_3;
drop database if exists ABS;

create database AIRLINE_1;
create database AIRLINE_2;
create database AIRLINE_3;
create database ABS;

/* create table of database Airline*/

use AIRLINE_1;

create table airline(
	code		varchar(3) 	not null	primary key,
    name		varchar(20)	not null,
    discount 	float(2,2)	not null
);

create table airport(
	code 		varchar(4)	not null	primary key,
    name		varchar(20)	not null,
    city		varchar(20)	not null,
    country		varchar(20)	not null,
    connTime	int(3)		not null	/* minute */
);

create table airplane(
    name		varchar(20)	not	null	primary key,
    type		varchar(10)	not null
);

create table seat(
	id			int(3)		not	null	primary key auto_increment,	
    relativeID	int(3)		not null,	/* 飞机上作为的相对编号 */
    row			int(3)		not null,
    num			int(3)		not null,
    type		varchar(12)	not	null,	/* windowSeat middleSeat aisleSeat*/
    flightID	int(10)		not null,	/* Table:airplane Item:id */
    passport	varchar(20)				/* passenger passport */
);

create table flight(
	id				int(10)		not	null	primary key,
    airlineCode 	varchar(3) 	not null,
    number			int(6)		not	null,
    depatureDate	Date		not null,
    depatureTime 	time		not	null,
    arrivalDate		Date		not null,
    arrivalTime		time		not	null,
    fare			float(6,2)	not	null,
    depatureAirport	varchar(4)	not	null,	/* Table:airport Item:code */
    arrivalAirport	varchar(4)	not	null,	/* Table:airport Item:code */
 	airplaneName	varchar(20)	not	null,	/* Table:airplane Item:name */
    airplaneType	varchar(10) not	null	/* Table:airplane Item:type */
);


use AIRLINE_2;

create table airline(
	code		varchar(3) 	not null	primary key,
    name		varchar(20)	not null,
    discount 	float(2,2)	not null
);

create table airport(
	code 		varchar(4)	not null	primary key,
    name		varchar(20)	not null,
    city		varchar(20)	not null,
    country		varchar(20)	not null,
    connTime	int(3)		not null	/* minute */
);

create table airplane(
    name		varchar(20)	not	null	primary key,
    type		varchar(10)	not null
);

create table seat(
	id			int(3)		not	null	primary key auto_increment,	
    relativeID	int(3)		not null,	/* 飞机上作为的相对编号 */
    row			int(3)		not null,
    num			int(3)		not null,
    type		varchar(12)	not	null,	/* windowSeat middleSeat aisleSeat*/
    flightID	int(10)		not null,	/* Table:airplane Item:id */
    passport	varchar(20)				/* passenger passport */
);

create table flight(
	id				int(10)		not	null	primary key,
    airlineCode 	varchar(3) 	not null,
    number			int(6)		not	null,
    depatureDate	Date		not null,
    depatureTime 	time		not	null,
    arrivalDate		Date		not null,
    arrivalTime		time		not	null,
    fare			float(6,2)	not	null,
    depatureAirport	varchar(4)	not	null,	/* Table:airport Item:code */
    arrivalAirport	varchar(4)	not	null,	/* Table:airport Item:code */
 	airplaneName	varchar(20)	not	null,	/* Table:airplane Item:name */
    airplaneType	varchar(10) not	null	/* Table:airplane Item:type */
);


use AIRLINE_3;

create table airline(
	code		varchar(3) 	not null	primary key,
    name		varchar(20)	not null,
    discount 	float(2,2)	not null
);

create table airport(
	code 		varchar(4)	not null	primary key,
    name		varchar(20)	not null,
    city		varchar(20)	not null,
    country		varchar(20)	not null,
    connTime	int(3)		not null	/* minute */
);

create table airplane(
    name		varchar(20)	not	null	primary key,
    type		varchar(10)	not null
);

create table seat(
	id			int(3)		not	null	primary key auto_increment,	
    relativeID	int(3)		not null,	/* 飞机上作为的相对编号 */
    row			int(3)		not null,
    num			int(3)		not null,
    type		varchar(12)	not	null,	/* windowSeat middleSeat aisleSeat*/
    flightID	int(10)		not null,	/* Table:airplane Item:id */
    passport	varchar(20)				/* passenger passport */
);

create table flight(
	id				int(10)		not	null	primary key,
    airlineCode 	varchar(3) 	not null,
    number			int(6)		not	null,
    depatureDate	Date		not null,
    depatureTime 	time		not	null,
    arrivalDate		Date		not null,
    arrivalTime		time		not	null,
    fare			float(6,2)	not	null,
    depatureAirport	varchar(4)	not	null,	/* Table:airport Item:code */
    arrivalAirport	varchar(4)	not	null,	/* Table:airport Item:code */
 	airplaneName	varchar(20)	not	null,	/* Table:airplane Item:name */
    airplaneType	varchar(10) not	null	/* Table:airplane Item:type */
);



/* create table of database ABS*/

use ABS;

create table airline(
	code		varchar(3)	not	null	primary key,
    name		varchar(20)	not	null,
    discount	float(2,2)	not	null
);

create table flightInfo(
	id				int(10)		not null	primary key  auto_increment,
	airlineCode		varchar(3)	not null,	/* Table:airline Item:code */
    flightID		int(10)		not	null,	/* Database:Airline Table:flight Item: */
    
    number			int(6)		not null,	/* Database:Airline Table:flight Item:number */
    depatureDate	Date		not null,	/* Database:Airline Table:flight Item:depatureDate */
    depatureTime 	time		not	null,	/* Database:Airline Table:flight Item:depatureTime */
    arrivalDate		Date		not null,	/* Database:Airline Table:flight Item:arrivalDate */
    arrivalTime		time		not	null,	/* Database:Airline Table:flight Item:arrivalTime */
    fare			float(6,2)	not	null,	/* Database:Airline Table:flight Item:fare */
    depatureAirport	varchar(4)	not	null,	/* Database:Airline Table:flight Item:depatureAirport */
    arrivalAirport	varchar(4)	not	null,	/* Database:Airline Table:flight Item:arrivalAirport */
    
	airlineName		varchar(20)	not null,	/* Table:airline Item:name */
    airplaneName	varchar(20)	not	null,	/* Database:Airline Table:airplane Item:name */
	airplaneType	varchar(10) not	null,	/* 大：240 中：160 小：80 */
	depatureAirportName		varchar(20)	not null,
    arrivalAirportName		varchar(20)	not null,
    depatureAirportCity		varchar(20)	not null,
    arrivalAirportCity		varchar(20)	not null,
    
    airplaneEmptySeats	int(3)	not	null	/* Database:Airline Table:airplane Item:conunt of empty seats */
);

create table airport(
	code 		varchar(4)	not null	primary key,
    name		varchar(20)	not null,
    city		varchar(20)	not null,
    country		varchar(20)	not null,
    connTime	int(3)		not null	/* minute */
);

create table passenger(
	passport	varchar(20)	not null,	/* no primary key for test */
    name		varchar(20)	not null	
);

create table trip(
	id				int(10)		not	null	primary key,
    flightInfoID	int(10)		not null,	/* Database:Airline Table:flight Item: */
    fare			float(6,2)	not null,	/* fare不同于 flightInfo中的 fare */
    passport		varchar(20)	not null,	/* Table:passenger Item:passport */
    seatID			int(3)		not null	/* Database:Airline Table:seat Item:relativeID */
);

create table orders(
	id				int(10)		not	null,	/* id 相同的为同一个订单 */
    tripID			int(10)		not	null,	/* Table:tirp Item:id */
    createDate		date		not null,
    createTime		time		not null,
    totalFare		float(6,2)	not	null,
    contactName		varchar(20)	not	null,
    contactPhone 	varchar(20) not null
);

