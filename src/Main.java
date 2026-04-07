package br.inatel.pcmania;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do cliente:");
        String nome = entrada.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = entrada.nextLine();
        System.out.println("Digite a sua matricula:");
        int matricula = entrada.nextInt();

        Cliente cliente = new Cliente(nome, cpf);

        Computador pc1 = new Computador("Apple", matricula, "macOS Sequoia", 64, "Pentium Core i3", 2200, 8, 500);
        pc1.addMemoriaUSB(new MemoriaUSB("Pendrive", 16));

        Computador pc2 = new Computador("Samsung", matricula - 1234, "Windows 8", 64, "Pentium Core i5", 3370, 16, 1000);
        pc2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        Computador pc3 = new Computador("Dell", matricula + 5678, "Windows 10", 64, "Pentium Core i7", 4500, 32, 2000);
        pc3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1));

        int opcao;
        do {
            System.out.println("\n--- PC Mania ---");
            System.out.println("1 - Promocao 1 (Apple)");
            System.out.println("2 - Promocao 2 (Samsung)");
            System.out.println("3 - Promocao 3 (Dell)");
            System.out.println("0 - Finalizar compra");
            System.out.print("Escolha uma opcao: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cliente.addComputador(pc1);
                    System.out.println("PC Apple adicionado ao carrinho!");
                    break;
                case 2:
                    cliente.addComputador(pc2);
                    System.out.println("PC Samsung adicionado ao carrinho!");
                    break;
                case 3:
                    cliente.addComputador(pc3);
                    System.out.println("PC Dell adicionado ao carrinho!");
                    break;
                case 0:
                    System.out.println("Encerrando as compras...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opcao != 0);

        System.out.println("\n=================================");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("=================================");
        System.out.println("Itens comprados:");

        for (int i = 0; i < cliente.getComputadores().length; i++) {
            if (cliente.getComputadores()[i] != null) {
                cliente.getComputadores()[i].mostraPCConfigs();
            }
        }

        System.out.println("Total a pagar: R$ " + cliente.calculaTotalCompra());
        ProcessarPedido.confirmar(cliente.getComputadores());

        entrada.close();
    }
}