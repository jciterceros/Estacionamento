package database.seeds;

import services.ClienteService;

public class SeedsCliente {
    public SeedsCliente(ClienteService clienteService) {
        // Criar tabela de Cliente
        clienteService.criarTabelaCliente();

        // Deletar Todos os Clientes
        clienteService.deletarTodosClientes();

        // Inserir Cliente
        clienteService.inserirCliente(33351745001L, "Fernando", "1990-01-01");
        clienteService.inserirCliente(33351745002L, "Maria", "1991-01-01");
        clienteService.inserirCliente(33351745003L, "Joao", "1992-01-01");
        clienteService.inserirCliente(33351745004L, "Jose", "1993-01-01");
        clienteService.inserirCliente(33351745005L, "Ana", "1994-01-01");
        clienteService.inserirCliente(33351745006L, "Paulo", "1995-01-01");
        clienteService.inserirCliente(33351745007L, "Pedro", "1996-01-01");
        clienteService.inserirCliente(33351745008L, "Lucas", "1997-01-01");
        clienteService.inserirCliente(33351745009L, "Marcos", "1998-01-01");
        clienteService.inserirCliente(33351745010L, "Lucia", "1999-01-01");
    }
}
