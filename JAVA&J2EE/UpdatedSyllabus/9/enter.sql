create schema OnlineDirectory;

use OnlineDirectory;

create table Telephone_Directory(phno char(10), name char(20), addr char(20), com char(20), pin char(20));

insert into Telephone_Directory values('9087654321','ram','blore','abc','560016');
insert into Telephone_Directory values('9087654361','rgm','blgre','agc','560066');
insert into Telephone_Directory values('1234567890','rdm','dlgre','dgc','565066');

select * from Telephone_Directory;
