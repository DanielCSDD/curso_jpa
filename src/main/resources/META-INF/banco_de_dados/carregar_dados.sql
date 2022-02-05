
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

insert into srh.configuracao (usuario_id_usuario, receber_notificacoes_configuracao, encerrar_sessao_automaticamente_configuracao) values (1, false, false);

insert into srh.funcionario (id_funcionario, versao_funcionario, nome_funcionario, banco_horas_funcionario, salario_funcionario, valor_hora_extra_funcionario) values (1, 0, 'Daniel Ricardo Silva', 36, 5360.00, 12.00);
insert into srh.funcionario (id_funcionario, versao_funcionario, nome_funcionario, banco_horas_funcionario, salario_funcionario, valor_hora_extra_funcionario) values (2, 0, 'Fabiana Oliveira Silva', 40, 5360.00, 12.00);
insert into srh.funcionario (id_funcionario, versao_funcionario, nome_funcionario, banco_horas_funcionario, salario_funcionario, valor_hora_extra_funcionario) values (3, 0, 'Ricardo Gomes dos Santos', 98, 5360.00, 12.00);
insert into srh.funcionario (id_funcionario, versao_funcionario, nome_funcionario, banco_horas_funcionario, salario_funcionario, valor_hora_extra_funcionario) values (4, 0, 'Flávia Catarina Nunes', 32, 5360.00, 12.00);
insert into srh.funcionario (id_funcionario, versao_funcionario, nome_funcionario, banco_horas_funcionario, salario_funcionario, valor_hora_extra_funcionario) values (5, 0, 'Gabriel dos Santos Menezes', 24, 5360.00, 12.00);