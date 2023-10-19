package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {
    public Flux<String> nameFlux() {
        return Flux.fromIterable(List.of("rahul", "manas", "pillu", "papa"));
    }
    public Mono<String> nameMono(){
        return Mono.just("mono");
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
        fluxAndMonoGeneratorService.nameFlux().subscribe(n -> System.out.println(n));
        fluxAndMonoGeneratorService.nameMono().subscribe(n -> System.out.println(n));
    }
}
