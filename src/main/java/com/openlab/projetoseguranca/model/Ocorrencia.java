package com.openlab.projetoseguranca.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ocorrencia {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_ocorrencia;

    private String nome_usuario_relacionado;

    private String tipo_ocorrencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ocorrencia_usuario",
            joinColumns = @JoinColumn(name = "ocorrencia_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios;

    @OneToOne(mappedBy = "ocorrencia", cascade = CascadeType.ALL)
    private Advertencia advertencia;


    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Advertencia getAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(Advertencia advertencia) {
        this.advertencia = advertencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_ocorrencia() {
        return tipo_ocorrencia;
    }

    public void setTipo_ocorrencia(String tipo_ocorrencia) {
        this.tipo_ocorrencia = tipo_ocorrencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public String getNome_usuario_relacionado() {
        return nome_usuario_relacionado;
    }

    public void setNome_usuario_relacionado(String nome_usuario_relacionado) {
        this.nome_usuario_relacionado = nome_usuario_relacionado;
    }

    public Date getData_ocorrencia() {
        return data_ocorrencia;
    }

    public void setData_ocorrencia(Date data_ocorrencia) {
        this.data_ocorrencia = data_ocorrencia;
    }

    
}
