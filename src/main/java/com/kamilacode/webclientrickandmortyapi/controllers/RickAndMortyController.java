package com.kamilacode.webclientrickandmortyapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kamilacode.webclientrickandmortyapi.clients.RickAndMortyClient;
import com.kamilacode.webclientrickandmortyapi.responses.CharacterResponse;
import com.kamilacode.webclientrickandmortyapi.responses.EpisodeResponse;
import com.kamilacode.webclientrickandmortyapi.responses.ListOfEpisodesResponse;
import com.kamilacode.webclientrickandmortyapi.responses.LocationResponse;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {
	
	RickAndMortyClient rickAndMortyClient;
	
	@GetMapping("/character/{id}")
	public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
		
		return rickAndMortyClient.findAndCharacterById(id);
		
	}
	
	@GetMapping("/location/{id}")
	public Mono<LocationResponse> getLocationById(@PathVariable String id){
		
		return rickAndMortyClient.findAndLocationById(id);
		
	}
	
	@GetMapping("/episode/{id}")
	public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
		
		return rickAndMortyClient.findAndEpisodeById(id);
		
	}	

	@GetMapping("/episodes")
	public Flux<ListOfEpisodesResponse> getAllEpisodes(){
		
		return rickAndMortyClient.getAllEpisodes();
		
	}	
	

}
