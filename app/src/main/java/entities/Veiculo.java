/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class Veiculo {

    private String placa;
    private Integer Modelo_codMod;
    private Long Cliente_cpf;
    private String cor;
    List<Cliente> clientes = new ArrayList<Cliente>();
    List<Modelo> modelos = new ArrayList<Modelo>();

    public Veiculo(String placa, Integer Modelo_codMod, Long Cliente_cpf, String cor, List<Cliente> clientes,
            List<Modelo> modelos) {
        this.placa = placa;
        this.Modelo_codMod = Modelo_codMod;
        this.Cliente_cpf = Cliente_cpf;
        this.cor = cor;
        this.clientes = clientes;
        this.modelos = modelos;
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

}
