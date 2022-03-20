<h1 align="center"> Projeto Sefaz - Sistema de Cadastro de Usuários  </h1>

<h2 style="font-size:16px">Descrição</h2>
O projeto foi desenvolvido para realizar cadastro de usuários contendo informações de nome, e-mail, senha e telefones. Foi implementado um sistema de login para acessar a tela de cadastro, apenas a título de testes, foi utilizado para liberar o acesso na tela de login os próprios usuarios cadastrados. Na tela de cadastro foi disponibilizado campo para adicionar endereço ao usuario, onde apenas a digitação do CEP se faz necessário, os demais campos são preenchidos automaticamente consumindo um webservice do site "VIA CEP". Nesse projeto foram utilizados:

-Java Web;
-Apache Maven;
-JSF;
-Prime Faces;
-JUnit;
-MySQL;
-WildFly.

## :hammer: Funcionalidades do projeto (CRUD)

- `Login de acesso`: Tela inicial com login e senha para acessar a tela de cadastro principal.
- `Cadastro de novo usuário`: Realiza o cadastro de um novo usuário e salva-o no banco de dados.
- `Lista todos os usuários cadastrados`: Exibe uma lista de todos os usuários já cadastrados no sistema.
- `Atualiza cadastro`: Faz a atualização de dados cadastrais de um usuário já existente.
- `Deletar cadastro`: Elimina um cadastro do banco de dados.
- `Lista de vários telefones`: Permite o cadastro de vários telefones para um mesmo usuário, exibindo lista separada para cada usuário.


![tela_login](https://user-images.githubusercontent.com/93333816/159145318-75be3efa-11f5-45a4-af65-4ec828883d96.jpg)

![tela_cadastro_1](https://user-images.githubusercontent.com/93333816/159188258-ae48a1d6-f9d2-410e-b022-47f90386bdca.jpg)

![tela_telefones_1](https://user-images.githubusercontent.com/93333816/159188268-e85b4afc-5965-4679-b838-093ad0fc8097.jpg)


## 🛠️ Abrir e rodar o projeto
- Preferencialmente IDE Eclipse;
- Java 11;
- Maven;
- MySQL;
- WildFly 21.0.0.

<h4 align="center"> 
    :construction:  Projeto em construção, futuras melhorias:  :construction:
</h4>

- `Implantação do "Open Session in View"`
- `Melhoria e personalização do front` 
- `Personalização de mensagens para o usuario de acordo com cada ação"`
- `Adicionar campo para cadastro de endereços` - Implementada 20/03.
