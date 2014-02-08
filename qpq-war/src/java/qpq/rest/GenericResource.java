/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qpq.rest;

import static com.sun.codemodel.JOp.lt;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import static javax.management.Query.lt;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import mail.JCMail;
import qpq.controller.DemandaFacade;
import qpq.controller.OfertaFacade;
import qpq.controller.UsuarioFacade;
import qpq.dominio.Demanda;
import qpq.dominio.Usuario;
import qpq.dominio.Oferta;

/**
 * REST Web Service
 *
 * @author laura
 */
@Path("generic")
@RequestScoped
public class GenericResource {
    DemandaFacade demandaFacade = lookupDemandaFacadeBean();
    OfertaFacade ofertaFacade = lookupOfertaFacadeBean();
    UsuarioFacade usuarioFacade = lookupUsuarioFacadeBean();
    static int idUsuarioRegistro;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of qpq.rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
   
    @GET
    @Path("user/{id}")
    @Produces("application/json")
    public Usuario getUser(@PathParam("id") String id) {
        int id2 = Integer.parseInt(id);
        return usuarioFacade.findById(id2);
    }
    
    @GET
    @Path("count")
    @Produces("application/json")
    public int getCount() {
        return usuarioFacade.count();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @POST
    @Path("oferta")
    @Consumes("application/json")
   // @Produces("application/json")
    public void postOferta(Oferta ofer){ 
        System.out.println("OFERTA");
        Usuario u = usuarioFacade.findById(idUsuarioRegistro);
        int idOferta = ofertaFacade.count()+1;
        ofer.setIdOferta(idOferta);
        ofer.setIdUsuario(u);
        ofertaFacade.create(ofer);
        
    }
    
    @POST
    @Path("demanda")
    @Consumes("application/json")
   // @Produces("application/json")
    public void postDemanda(Demanda demanda){ 
        System.out.println("DEMANDA");
        Usuario u = usuarioFacade.findById(idUsuarioRegistro);
        int iddemanda = demandaFacade.count()+1;
        demanda.setIddemanda(iddemanda);
        demanda.setIdUsuario(u);
        demandaFacade.create(demanda);
        
    }
    
    @PUT
    @Path("idRegistro/{idUsuario}")
    @Consumes("application/json")
    public void putidUsuario(@PathParam("idUsuario") int idUsuario){
        idUsuarioRegistro=idUsuario;
    }
    
    @POST
    @Path("user")
    @Consumes("application/json")
    @Produces("application/json")
    public Usuario postUser(Usuario user) {
        
        boolean existe=false;
        for (Usuario u: usuarioFacade.findAll()) {
            if(u.getLogin().equals(user.getLogin()))
                existe=true;
        }
        if(!existe){
            int idUsuario = usuarioFacade.count()+1;
            user.setIdUsuario(idUsuario);
            user.setReputacion(0);
            usuarioFacade.create(user);
        }
        return user;
    }    
    
    @GET
    @Path("getUsuario/{login}")    
    @Produces("application/json")
    public Usuario getUsuario(@PathParam("login") String login) {
        int userId = usuarioFacade.findByLogin(login);
        Usuario u = usuarioFacade.findById(userId);
        return u;
    }
    
    @GET
    @Path("id/{login}")    
    @Produces("application/json")
    public int getIdUser(@PathParam("login") String login) {
        int idUser=0;
        for(Usuario u: usuarioFacade.findAll()) {
            if(u.getLogin().equals(login)) {
                System.out.println("Lo encuentra");
                idUser=u.getIdUsuario();
            }
        }
        System.out.println("LLEGA");
        return idUser;
    }
    
    @GET
    @Path("user/{login}/{password}")    
    @Produces("application/json")
    public int getLogin(@PathParam("login") String login, @PathParam("password") String password) {
        int error=0;
        boolean existe=false;
        for(Usuario u: usuarioFacade.findAll()) {
            if(u.getLogin().equals(login)){
                if(!u.getPassword().equals(password)) 
                    error=1;
                existe=true;
                
            }                
        }
        if(!existe)
            error=2;
        System.out.println(existe);
        return error;
    }
    
    @GET
    @Path("password/{login}")    
    @Consumes("application/json")
    public void mandarMail(@PathParam("login") String login){
        int idUser = usuarioFacade.findByLogin(login);
        Usuario u = usuarioFacade.findById(idUser);
        String correo = u.getMail();
        JCMail mail = new JCMail();                    
        mail.setTo(correo);
        mail.setSubject("Nueva contraseña QPQ");
        String passwordnew=getCadenaAlfanumAleatoria(8);
        mail.setMessage("Su contraseña actual ha sido cambiada a una temporal: " + passwordnew);
        
        u.setPassword(passwordnew);
        usuarioFacade.edit(u);
        mail.SEND();
    }
    
String getCadenaAlfanumAleatoria (int longitud){
    String cadenaAleatoria = "";
    long milis = new java.util.GregorianCalendar().getTimeInMillis();
    Random r = new Random(milis);
    int i = 0;
    while ( i < longitud){
        char c = (char)r.nextInt(255);
        if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
            cadenaAleatoria += c;
            i ++;
        }
    }
    return cadenaAleatoria;
}
    
    @GET
    @Path("ofertas")
    @Produces("application/json")
    public List<Oferta> getOfertas(){
        List<Oferta> lo = ofertaFacade.findAll();
        List<Oferta> lo2;
        lo2 = new ArrayList<>();
        int i=0;
        int rand = (int)(Math.random()*lo.size());
        List num = new ArrayList();
        num.add(-1);
        int limite;
        if(lo.size()>8)
            limite=8;
        else
            limite=lo.size();
        System.out.println("limite: " + limite);
        if (!lo.isEmpty()){
            do {
                System.out.println("i es: " + i);
                if(!num.contains(rand)) {                    
                    num.add(rand);
                    System.out.println(num);
                    lo2.add(lo.get(rand));
                    System.out.println(lo2.get(i));
                    rand = (int)(Math.random()*lo.size());
                    i++;
                    System.out.println("rand: " + rand);
                    System.out.println("i: " + i);
                } else {
                    rand = (int)(Math.random()*lo.size());
                    System.out.println("RAND NO: " + rand);
                }
            } while (i!=limite);
        }
        for(int j=0; j<lo2.size();j++){
            System.out.println(lo2.get(j).getIdOferta());
        }
        return lo2;
    }
    
    @GET
    @Path("oferta/{idOferta}")
    @Produces("application/json")
    @Consumes("application/json")
    public Oferta getOferta(@PathParam("idOferta") int idOferta){
        return ofertaFacade.findByIdOferta(idOferta);
    }

    @GET
    @Path("demandas")
    @Produces("application/json")
    public List<Demanda> getDemandas(){
        List<Demanda> lo = demandaFacade.findAll();
        List<Demanda> lo2;
        lo2 = new ArrayList<>();
        int i=0;
        int rand = (int)(Math.random()*lo.size());
        List num = new ArrayList();
        num.add(-1);
        int limite;
        if(lo.size()>8)
            limite=8;
        else
            limite=lo.size();
        System.out.println("limite: " + limite);
        if (!lo.isEmpty()){
            do {
                System.out.println("i es: " + i);
                if(!num.contains(rand)) {                    
                    num.add(rand);
                    System.out.println(num);
                    lo2.add(lo.get(rand));
                    System.out.println(lo2.get(i));
                    rand = (int)(Math.random()*lo.size());
                    i++;
                    System.out.println("rand: " + rand);
                    System.out.println("i: " + i);
                } else {
                    rand = (int)(Math.random()*lo.size());
                    System.out.println("RAND NO: " + rand);
                }
            } while (i!=limite);
        }
        for(int j=0; j<lo2.size();j++){
            System.out.println(lo2.get(j).getIddemanda());
        }
        return lo2;
    }
    
    private UsuarioFacade lookupUsuarioFacadeBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (UsuarioFacade) c.lookup("java:global/qpq/qpq-ejb/UsuarioFacade!qpq.controller.UsuarioFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
        
        
    }

    private OfertaFacade lookupOfertaFacadeBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (OfertaFacade) c.lookup("java:global/qpq/qpq-ejb/OfertaFacade!qpq.controller.OfertaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private DemandaFacade lookupDemandaFacadeBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (DemandaFacade) c.lookup("java:global/qpq/qpq-ejb/DemandaFacade!qpq.controller.DemandaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
   
    
}
