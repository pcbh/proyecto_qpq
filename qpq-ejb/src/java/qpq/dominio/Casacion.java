/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qpq.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laura
 */
@Entity
@Table(name = "casacion", catalog = "qpqbbdd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casacion.findAll", query = "SELECT c FROM Casacion c"),
    @NamedQuery(name = "Casacion.findByIdCasacion", query = "SELECT c FROM Casacion c WHERE c.idCasacion = :idCasacion"),
    @NamedQuery(name = "Casacion.findByIdUsuarioPub", query = "SELECT c FROM Casacion c WHERE c.idUsuarioPub = :idUsuarioPub"),
    @NamedQuery(name = "Casacion.findByFechaCas", query = "SELECT c FROM Casacion c WHERE c.fechaCas = :fechaCas"),
    @NamedQuery(name = "Casacion.findByCerrada", query = "SELECT c FROM Casacion c WHERE c.cerrada = :cerrada")})
public class Casacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCasacion", nullable = false)
    private Integer idCasacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarioPub", nullable = false)
    private int idUsuarioPub;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCas", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cerrada", nullable = false)
    private int cerrada;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "idCasacion", referencedColumnName = "iddemanda", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Demanda demanda;
    @JoinColumn(name = "idCasacion", referencedColumnName = "idOferta", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Oferta oferta;

    public Casacion() {
    }

    public Casacion(Integer idCasacion) {
        this.idCasacion = idCasacion;
    }

    public Casacion(Integer idCasacion, int idUsuarioPub, Date fechaCas, int cerrada) {
        this.idCasacion = idCasacion;
        this.idUsuarioPub = idUsuarioPub;
        this.fechaCas = fechaCas;
        this.cerrada = cerrada;
    }

    public Integer getIdCasacion() {
        return idCasacion;
    }

    public void setIdCasacion(Integer idCasacion) {
        this.idCasacion = idCasacion;
    }

    public int getIdUsuarioPub() {
        return idUsuarioPub;
    }

    public void setIdUsuarioPub(int idUsuarioPub) {
        this.idUsuarioPub = idUsuarioPub;
    }

    public Date getFechaCas() {
        return fechaCas;
    }

    public void setFechaCas(Date fechaCas) {
        this.fechaCas = fechaCas;
    }

    public int getCerrada() {
        return cerrada;
    }

    public void setCerrada(int cerrada) {
        this.cerrada = cerrada;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Demanda getDemanda() {
        return demanda;
    }

    public void setDemanda(Demanda demanda) {
        this.demanda = demanda;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasacion != null ? idCasacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casacion)) {
            return false;
        }
        Casacion other = (Casacion) object;
        if ((this.idCasacion == null && other.idCasacion != null) || (this.idCasacion != null && !this.idCasacion.equals(other.idCasacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qpq.dominio.Casacion[ idCasacion=" + idCasacion + " ]";
    }
    
}
