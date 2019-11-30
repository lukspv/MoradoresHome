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
public class Bloco {

    private String blid;
    private String blrua;
    private String blnumero;

    /**
     * @return the blid
     */
    public String getblid() {
        return blid;
    }

    /**
     * @param blid the blid to set
     */
    public void setblid(String blid) {
        this.blid = blid;
    }

    /**
     * @return the blrua
     */
    public String getblrua() {
        return blrua;
    }

    /**
     * @param blrua the blrua to set
     */
    public void setblrua(String blrua) {
        this.blrua = blrua;
    }

    /**
     * @return the blnumero
     */
    public String getblnumero() {
        return blnumero;
    }

    /**
     * @param blnumero the blnumero to set
     */
    public void setblnumero(String blnumero) {
        this.blnumero = blnumero;
    }

    @Override
    public String toString() {
        return blid;
    }

}
