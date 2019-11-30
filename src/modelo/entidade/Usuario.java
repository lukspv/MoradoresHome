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
public class Usuario {
    private int usid;
    private String usnome;
    private String uslogin;
    private String ussenha;

    /**
     * @return the usid
     */
    public int getusid() {
        return usid;
    }

    /**
     * @param usid the usid to set
     */
    public void setusid(int usid) {
        this.usid = usid;
    }

    /**
     * @return the usnome
     */
    public String getusnome() {
        return usnome;
    }

    /**
     * @param usnome the usnome to set
     */
    public void setusnome(String usnome) {
        this.usnome = usnome;
    }

    /**
     * @return the uslogin
     */
    public String getuslogin() {
        return uslogin;
    }

    /**
     * @param uslogin the uslogin to set
     */
    public void setuslogin(String uslogin) {
        this.uslogin = uslogin;
    }

    /**
     * @return the Usenha
     */
    public String getussenha() {
        return ussenha;
    }

    /**
     * @param Usenha the Usenha to set
     */
    public void setussenha(String ussenha) {
        this.ussenha = ussenha;
    }
    
    
    
}
