package services;

import java.util.List;
import java.util.Scanner;

import entities.Patio;
import repositories.PatioRepository;

public class PatioService {

    // Ler dados do Patio
    public static Patio LerDadosPatio(Scanner sc) {
        System.out.println("");
        System.out.println("Digite o Numero do Patio: ");
        Integer numPatio = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o Endereco do Patio: ");
        String enderPatio = sc.nextLine();
        System.out.println("Digite a Capacidade do Patio: ");
        Integer capacidadePatio = sc.nextInt();
        return new Patio(numPatio, enderPatio, capacidadePatio);
    }

    // Cadastrar Patio
    public static void CadastrarPatio(Scanner sc, List<Patio> patios, PatioRepository patioRepository) {

        Patio inputDadosPatio = LerDadosPatio(sc);

        if (!isPatioCadastrado(patios, inputDadosPatio.getNum())) {
            patios.add(inputDadosPatio);
            patios.forEach(patio -> {
                if (patio.getNum().equals(inputDadosPatio.getNum())) {
                    System.out.printf("Numero: %d, Endereco: %s, Capacidade: %d\n", patio.getNum(), patio.getEnder(),
                            patio.getCapacidade());
                }
            });
            patioRepository.inserirPatio(inputDadosPatio.getNum(), inputDadosPatio.getEnder(),
                    inputDadosPatio.getCapacidade());
            System.out.println("Patio cadastrado com sucesso");
        } else {
            System.out.println("Patio já cadastrado");
        }
    }

    // Listar Patios
    public static void ListarPatios(List<Patio> patios) {
        System.out.println("");
        System.out.println("Listando Patios");
        patios.forEach(patio -> System.out.println(patio.toString()));
    }

    // Atualizar Patio
    public static void AtualizarPatio(Scanner sc, List<Patio> patios, PatioRepository patioRepository) {

        Patio inputDadosPatio = LerDadosPatio(sc);

        if (isPatioCadastrado(patios, inputDadosPatio.getNum())) {
            // Atualiza um patio na lista de patios
            patios.forEach(patio -> {
                if (patio.getNum().equals(inputDadosPatio.getNum())) {
                    patio.setEnder(inputDadosPatio.getEnder());
                    patio.setCapacidade(inputDadosPatio.getCapacidade());
                    System.out.printf("Numero: %d, Endereco: %s, Capacidade: %d\n", patio.getNum(), patio.getEnder(),
                            patio.getCapacidade());
                }
            });
            patioRepository.atualizarPatio(inputDadosPatio.getNum(), inputDadosPatio.getEnder(),
                    inputDadosPatio.getCapacidade());
            System.out.println("Patio atualizado com sucesso");
        } else {
            System.out.println("Patio não cadastrado");
        }
    }

    // Deletar Patio
    public static void DeletarPatio(Scanner sc, List<Patio> patios, PatioRepository patioRepository) {

        System.out.println("");
        System.out.println("Digite o Numero do Patio que deseja deletar: ");
        Integer numPatio = sc.nextInt();

        if (isPatioCadastrado(patios, numPatio)) {
            // Deleta um patio na lista de patios
            patios.removeIf(patio -> patio.getNum().equals(numPatio));
            patioRepository.deletarPatioByNum(numPatio);
            System.out.println("Patio deletado com sucesso");
        } else {
            System.out.println("Patio não cadastrado");
        }
    }

    // Verifica se o Patio já está cadastrado
    public static boolean isPatioCadastrado(List<Patio> patios, Integer num) {
        return patios.stream().anyMatch(patio -> patio.getNum().equals(num));
    }
}
