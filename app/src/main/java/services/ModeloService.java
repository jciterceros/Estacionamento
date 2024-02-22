package services;

import java.util.List;
import java.util.Scanner;

import entities.Modelo;
import repositories.ModeloRepository;

public class ModeloService {

    // Ler dados do Modelo
    public static Modelo LerDadosModelo(Scanner sc) {
        System.out.println("");
        System.out.println("Digite o Codigo do Modelo: ");
        Integer codMod = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a Descricao do Modelo: ");
        String Desc_2 = sc.nextLine();
        return new Modelo(codMod, Desc_2);
    }

    // Cadastrar Modelo
    public static void CadastrarModelo(Scanner sc, List<Modelo> modelos, ModeloRepository modeloRepository) {

        Modelo inputDadosModelo = LerDadosModelo(sc);

        if (!isModeloCadastrado(modelos, inputDadosModelo.getCodMod())) {
            modelos.add(inputDadosModelo);
            modelos.forEach(modelo -> {
                if (modelo.getCodMod().equals(inputDadosModelo.getCodMod())) {
                    System.out.printf("Codigo: %d, Descricao: %s\n", modelo.getCodMod(), modelo.getDesc_2());
                }
            });
            modeloRepository.inserirModelo(inputDadosModelo.getCodMod(), inputDadosModelo.getDesc_2());
            System.out.println("Modelo cadastrado com sucesso");
        } else {
            System.out.println("Modelo já cadastrado");
        }
    }

    // Listar Modelos
    public static void ListarModelos(List<Modelo> modelos) {
        System.out.println("");
        System.out.println("Listando Modelos");
        modelos.forEach(modelo -> System.out.println(modelo.toString()));
    }

    // Atualizar Modelo
    public static void AtualizarModelo(Scanner sc, List<Modelo> modelos, ModeloRepository modeloRepository) {

        Modelo inputDadosModelo = LerDadosModelo(sc);

        if (isModeloCadastrado(modelos, inputDadosModelo.getCodMod())) {
            // Atualiza um modelo na lista de modelos
            modelos.forEach(modelo -> {
                if (modelo.getCodMod().equals(inputDadosModelo.getCodMod())) {
                    modelo.setDesc_2(inputDadosModelo.getDesc_2());
                    System.out.printf("Codigo: %d, Descricao: %s\n", modelo.getCodMod(), modelo.getDesc_2());
                }
            });
            modeloRepository.atualizarModelo(inputDadosModelo.getCodMod(),
                    inputDadosModelo.getDesc_2());
            System.out.println("Modelo atualizado com sucesso");
        } else {
            System.out.println("Modelo não cadastrado");
        }
    }

    // Deletar Modelo
    public static void DeletarModelo(Scanner sc, List<Modelo> modelos, ModeloRepository modeloRepository) {

        System.out.println("");
        System.out.println("Digite o Codigo do Modelo que deseja deletar: ");
        Integer codMod = sc.nextInt();
        sc.nextLine();

        if (isModeloCadastrado(modelos, codMod)) {
            // Deleta um modelo na lista de modelos
            modelos.removeIf(modelo -> modelo.getCodMod().equals(codMod));
            modeloRepository.deletarModeloByCod(codMod);
            System.out.println("Modelo deletado com sucesso");
        } else {
            System.out.println("Modelo não cadastrado");
        }
    }

    // Verificar se o modelo já está cadastrado
    public static boolean isModeloCadastrado(List<Modelo> modelos, Integer codMod) {
        return modelos.stream().anyMatch(modelo -> modelo.getCodMod().equals(codMod));
    }
}
