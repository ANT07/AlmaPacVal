/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import valoracion.entidades.Valoracion;

/**
 *
 * @author anthony
 */
@Stateless
public class ValoracionFacade extends AbstractFacade<Valoracion> {

    @PersistenceContext(unitName = "VALORACIONPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValoracionFacade() {
        super(Valoracion.class);
    }
    SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy/MM/dd");

    public List getCountValoracion() {
        Query q = this.em.createQuery("SELECT v.tipoValoracion, COUNT(v.idValoracion) FROM Valoracion v where v.fecha BETWEEN :inicio AND :fin GROUP BY v.tipoValoracion");
        try {
            q.setParameter("inicio", fechaFormato.parse("2018/01/01"),TemporalType.DATE);
            q.setParameter("fin", fechaFormato.parse("2018/11/07"),TemporalType.DATE);
        } catch (ParseException ex) {
            Logger.getLogger(ValoracionFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        List lista = q.getResultList();
        return lista;
    }

    public static void main(String[] args) {
        ValoracionFacade valoracioner = new ValoracionFacade();
        System.out.println(valoracioner.getCountValoracion());
    }

}
