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
@Table(name = "estado_codigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCodigo.findAll", query = "SELECT e FROM EstadoCodigo e")
    , @NamedQuery(name = "EstadoCodigo.findByIdEstadocod", query = "SELECT e FROM EstadoCodigo e WHERE e.idEstadocod = :idEstadocod")
    , @NamedQuery(name = "EstadoCodigo.findByDescEstadocod", query = "SELECT e FROM EstadoCodigo e WHERE e.descEstadocod = :descEstadocod")})
public class EstadoCodigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadocod")
    private Integer idEstadocod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_estadocod")
    private String descEstadocod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCo")
    private List<Codigo> codigoList;

    public EstadoCodigo() {
    }

    public EstadoCodigo(Integer idEstadocod) {
        this.idEstadocod = idEstadocod;
    }

    public EstadoCodigo(Integer idEstadocod, String descEstadocod) {
        this.idEstadocod = idEstadocod;
        this.descEstadocod = descEstadocod;
    }

    public Integer getIdEstadocod() {
        return idEstadocod;
    }

    public void setIdEstadocod(Integer idEstadocod) {
        this.idEstadocod = idEstadocod;
    }

    public String getDescEstadocod() {
        return descEstadocod;
    }

    public void setDescEstadocod(String descEstadocod) {
        this.descEstadocod = descEstadocod;
    }

    @XmlTransient
    public List<Codigo> getCodigoList() {
        return codigoList;
    }

    public void setCodigoList(List<Codigo> codigoList) {
        this.codigoList = codigoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadocod != null ? idEstadocod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCodigo)) {
            return false;
        }
        EstadoCodigo other = (EstadoCodigo) object;
        if ((this.idEstadocod == null && other.idEstadocod != null) || (this.idEstadocod != null && !this.idEstadocod.equals(other.idEstadocod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.EstadoCodigo[ idEstadocod=" + idEstadocod + " ]";
    }
    
}
