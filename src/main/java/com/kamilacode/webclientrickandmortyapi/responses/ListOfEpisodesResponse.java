package com.kamilacode.webclientrickandmortyapi.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ListOfEpisodesResponse {
	
	private List<EpisodeResponse> results;

}
