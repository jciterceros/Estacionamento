/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Fernando
 */
public class Veiculo {

    private String placa;
    private Integer Modelo_codMod;
    private Long Cliente_cpf;
    private String cor;
    Cliente cliente;
    Modelo modelo;

    public Veiculo(String placa, Integer Modelo_codMod, Long Cliente_cpf, String cor) {
        this.placa = placa;
        this.Modelo_codMod = Modelo_codMod;
        this.Cliente_cpf = Cliente_cpf;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getModelo_codMod() {
        return Modelo_codMod;
    }

    public void setModelo_codMod(Integer Modelo_codMod) {
        this.Modelo_codMod = Modelo_codMod;
    }

    public Long getCliente_cpf() {
        return Cliente_cpf;
    }

    public void setCliente_cpf(Long Cliente_cpf) {
        this.Cliente_cpf = Cliente_cpf;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Veiculo [placa=" + placa + ", Modelo_codMod=" + Modelo_codMod + ", Cliente_cpf=" + Cliente_cpf
                + ", cor=" + cor + ", " + cliente + ", " + modelo + "]";
    }
}
