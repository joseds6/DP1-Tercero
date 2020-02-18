-- create-users.sql
--
-- Copyright (c) 2019 Rafael Corchuelo.
--
-- In keeping with the traditional purpose of furthering education and research, it is
-- the policy of the copyright owner to permit non-commercial use and redistribution of
-- this software. It has been tested carefully, but it is not guaranteed for any particular
-- purposes. The copyright owner does not offer any warranties or representations, nor do
-- they accept any liabilities with respect to them.

drop user if exists 'acme-user'@'%';
create user 'acme-user'@'%' identified with mysql_native_password by 'ACME-Us3r-P@ssw0rd';
revoke all privileges, grant option from 'acme-user'@'%';

drop user if exists 'acme-manager'@'%';
create user 'acme-manager'@'%' identified with mysql_native_password by 'ACME-M@n@ger-6874';
revoke all privileges, grant option from 'acme-manager'@'%';
