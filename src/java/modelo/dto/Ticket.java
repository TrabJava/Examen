/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByIdTicket", query = "SELECT t FROM Ticket t WHERE t.idTicket = :idTicket")
    , @NamedQuery(name = "Ticket.findByNumero", query = "SELECT t FROM Ticket t WHERE t.numero = :numero")
    , @NamedQuery(name = "Ticket.findByConsulta", query = "SELECT t FROM Ticket t WHERE t.consulta = :consulta")
    , @NamedQuery(name = "Ticket.findByRespuesta", query = "SELECT t FROM Ticket t WHERE t.respuesta = :respuesta")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ticket")
    private Integer idTicket;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "consulta")
    private String consulta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "respuesta")
    private String respuesta;
    @JoinColumn(name = "tipo_con", referencedColumnName = "id_tipoconsulta")
    @ManyToOne(optional = false)
    private TipoConsulta tipoCon;
    @OneToMany(mappedBy = "ticket")
    private List<Usuario> usuarioList;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(Integer idTicket, String numero, String consulta, String respuesta) {
        this.idTicket = idTicket;
        this.numero = numero;
        this.consulta = consulta;
        this.respuesta = respuesta;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public TipoConsulta getTipoCon() {
        return tipoCon;
    }

    public void setTipoCon(TipoConsulta tipoCon) {
        this.tipoCon = tipoCon;
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
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
