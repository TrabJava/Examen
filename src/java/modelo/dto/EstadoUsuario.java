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
@Table(name = "estado_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoUsuario.findAll", query = "SELECT e FROM EstadoUsuario e")
    , @NamedQuery(name = "EstadoUsuario.findByIdEstadous", query = "SELECT e FROM EstadoUsuario e WHERE e.idEstadous = :idEstadous")
    , @NamedQuery(name = "EstadoUsuario.findByDescEstadous", query = "SELECT e FROM EstadoUsuario e WHERE e.descEstadous = :descEstadous")})
public class EstadoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadous")
    private Integer idEstadous;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_estadous")
    private String descEstadous;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoUser")
    private List<Usuario> usuarioList;

    public EstadoUsuario() {
    }

    public EstadoUsuario(Integer idEstadous) {
        this.idEstadous = idEstadous;
    }

    public EstadoUsuario(Integer idEstadous, String descEstadous) {
        this.idEstadous = idEstadous;
        this.descEstadous = descEstadous;
    }

    public Integer getIdEstadous() {
        return idEstadous;
    }

    public void setIdEstadous(Integer idEstadous) {
        this.idEstadous = idEstadous;
    }

    public String getDescEstadous() {
        return descEstadous;
    }

    public void setDescEstadous(String descEstadous) {
        this.descEstadous = descEstadous;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadous != null ? idEstadous.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoUsuario)) {
            return false;
        }
        EstadoUsuario other = (EstadoUsuario) object;
        if ((this.idEstadous == null && other.idEstadous != null) || (this.idEstadous != null && !this.idEstadous.equals(other.idEstadous))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.EstadoUsuario[ idEstadous=" + idEstadous + " ]";
    }
    
}
