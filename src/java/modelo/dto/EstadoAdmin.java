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
@Table(name = "estado_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoAdmin.findAll", query = "SELECT e FROM EstadoAdmin e")
    , @NamedQuery(name = "EstadoAdmin.findByIdEstadoadmin", query = "SELECT e FROM EstadoAdmin e WHERE e.idEstadoadmin = :idEstadoadmin")
    , @NamedQuery(name = "EstadoAdmin.findByDescEstadoad", query = "SELECT e FROM EstadoAdmin e WHERE e.descEstadoad = :descEstadoad")})
public class EstadoAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadoadmin")
    private Integer idEstadoadmin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_estadoad")
    private String descEstadoad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoAdmin")
    private List<Admin> adminList;

    public EstadoAdmin() {
    }

    public EstadoAdmin(Integer idEstadoadmin) {
        this.idEstadoadmin = idEstadoadmin;
    }

    public EstadoAdmin(Integer idEstadoadmin, String descEstadoad) {
        this.idEstadoadmin = idEstadoadmin;
        this.descEstadoad = descEstadoad;
    }

    public Integer getIdEstadoadmin() {
        return idEstadoadmin;
    }

    public void setIdEstadoadmin(Integer idEstadoadmin) {
        this.idEstadoadmin = idEstadoadmin;
    }

    public String getDescEstadoad() {
        return descEstadoad;
    }

    public void setDescEstadoad(String descEstadoad) {
        this.descEstadoad = descEstadoad;
    }

    @XmlTransient
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoadmin != null ? idEstadoadmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoAdmin)) {
            return false;
        }
        EstadoAdmin other = (EstadoAdmin) object;
        if ((this.idEstadoadmin == null && other.idEstadoadmin != null) || (this.idEstadoadmin != null && !this.idEstadoadmin.equals(other.idEstadoadmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.EstadoAdmin[ idEstadoadmin=" + idEstadoadmin + " ]";
    }
    
}
