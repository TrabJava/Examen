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
@Table(name = "tipo_consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoConsulta.findAll", query = "SELECT t FROM TipoConsulta t")
    , @NamedQuery(name = "TipoConsulta.findByIdTipoconsulta", query = "SELECT t FROM TipoConsulta t WHERE t.idTipoconsulta = :idTipoconsulta")
    , @NamedQuery(name = "TipoConsulta.findByDescTipoconsulta", query = "SELECT t FROM TipoConsulta t WHERE t.descTipoconsulta = :descTipoconsulta")})
public class TipoConsulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipoconsulta")
    private Integer idTipoconsulta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_tipoconsulta")
    private String descTipoconsulta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCon")
    private List<Ticket> ticketList;

    public TipoConsulta() {
    }

    public TipoConsulta(Integer idTipoconsulta) {
        this.idTipoconsulta = idTipoconsulta;
    }

    public TipoConsulta(Integer idTipoconsulta, String descTipoconsulta) {
        this.idTipoconsulta = idTipoconsulta;
        this.descTipoconsulta = descTipoconsulta;
    }

    public Integer getIdTipoconsulta() {
        return idTipoconsulta;
    }

    public void setIdTipoconsulta(Integer idTipoconsulta) {
        this.idTipoconsulta = idTipoconsulta;
    }

    public String getDescTipoconsulta() {
        return descTipoconsulta;
    }

    public void setDescTipoconsulta(String descTipoconsulta) {
        this.descTipoconsulta = descTipoconsulta;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoconsulta != null ? idTipoconsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConsulta)) {
            return false;
        }
        TipoConsulta other = (TipoConsulta) object;
        if ((this.idTipoconsulta == null && other.idTipoconsulta != null) || (this.idTipoconsulta != null && !this.idTipoconsulta.equals(other.idTipoconsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.TipoConsulta[ idTipoconsulta=" + idTipoconsulta + " ]";
    }
    
}
