/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.dto.EstadoAdmin;

/**
 *
 * @author Berni
 */
@Stateless
public class EstadoAdminFacade extends AbstractFacade<EstadoAdmin> {

    @PersistenceContext(unitName = "TrabajoExamenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoAdminFacade() {
        super(EstadoAdmin.class);
    }
    
}
