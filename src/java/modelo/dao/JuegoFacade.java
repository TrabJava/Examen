/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    
    public List<Juego> buscarNombreJuego(Juego ju){
        List<Juego> lista;
        try {
            Query query = em.createQuery("SELECT j FROM Juego j WHERE j.nombre LIKE ?1");
            query.setParameter(1, "%"+ju.getNombre()+"%");
            lista = query.getResultList();
        } catch (Exception e) {
         throw e;
        }
        return lista;
    }

}
