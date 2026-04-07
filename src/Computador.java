package br.inatel.pcmania;

public class Computador {
    private String marca;
    private float preco;
    private MemoriaUSB memoriaUSB;
    private SistemaOperacional sistemaOperacional;
    private HardwareBasico[] hardwareBasico;

    public Computador(String marca, float preco, String soNome, int soTipo, String procNome, float procCap, float ramCap, float hdCap) {
        this.marca = marca;
        this.preco = preco;
        this.sistemaOperacional = new SistemaOperacional(soNome, soTipo);
        this.hardwareBasico = new HardwareBasico[3];
        this.hardwareBasico[0] = new HardwareBasico(procNome, procCap);
        this.hardwareBasico[1] = new HardwareBasico("Memoria RAM", ramCap);
        this.hardwareBasico[2] = new HardwareBasico("HD", hdCap);
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");
        System.out.println("Hardware Basico:");
        for (int i = 0; i < hardwareBasico.length; i++) {
            if (hardwareBasico[i] != null) {
                System.out.println("- " + hardwareBasico[i].getNome() + " (" + hardwareBasico[i].getCapacidade() + ")");
            }
        }
        if (memoriaUSB != null) {
            System.out.println("Acompanha: " + memoriaUSB.getNome() + " de " + memoriaUSB.getCapacidade());
        }
        System.out.println("---------------------------------");
    }

    public float getPreco() {
        return preco;
    }
}