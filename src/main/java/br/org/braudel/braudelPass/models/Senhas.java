package br.org.braudel.braudelPass.models;


import jakarta.persistence.*;

@Entity
@Table(name = "senhas")
public class Senhas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String identificacao;
    private String usuario;
    private String senha;
    private String descricao;

    public Senhas(){}

    public Senhas(String identificacao, String usuario, String senha, String descricao) {
        this.identificacao = identificacao;
        this.usuario = usuario;
        this.senha = senha;
        this.descricao = descricao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return  "identificacao ='" + identificacao + '\'' +
                ", usuário ='" + usuario + '\'' +
                ", senha ='" + senha + '\'' +
                ", descricao ='" + descricao + '\'';
    }
}
