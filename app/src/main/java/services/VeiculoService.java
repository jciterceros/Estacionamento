package services;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Modelo;
import entities.Veiculo;
import repositories.VeiculoRepository;

public class VeiculoService {

    // Ler dados do Veiculo
    public static Veiculo LerDadosVeiculo(Scanner sc) {
        System.out.println("");
        System.out.println("Digite a Placa do Veiculo: ");
        String placa = sc.nextLine();
        System.out.println("Digite o Codigo do Modelo: ");
        Integer codMod = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o CPF do Cliente: ");
        Long cpf = sc.nextLong();
        sc.nextLine();
        System.out.println("Digite a Cor do Veiculo: ");
        String cor = sc.nextLine();
        return new Veiculo(placa, codMod, cpf, cor);
    }

    // Valida Dados Inseridos
    // --- TODO: Refatorar

    public static <T> T ValidaDadosInseridos(List<T> objeto, List<Veiculo> veiculos, Veiculo inputDadosVeiculo,
            Class<T> classe) {
        if (classe == Cliente.class) {
            return (T) objeto.stream()
                    .filter(c -> ((Cliente) c).getCpf().equals(inputDadosVeiculo.getCliente_cpf()))
                    .findFirst().orElse(null);
        } else if (classe == Modelo.class) {
            return (T) objeto.stream()
                    .filter(m -> ((Modelo) m).getCodMod().equals(inputDadosVeiculo.getModelo_codMod()))
                    .findFirst().orElse(null);
        }
        return null;
    }

    // Cadastrar Veiculo
    public static void CadastrarVeiculo(Scanner sc, List<Veiculo> veiculos, List<Modelo> modelos,
            List<Cliente> clientes, VeiculoRepository veiculoRepository) {

        Veiculo inputDadosVeiculo = LerDadosVeiculo(sc);
        Cliente cliente;
        Modelo modelo;
        if (!isVeiculoCadastrado(veiculos, inputDadosVeiculo.getPlaca())) {
            if (inputDadosVeiculo.getCliente_cpf() != null && inputDadosVeiculo.getModelo_codMod() != null) {
                cliente = clientes.stream()
                        .filter(c -> c.getCpf().equals(inputDadosVeiculo.getCliente_cpf()))
                        .findFirst().orElse(null);
                modelo = modelos.stream()
                        .filter(m -> m.getCodMod().equals(inputDadosVeiculo.getModelo_codMod()))
                        .findFirst().orElse(null);
                if (cliente == null || modelo == null) {
                    System.out.println("Cliente ou Modelo não cadastrado");
                    return;
                }
            } else {
                System.out.println("Cliente ou Modelo Precisa ser informado");
                return;
            }

            veiculos.add(inputDadosVeiculo);

            for (Veiculo veiculo : veiculos) {
                if (veiculo.getPlaca().equals(inputDadosVeiculo.getPlaca())) {
                    veiculo.setCliente(cliente);
                    veiculo.setModelo(modelo);

                    System.out.printf("Placa: %s, Modelo: %d, CPF: %d, Cor: %s\n", veiculo.getPlaca(),
                            veiculo.getModelo_codMod(), veiculo.getCliente_cpf(), veiculo.getCor());
                }
            }

            veiculoRepository.inserirVeiculo(inputDadosVeiculo.getPlaca(), inputDadosVeiculo.getModelo_codMod(),
                    inputDadosVeiculo.getCliente_cpf(), inputDadosVeiculo.getCor());
            System.out.println("Veiculo cadastrado com sucesso");
        } else {
            System.out.println("Veiculo já cadastrado");
        }
    }

    // Listar Veiculos
    public static void ListarVeiculos(List<Veiculo> veiculos) {
        System.out.println("");
        System.out.println("Listando Veiculos");
        veiculos.forEach(veiculo -> System.out.println(veiculo.toString()));
    }

    // Atualizar Veiculo
    public static void AtualizarVeiculo(Scanner sc, List<Veiculo> veiculos, List<Modelo> modelos,
            List<Cliente> clientes,
            VeiculoRepository veiculoRepository) {

        Veiculo inputDadosVeiculo = LerDadosVeiculo(sc);

        if (isVeiculoCadastrado(veiculos, inputDadosVeiculo.getPlaca())) {
            // Atualiza um veiculo na lista de veiculos
            for (Veiculo veiculo : veiculos) {
                if (veiculo.getPlaca().equals(inputDadosVeiculo.getPlaca())) {

                    veiculo.setModelo_codMod(inputDadosVeiculo.getModelo_codMod());
                    veiculo.setCliente_cpf(inputDadosVeiculo.getCliente_cpf());
                    veiculo.setCor(inputDadosVeiculo.getCor());

                    Cliente cliente = clientes.stream()
                            .filter(c -> c.getCpf().equals(inputDadosVeiculo.getCliente_cpf()))
                            .findFirst().orElse(null);
                    veiculo.setCliente(cliente);
                    Modelo modelo = modelos.stream()
                            .filter(m -> m.getCodMod().equals(inputDadosVeiculo.getModelo_codMod()))
                            .findFirst().orElse(null);
                    veiculo.setModelo(modelo);

                    System.out.printf("Placa: %s, Modelo: %d, CPF: %d, Cor: %s\n", veiculo.getPlaca(),
                            veiculo.getModelo_codMod(), veiculo.getCliente_cpf(), veiculo.getCor());

                    // System.out.println(" depois de atualizado.... ");
                    // System.out.println(veiculo.toString());
                    // return;
                }
            }
            veiculoRepository.atualizarVeiculo(inputDadosVeiculo.getPlaca(),
                    inputDadosVeiculo.getModelo_codMod(),
                    inputDadosVeiculo.getCliente_cpf(), inputDadosVeiculo.getCor());

            System.out.println("Veiculo atualizado com sucesso");
        } else {
            System.out.println("Veiculo não cadastrado");
        }
    }

    // Deletar Veiculo
    public static void DeletarVeiculo(Scanner sc, List<Veiculo> veiculos, VeiculoRepository veiculoRepository) {

        System.out.println("");
        System.out.println("Digite a Placa do Veiculo que deseja deletar: ");
        String placa = sc.nextLine();

        if (isVeiculoCadastrado(veiculos, placa)) {
            veiculos.removeIf(veiculo -> veiculo.getPlaca().equals(placa));
            veiculoRepository.deletarVeiculoByPlaca(placa);
            System.out.println("Veiculo deletado com sucesso");
        } else {
            System.out.println("Veiculo não cadastrado");
        }
    }

    // Verifica se o veiculo ja esta cadastrado
    public static boolean isVeiculoCadastrado(List<Veiculo> veiculos, String placa) {
        return veiculos.stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
    }
}
