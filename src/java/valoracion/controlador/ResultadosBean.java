/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import valoracion.entidades.Valoracion;
import valoracion.facade.ValoracionFacade;
import valoracion.otros.UtilsClass;

/**
 *
 * @author anthony
 */
@ManagedBean(name = "resultadosBean")
@ViewScoped
public class ResultadosBean {

    List resultados;
    @EJB
    ValoracionFacade serviciosValoracion;
    private Date desde;
    private Date hasta;
    private List<Valoracion> historial = null;
    private UtilsClass utilsClass = new UtilsClass();


    /**
     * Creates a new instance of ResultadosBean
     */
    @PostConstruct
    public void obtenerResultados() {
        GregorianCalendar calendario = (GregorianCalendar) Calendar.getInstance();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        if (desde == null || hasta == null) {
            try {
                desde = formatoFecha.parse(formatoFecha.format(calendario.getTime()));
                calendario.add(Calendar.DAY_OF_MONTH, 1);
                hasta = formatoFecha.parse(formatoFecha.format(calendario.getTime()));

            } catch (ParseException ex) {
                Logger.getLogger(ResultadosBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        resultados = serviciosValoracion.getCountValoracion(desde, hasta);
    }



    public void actualizarHistorial() {
        historial = serviciosValoracion.obtenerHistorial();
    }

    public ValoracionFacade getServiciosValoracion() {
        return serviciosValoracion;
    }

    public void setServiciosValoracion(ValoracionFacade serviciosValoracion) {
        this.serviciosValoracion = serviciosValoracion;
    }

    public UtilsClass getUtilsClass() {
        return utilsClass;
    }

    public void setUtilsClass(UtilsClass utilsClass) {
        this.utilsClass = utilsClass;
    }

    public List getResultados() {
        return resultados;
    }

    public void setResultados(List resultados) {
        this.resultados = resultados;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public List<Valoracion> getHistorial() {
        if (historial == null) {
            historial = serviciosValoracion.obtenerHistorial();
        }
        return historial;
    }

    public void setHistorial(List<Valoracion> historial) {
        this.historial = historial;
    }

}
