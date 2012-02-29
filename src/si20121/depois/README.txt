Assunto: TDD

Contexto: objetivo é implementar o engine de um jogo-da-velha. 
O engine recebe jogadas enquanto o jogo não termina, e informa o resultado 
depois que o jogo termina. O jogo termina quando: 

x Todos os campos foram tomados
- Todos os campos de uma coluna foram tomados pelo mesmo jogador
- Todos os campos de uma linha foram tomados pelo mesmo jogador
- Todos os campos de uma diagonal foram tomados pelo mesmo jogador

Um jogador pode jogar desde que: 
x Seja a sua vez
x O campo desejado não tenha já sido tomado
x O jogo não tenha acabado

