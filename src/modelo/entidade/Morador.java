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
public class Morador {
    private String mocpf;
    private String monome;
    private String mofone;
    private Apartamento apartemento;

    /**
     * @return the mocpf
     */
    public String getmocpf() {
        return mocpf;
    }

    /**
     * @param mocpf the mocpf to set
     */
    public void setmocpf(String mocpf) {
        this.mocpf = mocpf;
    }

    /**
     * @return the monome
     */
    public String getmonome() {
        return monome;
    }

    /**
     * @param monome the monome to set
     */
    public void setmonome(String monome) {
        this.monome = monome;
    }

    /**
     * @return the mofone
     */
    public String getmofone() {
        return mofone;
    }

    /**
     * @param mofone the mofone to set
     */
    public void setmofone(String mofone) {
        this.mofone = mofone;
    }

    /**
     * @return the apartemento
     */
    public Apartamento getapartemento() {
        return apartemento;
    }

    /**
     * @param apartemento the apartemento to set
     */
    public void setapartemento(Apartamento apartemento) {
        this.apartemento = apartemento;
    }
    
    

}