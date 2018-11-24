/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List getCountValoracion(Date desde, Date hasta) {
        List lista = null;
        try {
            Query q = this.em.createQuery("select V.tipoValoracion, COUNT(V) from Valoracion V WHERE V.fecha BETWEEN :inicio AND :fin GROUP BY V.tipoValoracion");
            q.setParameter("inicio", desde, TemporalType.DATE);
            q.setParameter("fin", hasta, TemporalType.DATE);
            lista = q.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
            return lista;
    }

}
