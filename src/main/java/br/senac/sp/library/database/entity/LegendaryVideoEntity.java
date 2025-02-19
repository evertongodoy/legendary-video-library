package br.senac.sp.library.database.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Arrays;

@Document(collection = "legendary_library")
public class LegendaryVideoEntity {

    @Id
    private String id;
    private String nome;
    private String genero;
    private int duracao;
    private String origem;
    private LocalDate lancamento;
    private String sinopse;
    private String[] atores;
    private String diretor;
    private int classificacao;

    public String getId() {
        return id;
    }

    public LegendaryVideoEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public LegendaryVideoEntity setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public LegendaryVideoEntity setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public int getDuracao() {
        return duracao;
    }

    public LegendaryVideoEntity setDuracao(int duracao) {
        this.duracao = duracao;
        return this;
    }

    public String getOrigem() {
        return origem;
    }

    public LegendaryVideoEntity setOrigem(String origem) {
        this.origem = origem;
        return this;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public LegendaryVideoEntity setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
        return this;
    }

    public String getSinopse() {
        return sinopse;
    }

    public LegendaryVideoEntity setSinopse(String sinopse) {
        this.sinopse = sinopse;
        return this;
    }

    public String[] getAtores() {
        return atores;
    }

    public LegendaryVideoEntity setAtores(String[] atores) {
        this.atores = atores;
        return this;
    }

    public String getDiretor() {
        return diretor;
    }

    public LegendaryVideoEntity setDiretor(String diretor) {
        this.diretor = diretor;
        return this;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public LegendaryVideoEntity setClassificacao(int classificacao) {
        this.classificacao = classificacao;
        return this;
    }

    @Override
    public String toString() {
        return "LegendaryVideoEntity{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", duracao=" + duracao +
                ", origem='" + origem + '\'' +
                ", lancamento=" + lancamento +
                ", sinopse='" + sinopse + '\'' +
                ", atores=" + Arrays.toString(atores) +
                ", diretor='" + diretor + '\'' +
                ", classificacao=" + classificacao +
                '}';
    }

}