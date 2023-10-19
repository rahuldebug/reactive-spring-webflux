package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {
    public Flux<String> nameFlux() {
        return Flux.fromIterable(List.of("rahul", "manas", "pillu", "papa"));
    }

    public Mono<String> nameMono() {
        return Mono.just("mono");
    }

    public Flux<String> nameFluxMap() {
        return Flux.fromIterable(List.of("rahul", "manas", "pillu", "papa"))
                .map(String::toUpperCase);
    }

    public Flux<String> nameFluxImmutability() {
        var immutableFlux = Flux.fromIterable(List.of("rahul", "manas", "pillu", "papa"));
        immutableFlux.map(String::toUpperCase);
        return immutableFlux;
    }

    public Flux<String> multipleOperations(int len) {
        return Flux.fromIterable(List.of("rahul", "manas", "pillu", "papa")).
                map(String::toUpperCase).
                filter(n -> n.length() > len);
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
        fluxAndMonoGeneratorService.nameFlux().subscribe(n -> System.out.println(n));
        fluxAndMonoGeneratorService.nameMono().subscribe(n -> System.out.println(n));
        fluxAndMonoGeneratorService.nameFluxMap().subscribe(n -> System.out.println(n));
        fluxAndMonoGeneratorService.nameFluxImmutability().subscribe(n -> System.out.println(n));
        fluxAndMonoGeneratorService.multipleOperations(3).subscribe(n-> System.out.println(n));
    }
}
