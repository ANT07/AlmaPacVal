/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import valoracion.entidades.Valoracion;
import valoracion.facade.ValoracionFacade;

/**
 *
 * @author anthony
 */
@ManagedBean
@ViewScoped
public class ValoracionBean {

    @EJB
    ValoracionFacade servicioValoracion;
    Valoracion valoracion = new Valoracion();

    /**
     * Creates a new instance of ValoracionBean
     */
    public ValoracionBean() {
    }

    public void ingresarValoracion() {
        GregorianCalendar calendario = (GregorianCalendar)Calendar.getInstance();
        ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String seleccion = request.getParameter("valoracion");
        valoracion.setTipoValoracion(seleccion);
        valoracion.setFecha(calendario.getTime());
        servicioValoracion.create(valoracion);
    }

}
