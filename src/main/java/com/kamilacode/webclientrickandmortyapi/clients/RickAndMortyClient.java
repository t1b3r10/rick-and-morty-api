package com.kamilacode.webclientrickandmortyapi.clients;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.kamilacode.webclientrickandmortyapi.responses.CharacterResponse;
import com.kamilacode.webclientrickandmortyapi.responses.EpisodeResponse;
import com.kamilacode.webclientrickandmortyapi.responses.ListOfEpisodesResponse;
import com.kamilacode.webclientrickandmortyapi.responses.LocationResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClient {
	
	private final WebClient webClient;
	
	public RickAndMortyClient(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}
	
	public Mono<CharacterResponse> findAndCharacterById(String id){
		log.info("buscando o personagem com o id [{}]", id);
		return webClient
				.get()
				.uri("/character/" + id)
				.accept(APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
				.bodyToMono(CharacterResponse.class);
	}
	
	public Mono<LocationResponse> findAndLocationById(String id){
		log.info("buscando a localização com o id [{}]", id);
		return webClient
				.get()
				.uri("/location/" + id)
				.accept(APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
				.bodyToMono(LocationResponse.class);
	}
	
	public Mono<EpisodeResponse> findAndEpisodeById(String id){
		log.info("buscando o episódio com o id [{}]", id);
		return webClient
				.get()
				.uri("/episode/" + id)
				.accept(APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
				.bodyToMono(EpisodeResponse.class);
	}
	
	public Flux<ListOfEpisodesResponse> getAllEpisodes(){
		log.info("listando todos os episódios");
		return webClient
				.get()
				.uri("/episode/")
				.accept(APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
				.bodyToFlux(ListOfEpisodesResponse.class);
	}

}