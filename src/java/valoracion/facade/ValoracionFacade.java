/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
}
