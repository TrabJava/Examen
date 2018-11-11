/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.dto.Juego;

/**
 *
 * @author Berni
 */
@Stateless
public class JuegoFacade extends AbstractFacade<Juego> {

    @PersistenceContext(unitName = "TrabajoExamenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JuegoFacade() {
        super(Juego.class);
    }
    
}
