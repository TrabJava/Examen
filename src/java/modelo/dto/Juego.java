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
@Table(name = "juego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j")
    , @NamedQuery(name = "Juego.findByIdJuego", query = "SELECT j FROM Juego j WHERE j.idJuego = :idJuego")
    , @NamedQuery(name = "Juego.findByNombre", query = "SELECT j FROM Juego j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Juego.findByDescJuego", query = "SELECT j FROM Juego j WHERE j.descJuego = :descJuego")
    , @NamedQuery(name = "Juego.findByValor", query = "SELECT j FROM Juego j WHERE j.valor = :valor")
    , @NamedQuery(name = "Juego.findByFabricante", query = "SELECT j FROM Juego j WHERE j.fabricante = :fabricante")
    , @NamedQuery(name = "Juego.findByIdioma", query = "SELECT j FROM Juego j WHERE j.idioma = :idioma")
    , @NamedQuery(name = "Juego.findBySubtitulos", query = "SELECT j FROM Juego j WHERE j.subtitulos = :subtitulos")
    , @NamedQuery(name = "Juego.findByOnline", query = "SELECT j FROM Juego j WHERE j.online = :online")
    , @NamedQuery(name = "Juego.findByCantidad", query = "SELECT j FROM Juego j WHERE j.cantidad = :cantidad")
    , @NamedQuery(name = "Juego.findByFoto", query = "SELECT j FROM Juego j WHERE j.foto = :foto")})
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_juego")
    private Integer idJuego;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "desc_juego")
    private String descJuego;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "idioma")
    private String idioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "subtitulos")
    private String subtitulos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "online")
    private String online;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 150)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juegoCom")
    private List<Compra> compraList;
    @JoinColumn(name = "categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "estado_ju", referencedColumnName = "id_estadojuego")
    @ManyToOne(optional = false)
    private EstadoJuego estadoJu;
    @JoinColumn(name = "tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private TipoConsola tipo;
    @OneToMany(mappedBy = "juego")
    private List<Usuario> usuarioList;

    public Juego() {
    }

    public Juego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Juego(Integer idJuego, String nombre, String descJuego, String valor, String fabricante, String idioma, String subtitulos, String online) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.descJuego = descJuego;
        this.valor = valor;
        this.fabricante = fabricante;
        this.idioma = idioma;
        this.subtitulos = subtitulos;
        this.online = online;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescJuego() {
        return descJuego;
    }

    public void setDescJuego(String descJuego) {
        this.descJuego = descJuego;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(String subtitulos) {
        this.subtitulos = subtitulos;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public EstadoJuego getEstadoJu() {
        return estadoJu;
    }

    public void setEstadoJu(EstadoJuego estadoJu) {
        this.estadoJu = estadoJu;
    }

    public TipoConsola getTipo() {
        return tipo;
    }

    public void setTipo(TipoConsola tipo) {
        this.tipo = tipo;
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
        hash += (idJuego != null ? idJuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juego)) {
            return false;
        }
        Juego other = (Juego) object;
        if ((this.idJuego == null && other.idJuego != null) || (this.idJuego != null && !this.idJuego.equals(other.idJuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.Juego[ idJuego=" + idJuego + " ]";
    }
    
}
