package views;

public class MenuView {
    // Menu Principal
    public static void menuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println("1 - Clientes");
        System.out.println("2 - Modelo");
        System.out.println("3 - Patio");
        System.out.println("4 - Veiculo");
        System.out.println("5 - Estacionamento");
        System.out.println("0 - Sair");
    }

    // Menu Template
    public static void menu() {
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        System.out.println("0 - Menu principal");
    }

    // Menu Cadastrar Clientes
    public static void menuClientes() {
        System.out.println("");
        System.out.println("Menu Clientes");
        menu();
    }

    // Menu Cadastrar Modelo
    public static void menuModelo() {
        System.out.println("");
        System.out.println("Menu Modelo");
        menu();
    }

    // Menu Cadastrar Patio
    public static void menuPatio() {
        System.out.println("");
        System.out.println("Menu Patio");
        menu();
    }

    // Menu Cadastrar Veiculo
    public static void menuVeiculo() {
        System.out.println("");
        System.out.println("Menu Veiculo");
        menu();
    }

    // Menu Cadastrar Estacionamento
    public static void menuEstacionamento() {
        System.out.println("");
        System.out.println("Menu Estacionamento");
        menu();
    }
}
