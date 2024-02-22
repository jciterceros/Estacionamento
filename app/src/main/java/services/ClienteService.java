package services;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteService {

    // Ler dados do Cliente
    public static Cliente LerDadosCliente(Scanner sc) {
        System.out.println("");
        System.out.println("Digite o CPF do Cliente: ");
        Long cpf = sc.nextLong();
        sc.nextLine();
        System.out.println("Digite o Nome do Cliente: ");
        String nome = sc.nextLine();
        System.out.println("Digite a Data de Nascimento do Cliente: ");
        String dtNasc = sc.nextLine();
        return new Cliente(cpf, nome, Date.valueOf(dtNasc));
    }

    // Cadastrar Cliente
    public static void CadastrarCliente(Scanner sc, List<Cliente> clientes, ClienteRepository clienteRepository) {

        Cliente inputDadosCliente = LerDadosCliente(sc);

        if (!isClienteCadastrado(clientes, inputDadosCliente.getCpf())) {
            clientes.add(inputDadosCliente);
            clientes.forEach(cliente -> {
                if (cliente.getCpf().equals(inputDadosCliente.getCpf())) {
                    System.out.printf("CPF: %d, Nome: %s, Data de Nascimento: %s\n", cliente.getCpf(),
                            cliente.getNome(), cliente.getDtNasc());
                }
            });
            clienteRepository.inserirCliente(inputDadosCliente.getCpf(), inputDadosCliente.getNome(),
                    inputDadosCliente.getDtNasc().toString());
            System.out.println("Cliente cadastrado com sucesso");
        } else {
            System.out.println("Cliente já cadastrado");
        }
    }

    // Listar Clientes
    public static void ListarClientes(List<Cliente> clientes) {
        System.out.println("");
        System.out.println("Listando Clientes");
        clientes.forEach(cliente -> System.out.println(cliente.toString()));
    }

    // Atualizar Cliente
    public static void AtualizarCliente(Scanner sc, List<Cliente> clientes, ClienteRepository clienteRepository) {

        Cliente inputDadosCliente = LerDadosCliente(sc);

        if (isClienteCadastrado(clientes, inputDadosCliente.getCpf())) {
            // Atualiza um cliente na lista de clientes
            clientes.forEach(cliente -> {
                if (cliente.getCpf().equals(inputDadosCliente.getCpf())) {
                    cliente.setNome(inputDadosCliente.getNome());
                    cliente.setDtNasc(inputDadosCliente.getDtNasc());
                    System.out.printf("CPF: %d, Nome: %s, Data de Nascimento: %s\n", cliente.getCpf(),
                            cliente.getNome(), cliente.getDtNasc());
                }
            });
            clienteRepository.atualizarCliente(inputDadosCliente.getCpf(), inputDadosCliente.getNome(),
                    inputDadosCliente.getDtNasc().toString());
            System.out.println("Cliente Atualizado com sucesso");
        } else {
            System.out.println("Cliente não cadastrado");
        }
    }

    // Deletar Cliente
    public static void DeletarCliente(Scanner sc, List<Cliente> clientes, ClienteRepository clienteRepository) {
        System.out.println("");
        System.out.println("Digite o CPF do Cliente: ");
        Long cpf = sc.nextLong();
        sc.nextLine();

        if (isClienteCadastrado(clientes, cpf)) {
            // Deleta um cliente da lista de clientes
            clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
            clienteRepository.deletarClienteByCPF(cpf);
            System.out.println("Cliente Deletado com sucesso");
        } else {
            System.out.println("Cliente não cadastrado");
        }
    }

    // Verifica se existe o Cliente
    public static boolean isClienteCadastrado(List<Cliente> clientes, Long cpf) {
        return clientes.stream().anyMatch(cliente -> cliente.getCpf().equals(cpf));
    }
}
