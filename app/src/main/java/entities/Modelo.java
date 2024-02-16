/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Fernando
 */
public class Modelo {

    private Integer codMod;
    private String Desc_2;

    public Modelo(Integer codMod, String Desc_2) {
        this.codMod = codMod;
        this.Desc_2 = Desc_2;
    }

    public Integer getCodMod() {
        return codMod;
    }

    public void setCodMod(Integer codMod) {
        this.codMod = codMod;
    }

    public String getDesc_2() {
        return Desc_2;
    }

    public void setDesc_2(String Desc_2) {
        this.Desc_2 = Desc_2;
    }

    @Override
    public String toString() {
        return "Modelo [codMod=" + codMod + ", Desc_2=" + Desc_2 + "]";
    }
}
