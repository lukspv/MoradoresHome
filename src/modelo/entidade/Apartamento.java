/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidade;

/**
 *
 * @author lucas
 */
public class Apartamento {
    
    
    private String apnumero;
    private String apandar;
    private String dispo;
    private Bloco bloco;

    /**
     * @return the apnumero
     */
    public String getapnumero() {
        return apnumero;
    }

    /**
     * @param apnumero the apnumero to set
     */
    public void setapnumero(String apnumero) {
        this.apnumero = apnumero;
    }

    /**
     * @return the apandar
     */
    public String getapandar() {
        return apandar;
    }

    /**
     * @param apandar the apandar to set
     */
    public void setapandar(String apandar) {
        this.apandar = apandar;
    }

    /**
     * @return the bloco
     */
    public Bloco getbloco() {
        return bloco;
    }

    /**
     * @param bloco the bloco to set
     */
    public void setbloco(Bloco bloco) {
        this.bloco = bloco;
    }

    /**
     * @return the dipo
     */
    public String getdispo() {
        return dispo;
    }

    /**
     * @param dipo the dipo to set
     */
    public void setdispo(String dipo) {
        this.dispo = dispo;
    }
    
    @Override
    public String toString() {
        return apnumero;
    }
}
