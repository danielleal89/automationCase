#language: pt
#encoding: utf-8
#autor: DANIEL MARINS LEAL

Funcionalidade: Logar na pagina saucedemo.com

@LoginComSucesso
  @severity=blocker
  Cenario: Caso de Teste - Login com Sucesso
  	Dado O Usuario acessa a pagina "https://www.saucedemo.com/"
  	E O Usuario insere o username "standard_user" e o password "secret_sauce"
  	Entao O Usuario visualiza a tela com os produtos
