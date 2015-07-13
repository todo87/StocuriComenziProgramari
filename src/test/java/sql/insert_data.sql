insert into `testdepo`.`role` (role) values ('MASTER');
insert into `testdepo`.`role` (role) values ('ADMIN');
insert into `testdepo`.`role` (role) values ('USER');
insert into `testdepo`.`role` (role) values ('VIEWER');
# ================================================================== `testdepo`.`unit` =====================================
insert into `testdepo`.`unit` (unit) values ('test');
# ================================================================== `testdepo`.`users` ====================================
insert into `testdepo`.`users`(name,surname,username,password,email,enabled,accNonExp,accNonLocked,credNonExpired,id_role,id_unit,createdBy) values('stefan_m','todoras_m','st_m','12','1@2.3',1,1,1,1,1,1,'todo');
insert into `testdepo`.`users`(name,surname,username,password,email,enabled,accNonExp,accNonLocked,credNonExpired,id_role,id_unit,createdBy) values('stefan_a','todoras_a','st_a','12','1@2.3',1,1,1,1,2,1,'todo');
insert into `testdepo`.`users`(name,surname,username,password,email,enabled,accNonExp,accNonLocked,credNonExpired,id_role,id_unit,createdBy) values('stefan_u','todoras_u','st_u','12','1@2.3',1,1,1,1,3,1,'todo');
insert into `testdepo`.`users`(name,surname,username,password,email,enabled,accNonExp,accNonLocked,credNonExpired,id_role,id_unit,createdBy) values('stefan_v','todoras_v','st_v','12','1@2.3',1,1,1,1,4,1,'todo');