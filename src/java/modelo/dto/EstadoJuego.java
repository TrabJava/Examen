/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Berni
 */
@Entity
@Table(name = "estado_juego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoJuego.findAll", query = "SELECT e FROM EstadoJuego e")
    , @NamedQuery(name = "EstadoJuego.findByIdEstadojuego", query = "SELECT e FROM EstadoJuego e WHERE e.idEstadojuego = :idEstadojuego")
    , @NamedQuery(name = "EstadoJuego.findByDescEstadoju", query = "SELECT e FROM EstadoJuego e WHERE e.descEstadoju = :descEstadoju")})
public class EstadoJuego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadojuego")
    private Integer idEstadojuego;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_estadoju")
    private String descEstadoju;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoJu")
    private List<Juego> juegoList;

    public EstadoJuego() {
    }

    public EstadoJuego(Integer idEstadojuego) {
        this.idEstadojuego = idEstadojuego;
    }

    public EstadoJuego(Integer idEstadojuego, String descEstadoju) {
        this.idEstadojuego = idEstadojuego;
        this.descEstadoju = descEstadoju;
    }

    public Integer getIdEstadojuego() {
        return idEstadojuego;
    }

    public void setIdEstadojuego(Integer idEstadojuego) {
        this.idEstadojuego = idEstadojuego;
    }

    public String getDescEstadoju() {
        return descEstadoju;
    }

    public void setDescEstadoju(String descEstadoju) {
        this.descEstadoju = descEstadoju;
    }

    @XmlTransient
    public List<Juego> getJuegoList() {
        return juegoList;
    }

    public void setJuegoList(List<Juego> juegoList) {
        this.juegoList = juegoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadojuego != null ? idEstadojuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoJuego)) {
            return false;
        }
        EstadoJuego other = (EstadoJuego) object;
        if ((this.idEstadojuego == null && other.idEstadojuego != null) || (this.idEstadojuego != null && !this.idEstadojuego.equals(other.idEstadojuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.EstadoJuego[ idEstadojuego=" + idEstadojuego + " ]";
    }
    
}
