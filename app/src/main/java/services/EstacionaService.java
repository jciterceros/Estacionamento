package services;

import java.util.List;
import java.util.Scanner;

import entities.Estaciona;
import repositories.EstacionaRepository;

public class EstacionaService {

    // Ler dados do Estacionamento
    public static Estaciona LerDadosEstaciona(Scanner sc) {
        System.out.println("");
        System.out.println("Digite o Codigo do Modelo: ");
        Integer cod = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o Numero do Patio: ");
        Integer Patio_num = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a Placa do Veiculo: ");
        String Veiculo_placa = sc.nextLine();
        System.out.println("Digite a Data de Entrada: ");
        String dtEntrada = sc.nextLine();
        System.out.println("Digite a Hora de Entrada: ");
        String hsEntrada = sc.nextLine();
        System.out.println("Digite a Data de Saida: ");
        String dtSaida = sc.nextLine();
        System.out.println("Digite a Hora de Saida: ");
        String hsSaida = sc.nextLine();
        return new Estaciona(cod, Patio_num, Veiculo_placa, dtEntrada, dtSaida,
                hsEntrada, hsSaida);
    }

    // Cadastrar Estacionamento
    public static void CadastrarEstaciona(Scanner sc, List<Estaciona> estacionas,
            EstacionaRepository estacionaRepository) {

        Estaciona inputDadosEstaciona = LerDadosEstaciona(sc);

        if (!isEstacionaCadastrado(estacionas, inputDadosEstaciona.getCod())) {
            estacionas.add(inputDadosEstaciona);
            estacionas.forEach(estaciona -> {
                if (estaciona.getCod().equals(inputDadosEstaciona.getCod())) {
                    System.out.printf(
                            "Codigo: %d, Patio: %d, Veiculo: %s, Data de Entrada: %s, Data de Saida: %s, Hora de Entrada: %s, Hora de Saida: %s\n",
                            estaciona.getCod(), estaciona.getPatio_num(), estaciona.getVeiculo_placa(),
                            estaciona.getDtEntrada(), estaciona.getDtSaida(), estaciona.getHsEntrada(),
                            estaciona.getHsSaida());
                }
            });
            estacionaRepository.inserirEstaciona(inputDadosEstaciona.getCod(), inputDadosEstaciona.getPatio_num(),
                    inputDadosEstaciona.getVeiculo_placa(), inputDadosEstaciona.getDtEntrada(),
                    inputDadosEstaciona.getDtSaida(), inputDadosEstaciona.getHsEntrada(),
                    inputDadosEstaciona.getHsSaida());
            System.out.println("Estaciona cadastrado com sucesso");
        } else {
            System.out.println("Estaciona já cadastrado");
        }
    }

    // Listar Estacionamentos
    public static void ListarEstacionas(List<Estaciona> estacionas) {
        System.out.println("");
        System.out.println("Listando Estacionamentos");
        estacionas.forEach(estaciona -> System.out.println(estaciona.toString()));
    }

    // Atualizar Estacionamento
    public static void AtualizarEstaciona(Scanner sc, List<Estaciona> estacionas,
            EstacionaRepository estacionaRepository) {

        Estaciona inputDadosEstaciona = LerDadosEstaciona(sc);

        if (isEstacionaCadastrado(estacionas, inputDadosEstaciona.getCod())) {
            // Atualiza um estacionamento na lista de estacionamentos
            estacionas.forEach(estaciona -> {
                if (estaciona.getCod().equals(inputDadosEstaciona.getCod())) {
                    estaciona.setPatio_num(inputDadosEstaciona.getPatio_num());
                    estaciona.setVeiculo_placa(inputDadosEstaciona.getVeiculo_placa());
                    estaciona.setDtEntrada(inputDadosEstaciona.getDtEntrada());
                    estaciona.setDtSaida(inputDadosEstaciona.getDtSaida());
                    estaciona.setHsEntrada(inputDadosEstaciona.getHsEntrada());
                    estaciona.setHsSaida(inputDadosEstaciona.getHsSaida());
                    System.out.printf(
                            "Codigo: %d, Patio: %d, Veiculo: %s, Data de Entrada: %s, Data de Saida: %s, Hora de Entrada: %s, Hora de Saida: %s\n",
                            estaciona.getCod(), estaciona.getPatio_num(), estaciona.getVeiculo_placa(),
                            estaciona.getDtEntrada(), estaciona.getDtSaida(), estaciona.getHsEntrada(),
                            estaciona.getHsSaida());
                }
            });
            estacionaRepository.atualizarEstaciona(inputDadosEstaciona.getCod(), inputDadosEstaciona.getPatio_num(),
                    inputDadosEstaciona.getVeiculo_placa(), inputDadosEstaciona.getDtEntrada(),
                    inputDadosEstaciona.getDtSaida(), inputDadosEstaciona.getHsEntrada(),
                    inputDadosEstaciona.getHsSaida());
            System.out.println("Estacionamento atualizado com sucesso");
        } else {
            System.out.println("Estacionamento não cadastrado");
        }
    }

    // Deletar Estacionamento
    public static void DeletarEstaciona(Scanner sc, List<Estaciona> estacionas,
            EstacionaRepository estacionaRepository) {

        System.out.println("");
        System.out.println("Digite o Codigo do Estacionamento que deseja deletar: ");
        Integer cod = sc.nextInt();
        sc.nextLine();

        if (isEstacionaCadastrado(estacionas, cod)) {
            estacionas.removeIf(estaciona -> estaciona.getCod().equals(cod));
            estacionaRepository.deletarEstacionaByCod(cod);
            System.out.println("Estacionamento deletado com sucesso");
        } else {
            System.out.println("Estacionamento não cadastrado");
        }
    }

    // Verifica se o Estacionamento já está cadastrado
    public static boolean isEstacionaCadastrado(List<Estaciona> estacionas, Integer cod) {
        return estacionas.stream().anyMatch(estaciona -> estaciona.getCod().equals(cod));
    }

}
