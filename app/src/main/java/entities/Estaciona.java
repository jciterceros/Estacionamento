/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Fernando
 */
public class Estaciona {

    private Integer cod;
    private Integer Patio_num;
    private String Veiculo_placa;
    private String dtEntrada;
    private String dtSaida;
    private String hsEntrada;
    private String hsSaida;
    Patio patio;
    Veiculo veiculo;

    public Estaciona(Integer cod, Integer Patio_num, String Veiculo_placa, String dtEntrada, String dtSaida,
            String hsEntrada, String hsSaida) {
        this.cod = cod;
        this.Patio_num = Patio_num;
        this.Veiculo_placa = Veiculo_placa;
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida;
        this.hsEntrada = hsEntrada;
        this.hsSaida = hsSaida;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getPatio_num() {
        return Patio_num;
    }

    public void setPatio_num(Integer Patio_num) {
        this.Patio_num = Patio_num;
    }

    public String getVeiculo_placa() {
        return Veiculo_placa;
    }

    public void setVeiculo_placa(String Veiculo_placa) {
        this.Veiculo_placa = Veiculo_placa;
    }

    public String getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(String dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public String getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(String dtSaida) {
        this.dtSaida = dtSaida;
    }

    public String getHsEntrada() {
        return hsEntrada;
    }

    public void setHsEntrada(String hsEntrada) {
        this.hsEntrada = hsEntrada;
    }

    public String getHsSaida() {
        return hsSaida;
    }

    public void setHsSaida(String hsSaida) {
        this.hsSaida = hsSaida;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    @Override
    public String toString() {
        return "Estacionamento [cod=" + cod + ", Patio_num=" + Patio_num + ", Veiculo_placa=" + Veiculo_placa
                + ", dtEntrada=" + dtEntrada + ", dtSaida=" + dtSaida + ", hsEntrada=" + hsEntrada + ", hsSaida="
                + hsSaida + ", " + patio + ", " + veiculo + "]";
    }
}
