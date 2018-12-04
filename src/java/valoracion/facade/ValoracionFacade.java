/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.facade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    public List getCountValoracion(Date desde, Date hasta) {
        List lista = null;
        try {
            Query q = this.em.createQuery("select V.tipoValoracion, COUNT(V) AS cantidad from Valoracion V WHERE V.fecha BETWEEN :inicio AND :fin GROUP BY V.tipoValoracion ORDER BY CANTIDAD DESC");
            q.setParameter("inicio", desde, TemporalType.DATE);
            q.setParameter("fin", hasta, TemporalType.DATE);
            lista = q.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Valoracion> obtenerHistorial() {
        List<Valoracion> historial = new ArrayList<>();
        try {
//            CriteriaQuery<Valoracion> criteria = this.em.getCriteriaBuilder().createQuery(Valoracion.class);
//            CriteriaBuilder builder = this.em.getCriteriaBuilder();
//            Root<Valoracion> root = criteria.from(Valoracion.class);
            
            Calendar now = Calendar.getInstance();
            Date ahora = now.getTime();
            now.add(Calendar.DAY_OF_MONTH, 1);
            Date manana = now.getTime();
            
//            Path<Date> fecha = root.<Date>get("fecha"); // choose the name of the property in Entity definition
//            Predicate predicate = builder.between(fecha,ahora,manana);
//            criteria.where(predicate);
            
            
            Query consultaFinal = this.em.createQuery("select v from Valoracion v where v.fecha BETWEEN :inicio AND :fin ORDER BY v.fecha DESC");
            consultaFinal.setParameter("inicio", ahora,TemporalType.DATE);
            consultaFinal.setParameter("fin", manana,TemporalType.DATE);
            historial = consultaFinal.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return historial;
    }

}
