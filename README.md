# Hotel-Proa
# Plataforma Modular para Gestão Interna de Hotel

Este projeto é um sistema modular desenvolvido para facilitar a gestão interna de hotéis. Ele é voltado exclusivamente para uso por funcionários, permitindo que diversas funcionalidades sejam acessadas e gerenciadas de forma organizada e eficiente. Utilizando o conceito de **software modulado**, cada funcionalidade é implementada como um módulo independente, facilitando manutenção e expansão.

## 🛠️ Recursos Principais

- **Boas-vindas personalizadas**: Ao acessar o sistema, o funcionário é recebido com uma mensagem personalizada que inclui o nome do hotel e do usuário.
- **Validação de acesso**: O sistema solicita o nome do usuário e uma senha para autenticação. A senha padrão é `2678`.
- **Menu principal interativo**: Implementado com `switch/case`, permite a navegação intuitiva entre os módulos.
- **Mensagens de saída personalizadas**: Ao encerrar a sessão, o sistema exibe uma mensagem de despedida com o nome do funcionário.
- **Retorno ao menu principal**: Após executar qualquer funcionalidade, o sistema retorna automaticamente ao menu principal.

## 📋 Funcionalidades Modulares

Cada opção do menu principal corresponde a um módulo do sistema, desenvolvido como uma função independente. O menu é dinâmico e pode ser expandido conforme necessário.

### Exemplos de Módulos Implementados
- **Gerenciamento de Reservas**: Adicionar, atualizar ou visualizar reservas de hóspedes.
- **Controle de Estoque**: Gerenciar os itens disponíveis no hotel, como toalhas, lençóis e produtos de limpeza.
- **Relatórios Financeiros**: Gerar relatórios detalhados sobre receitas e despesas.
- **Planejamento de Atividades**: Organizar tarefas para a equipe do hotel.
