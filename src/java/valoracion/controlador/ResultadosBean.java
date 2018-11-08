/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.controlador;

import java.util.List;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import valoracion.facade.ValoracionFacade;

/**
 *
 * @author anthony
 */
@ManagedBean(name = "resultados")
@ViewScoped
public class ResultadosBean {
    List resultados;
    @EJB 
    ValoracionFacade serviciosValoracion;
    /**
     * Creates a new instance of ResultadosBean
     */
    public ResultadosBean() {
    }
    
    @PostConstruct
    public void obtenerResultados(){
        resultados = serviciosValoracion.getCountValoracion();
        System.out.println(resultados);
    }
    
    public List getResultados() {
        return resultados;
    }

    public void setResultados(List resultados) {
        this.resultados = resultados;
    }
    
}
