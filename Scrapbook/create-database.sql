-- create-users.sql
--
-- Copyright (c) 2019 Rafael Corchuelo.
--
-- In keeping with the traditional purpose of furthering education and research, it is
-- the policy of the copyright owner to permit non-commercial use and redistribution of
-- this software. It has been tested carefully, but it is not guaranteed for any particular
-- purposes. The copyright owner does not offer any warranties or representations, nor do
-- they accept any liabilities with respect to them.

-- Change "Starter-Project" according to the name of your project.

drop database if exists `Starter-Project`;
create database `Starter-Project`;

grant select, insert, update, delete 
	on `Starter-Project`.* to 'acme-user'@'%';

grant select, insert, update, delete, create, drop, references, index, alter, 
        create temporary tables, lock tables, create view, create routine, 
        alter routine, execute, trigger, show view
    on `Starter-Project`.* to 'acme-manager'@'%';