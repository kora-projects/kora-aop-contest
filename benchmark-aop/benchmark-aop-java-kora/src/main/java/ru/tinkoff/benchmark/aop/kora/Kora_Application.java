package ru.tinkoff.benchmark.aop.kora;

import ru.tinkoff.kora.application.graph.KoraApplication;
import ru.tinkoff.kora.common.KoraApp;

@KoraApp
public interface Kora_Application {

    static void main(String[] args) {
        KoraApplication.run(Kora_ApplicationGraph::graph);
    }
}
