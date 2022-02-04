
insert into srh.cliente (id_cliente, nome_cliente) values (1, 'Armazém do Zé');
insert into srh.cliente (id_cliente, nome_cliente) values (2, 'Armazém da Esquina');
insert into srh.cliente (id_cliente, nome_cliente) values (3, 'Armazém do Belém');
insert into srh.cliente (id_cliente, nome_cliente) values (4, 'Armazém do João');
insert into srh.cliente (id_cliente, nome_cliente) values (5, 'Armazém do Pelé');

insert into srh.dominio (id_dominio, nome_dominio) values (1, 'Banco de Dados');
insert into srh.dominio (id_dominio, nome_dominio) values (2, 'LDAP');

insert into srh.usuario (id_usuario, nome_usuario, login_usuario, senha_usuario, dominio_id_dominio, ultimoAcesso_usuario) values (1, 'Cal Lightman', 'cal', '123', 1, CURRENT_DATE);
insert into srh.usuario (id_usuario, nome_usuario, login_usuario, senha_usuario, dominio_id_dominio, ultimoAcesso_usuario) values (2, 'Gillian Foster', 'gillian', '123', 1, CURRENT_DATE);
insert into srh.usuario (id_usuario, nome_usuario, login_usuario, senha_usuario, dominio_id_dominio, ultimoAcesso_usuario) values (3, 'Ria Torres', 'ria', '123', 1, CURRENT_DATE);
insert into srh.usuario (id_usuario, nome_usuario, login_usuario, senha_usuario, dominio_id_dominio, ultimoAcesso_usuario) values (4, 'Eli Locker', 'eli', '123', 1, CURRENT_DATE);
insert into srh.usuario (id_usuario, nome_usuario, login_usuario, senha_usuario, dominio_id_dominio, ultimoAcesso_usuario) values (5, 'Emily Lightman', 'emily', '123', 1, CURRENT_DATE);