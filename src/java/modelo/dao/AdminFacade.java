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
import modelo.dto.Admin;
import modelo.dto.Usuario;

/**
 *
 * @author Berni
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> {

    @PersistenceContext(unitName = "TrabajoExamenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }
    public Admin existeUsuario(Admin ad){
        Admin admin = null;
        try {
            Query query = em.createQuery("SELECT a FROM Admin a WHERE a.user = :user AND a.pass = :pass");
        query.setParameter("user", ad.getUser());
        query.setParameter("pass", ad.getPass());
        List<Admin> lista = query.getResultList();
            if (!lista.isEmpty()) {
                admin = lista.get(0);
            }
        
        } catch (Exception e) {
            throw e;
        }
        return admin;
    }
    
}
