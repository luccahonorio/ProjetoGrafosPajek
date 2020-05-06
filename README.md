# Projeto_grafos_pajek
projeto final de grafos

Título do Trabalho:
Definição e Construção de uma Aplicação de Grafos de Alta Dimensionalidade


Características do Trabalho:
* Valor: 100% da nota do RA4 para a disciplina de Resolução de Problemas com Grafos;
* Equipe: Máximo em duplas;
* Linguagem: JAVA ou Python e
* Data da Entrega: 27/11/2019.


 
Requisitos de entrega:
* Entregar código-fonte em arquivo;
* Entregar código-fonte impresso; e
* Realizar teste de autoria.



Requisitos de implementação:


* ~~(0,5 Ponto) Módulo de gravação de Grafo, ponderado e rotulado em Arquivo (Formato Pajek em anexo);~~  
* ~~(0,5 Ponto) Módulo de carregamento de Grafo de Arquivo (Formato Pajek em anexo);~~  
* ~~(0,5 Ponto) Função que verifica se o grafo é conexo ou não;~~  
* ~~(0,5 Ponto) Função que verifica se o grafo é Euleriano ou não;~~  
* ~~(1,0 Ponto) Função que verifica se o grafo é Cíclico ou não;~~  
* ~~(1,0 Ponto) Função que calcula a Centralidade de Posicionamento de cada nó (considere a distância do melhor caminho);~~  
* ~~(1,0 Ponto) Função que calcula a Centralidade de Intermediação de cada nó (considere a distância do melhor caminho);~~  
* ~~(1,0 Ponto) Gerador de grafo aleatório que recebe as seguintes entradas:~~  
  ~~N. de nós;~~
  ~~N. de arestas;~~
  ~~Se conexo ou não;~~

* ~~(4,0 pontos) Modelar um problema com grafo à sua escolha com as seguintes características:~~  
~~Mínimo de 5.000 (cinco mil nós)  
Mínimo de 20.000 (vinte mil) arestas~~    

A implementação das questões anteriores deve suportar a aplicação que você escolheu.  
O problema deve ser modelado pela equipe e cópias de grafos ou códigos, mesmo que parciais, prontas da Internet ou outras fontes acarretará nota 0 a todas as equipes envolvidas.  

BASE DE DADOS

Foi selecionado um subconjunto da base de dados de todos os comentarios do site Reddit no mês de maio de 2015. segue link:  
https://www.kaggle.com/reddit/reddit-comments-may-2015  

o significado de cada coluna desta base está documentado em:
https://github.com/reddit-archive/reddit/wiki/JSON  

Foi extraído da base os comentarios do subreddit "programming", e apenas algumas colunas foram selecionadas para extração, sendo elas:
* id
* name
* author
* parent_id
* ups  

O grafo é contruído partindo do ponto de que cada usuário faz comentários, sendo eles a um post ou uma resposta a outro comentário. Caso seja uma resposta, é criada uma aresta entre o usuário que escreveu a resposta, e o usuário que escreveu o comentário respondido.

O problema a ser resolvido é o cálculo dos pontos de cada usuário, com base na pontuação acumulada de cada um de seus comentários.
