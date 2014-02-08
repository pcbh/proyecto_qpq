/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qpq.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laura
 */
@Entity
@Table(name = "oferta", catalog = "qpqbbdd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByIdOferta", query = "SELECT o FROM Oferta o WHERE o.idOferta = :idOferta"),
    @NamedQuery(name = "Oferta.findByTitulo", query = "SELECT o FROM Oferta o WHERE o.titulo = :titulo"),
    @NamedQuery(name = "Oferta.findByDetalles", query = "SELECT o FROM Oferta o WHERE o.detalles = :detalles"),
    @NamedQuery(name = "Oferta.findByReputacion", query = "SELECT o FROM Oferta o WHERE o.reputacion = :reputacion"),
    @NamedQuery(name = "Oferta.findByTipo", query = "SELECT o FROM Oferta o WHERE o.tipo = :tipo"),
    @NamedQuery(name = "Oferta.findByCerrada", query = "SELECT o FROM Oferta o WHERE o.cerrada = :cerrada"),
    @NamedQuery(name = "Oferta.findByVisibilidad", query = "SELECT o FROM Oferta o WHERE o.visibilidad = :visibilidad"),
    @NamedQuery(name = "Oferta.findByComunidad", query = "SELECT o FROM Oferta o WHERE o.comunidad = :comunidad"),
    @NamedQuery(name = "Oferta.findByProvincia", query = "SELECT o FROM Oferta o WHERE o.provincia = :provincia"),
    @NamedQuery(name = "Oferta.findByCategoria", query = "SELECT o FROM Oferta o WHERE o.categoria = :categoria"),
    @NamedQuery(name = "Oferta.findBySubcategoria", query = "SELECT o FROM Oferta o WHERE o.subcategoria = :subcategoria"),
    @NamedQuery(name = "Oferta.findByLocalizacion", query = "SELECT o FROM Oferta o WHERE o.localizacion = :localizacion"),
    @NamedQuery(name = "Oferta.findByRealizacion", query = "SELECT o FROM Oferta o WHERE o.realizacion = :realizacion")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOferta", nullable = false)
    private Integer idOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Titulo", nullable = false, length = 45)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "Detalles", nullable = false, length = 5000)
    private String detalles;
    @Column(name = "Reputacion")
    private Integer reputacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tipo", nullable = false)
    private int tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cerrada", nullable = false)
    private int cerrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Visibilidad", nullable = false)
    private int visibilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Comunidad", nullable = false, length = 50)
    private String comunidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Provincia", nullable = false, length = 30)
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Categoria", nullable = false)
    private int categoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Subcategoria", nullable = false)
    private int subcategoria;
    @Size(max = 100)
    @Column(name = "Localizacion", length = 100)
    private String localizacion;
    @Size(max = 20)
    @Column(name = "Realizacion", length = 20)
    private String realizacion;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Casacion casacion;

    public Oferta() {
    }

    public Oferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Oferta(Integer idOferta, String titulo, String detalles, int tipo, int cerrada, int visibilidad, String comunidad, String provincia, int categoria, int subcategoria) {
        this.idOferta = idOferta;
        this.titulo = titulo;
        this.detalles = detalles;
        this.tipo = tipo;
        this.cerrada = cerrada;
        this.visibilidad = visibilidad;
        this.comunidad = comunidad;
        this.provincia = provincia;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Integer getReputacion() {
        return reputacion;
    }

    public void setReputacion(Integer reputacion) {
        this.reputacion = reputacion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCerrada() {
        return cerrada;
    }

    public void setCerrada(int cerrada) {
        this.cerrada = cerrada;
    }

    public int getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(int visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(int subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getRealizacion() {
        return realizacion;
    }

    public void setRealizacion(String realizacion) {
        this.realizacion = realizacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Casacion getCasacion() {
        return casacion;
    }

    public void setCasacion(Casacion casacion) {
        this.casacion = casacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qpq.dominio.Oferta[ idOferta=" + idOferta + " ]";
    }
    
}
