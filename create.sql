create table agendamento (id int8 generated by default as identity, data_agendamento varchar(255), nome varchar(255), titulo varchar(255), id_cliente int8, id_livro int8, primary key (id));
create table aluguel (id int8 generated by default as identity, data_aluguel varchar(255), data_devolucao varchar(255), valor varchar(255), id_cliente int8, id_livro int8, primary key (id));
create table cliente (id int8 generated by default as identity, email varchar(255), endereco varchar(255), nome varchar(255), telefone varchar(255), primary key (id));
create table livro (id int8 generated by default as identity, ano varchar(255), autor varchar(255), descricao varchar(255), titulo varchar(255), primary key (id));
alter table if exists agendamento add constraint FK5nfg6jbph7b9cj8eqq75f9f9k foreign key (id_cliente) references cliente;
alter table if exists agendamento add constraint FKlu5jhlfcyc4lv2rumt9he1auy foreign key (id_livro) references livro;
alter table if exists aluguel add constraint FKe0q4l3sl41x20lu4gbj0h1a8e foreign key (id_cliente) references cliente;
alter table if exists aluguel add constraint FKoas14xldco66a1767644vs3w6 foreign key (id_livro) references livro;