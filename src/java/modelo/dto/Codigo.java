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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "codigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codigo.findAll", query = "SELECT c FROM Codigo c")
    , @NamedQuery(name = "Codigo.findByIdCodigo", query = "SELECT c FROM Codigo c WHERE c.idCodigo = :idCodigo")
    , @NamedQuery(name = "Codigo.findByDescCodigo", query = "SELECT c FROM Codigo c WHERE c.descCodigo = :descCodigo")})
public class Codigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_codigo")
    private Integer idCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_codigo")
    private String descCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCom")
    private List<Compra> compraList;
    @JoinColumn(name = "estado_co", referencedColumnName = "id_estadocod")
    @ManyToOne(optional = false)
    private EstadoCodigo estadoCo;

    public Codigo() {
    }

    public Codigo(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    public Codigo(Integer idCodigo, String descCodigo) {
        this.idCodigo = idCodigo;
        this.descCodigo = descCodigo;
    }

    public Integer getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getDescCodigo() {
        return descCodigo;
    }

    public void setDescCodigo(String descCodigo) {
        this.descCodigo = descCodigo;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public EstadoCodigo getEstadoCo() {
        return estadoCo;
    }

    public void setEstadoCo(EstadoCodigo estadoCo) {
        this.estadoCo = estadoCo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodigo != null ? idCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codigo)) {
            return false;
        }
        Codigo other = (Codigo) object;
        if ((this.idCodigo == null && other.idCodigo != null) || (this.idCodigo != null && !this.idCodigo.equals(other.idCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.Codigo[ idCodigo=" + idCodigo + " ]";
    }
    
}
