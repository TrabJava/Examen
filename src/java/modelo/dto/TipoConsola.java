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
@Table(name = "tipo_consola")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoConsola.findAll", query = "SELECT t FROM TipoConsola t")
    , @NamedQuery(name = "TipoConsola.findByIdTipo", query = "SELECT t FROM TipoConsola t WHERE t.idTipo = :idTipo")
    , @NamedQuery(name = "TipoConsola.findByDscTipo", query = "SELECT t FROM TipoConsola t WHERE t.dscTipo = :dscTipo")})
public class TipoConsola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dsc_tipo")
    private String dscTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private List<Juego> juegoList;

    public TipoConsola() {
    }

    public TipoConsola(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TipoConsola(Integer idTipo, String dscTipo) {
        this.idTipo = idTipo;
        this.dscTipo = dscTipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getDscTipo() {
        return dscTipo;
    }

    public void setDscTipo(String dscTipo) {
        this.dscTipo = dscTipo;
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
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConsola)) {
            return false;
        }
        TipoConsola other = (TipoConsola) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.TipoConsola[ idTipo=" + idTipo + " ]";
    }
    
}
