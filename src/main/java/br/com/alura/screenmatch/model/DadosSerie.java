package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.service.ConsultaMyMemory;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonAlias("Genre") String genero,
                         @JsonAlias("Actors") String atores,
                         @JsonAlias("Poster") String poster,
                         @JsonAlias("Plot") String sinopse) {
    public DadosSerie {
        //acrescentei a tradução aqui porque na primeira vez que imprimia os dados da série na tela não apresentava a tradução
        if (sinopse != null && !sinopse.isBlank()) {
            sinopse = ConsultaMyMemory.obterTraducao(sinopse);
        }
    }
}
