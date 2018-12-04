/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author anthony
 */
@ManagedBean
@RequestScoped
public class ControladorMenu {

    /**
     * Creates a new instance of ControladorMenu
     */
    private int activetabindex = 0;

    public String menuNavigation(String view) {
        switch (view) {
            case "resultados":
                setActivetabindex(1);
                return "Resultados";
            case "historial":
                setActivetabindex(2);
                return "LogValoraciones";
            case "valoracion":
                setActivetabindex(0);
                return "index";
            default:
                setActivetabindex(0);
                return "index";
        }

    }

    public int getActivetabindex() {
        return activetabindex;
    }

    public void setActivetabindex(int activetabindex) {
        this.activetabindex = activetabindex;
    }

}
