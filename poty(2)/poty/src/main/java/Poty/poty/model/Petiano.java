package Poty.poty.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table(name="petianos")
public class Petiano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// identificador para acesso ao banco de dados

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="curso", nullable=false)
    private String curso;

    @Column(name="img_perfil", nullable=true)
    private String imagem; // url da imagem

    public Petiano(){

    }
    public Petiano(String nm, String crs, String imagemPl){
        this.nome=nm;
        this.curso=crs;
        this.imagem=imagemPl;
    }

    public void setNome(String n){
        this.nome=n;
    }

    public void setCurso(String crs){
        this.curso=crs;
    }

    public void setIm(String url_im){
        this.imagem=url_im;
    }

    public String getNome(){
        return nome;
    }

        public String getCurso(){
        return curso;
    }


        public String getImg(){
        return imagem;
    }



}
