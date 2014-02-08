/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qpq.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import qpq.dominio.Oferta;

/**
 *
 * @author laura
 */
@Stateless
public class OfertaFacade extends AbstractFacade<Oferta> {
    @PersistenceContext(unitName = "qpq-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OfertaFacade() {
        super(Oferta.class);
    }
    
}
