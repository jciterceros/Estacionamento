package services;

import java.util.List;
import java.util.Scanner;

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

    // Cadastrar Veiculo
    public static void CadastrarVeiculo(Scanner sc, List<Veiculo> veiculos, VeiculoRepository veiculoRepository) {

        Veiculo inputDadosVeiculo = LerDadosVeiculo(sc);

        if (!isVeiculoCadastrado(veiculos, inputDadosVeiculo.getPlaca())) {
            veiculos.add(inputDadosVeiculo);
            veiculos.forEach(veiculo -> {
                if (veiculo.getPlaca().equals(inputDadosVeiculo.getPlaca())) {
                    System.out.printf("Placa: %s, Modelo: %d, CPF: %d, Cor: %s\n", veiculo.getPlaca(),
                            veiculo.getModelo_codMod(), veiculo.getCliente_cpf(), veiculo.getCor());
                }
            });
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
    public static void AtualizarVeiculo(Scanner sc, List<Veiculo> veiculos, VeiculoRepository veiculoRepository) {

        Veiculo inputDadosVeiculo = LerDadosVeiculo(sc);

        if (isVeiculoCadastrado(veiculos, inputDadosVeiculo.getPlaca())) {
            // Atualiza um veiculo na lista de veiculos
            veiculos.forEach(veiculo -> {
                if (veiculo.getPlaca().equals(inputDadosVeiculo.getPlaca())) {
                    veiculo.setModelo_codMod(inputDadosVeiculo.getModelo_codMod());
                    veiculo.setCliente_cpf(inputDadosVeiculo.getCliente_cpf());
                    veiculo.setCor(inputDadosVeiculo.getCor());
                    System.out.printf("Placa: %s, Modelo: %d, CPF: %d, Cor: %s\n", veiculo.getPlaca(),
                            veiculo.getModelo_codMod(), veiculo.getCliente_cpf(), veiculo.getCor());
                }
            });
            veiculoRepository.atualizarVeiculo(inputDadosVeiculo.getPlaca(), inputDadosVeiculo.getModelo_codMod(),
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
