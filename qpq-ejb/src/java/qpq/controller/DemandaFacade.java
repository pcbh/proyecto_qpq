/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qpq.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import qpq.dominio.Demanda;

/**
 *
 * @author laura
 */
@Stateless
public class DemandaFacade extends AbstractFacade<Demanda> {
    @PersistenceContext(unitName = "qpq-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DemandaFacade() {
        super(Demanda.class);
    }
    
}
