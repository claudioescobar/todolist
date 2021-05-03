insert into tb_user(id,login,password,user_name) values(1,'teste1@teste.com','123','Teste 1 da Silva');
insert into tb_user(id,login,password,user_name) values(2,'teste2@teste.com','321','Teste 2 Junior');
insert into tb_user(id,login,password,user_name) values(3,'teste3@teste.com','333','Teste 3 Maria');

insert into tb_task(id,user_id,title,description,status,date_create,date_update)
    values(1,2,'Servico de todo list','Implementar endpoint rest, repositories e validacoes',1,'2021-02-02 10:11:12','2021-02-03 10:11:12');
insert into tb_task(id,user_id,title,description,status,date_create,date_update)
    values(2,2,'Interface todo list','Implementar paginas do CRUD',2,'2021-02-04 10:11:12','2021-02-05 10:11:12');
insert into tb_task(id,user_id,title,description,status,date_create,date_update)
    values(3,1,'Testes do todo list','Especificar e Implementar todos os cenarios de teste.',1,'2021-02-06 10:11:12','2021-02-07 10:11:12');