package br.inatel.pcmania;

public class ProcessarPedido {
    public static void confirmar(Computador[] computadores) {
        boolean temPedido = false;
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] != null) {
                temPedido = true;
                break;
            }
        }
        if (temPedido) {
            System.out.println("Pedido enviado...");
        }
    }
}