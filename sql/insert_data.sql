# ================================================================== `depo`.`role` =====================================
insert into `depo`.`role` (role) values ('MASTER');
insert into `depo`.`role` (role) values ('ADMIN');
insert into `depo`.`role` (role) values ('USER');
insert into `depo`.`role` (role) values ('VIEWER');
# ================================================================== `depo`.`unit` =====================================
insert into `depo`.`unit` (unit) values ('test');
# ================================================================== `depo`.`users` ====================================
insert into depo.users(nume,prenume,username,parola,mail,enabled,accNonExp,accNonLocked,credNonExpired,id_role,id_unit) values('stefan_m','todoras_m','st_m','12','1@2.3',1,1,1,1,1,1);
insert into depo.users(nume,prenume,username,parola,mail,enabled,accNonExp,accNonLocked,credNonExpired,id_role,id_unit) values('stefan_a','todoras_a','st_a','12','1@2.3',1,1,1,1,2,1);
insert into depo.users(nume,prenume,username,parola,mail,enabled,accNonExp,accNonLocked,credNonExpired,id_role,id_unit) values('stefan_u','todoras_u','st_u','12','1@2.3',1,1,1,1,3,1);
insert into depo.users(nume,prenume,username,parola,mail,enabled,accNonExp,accNonLocked,credNonExpired,id_role,id_unit) values('stefan_v','todoras_v','st_v','12','1@2.3',1,1,1,1,4,1);