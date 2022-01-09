package com.example.businessrulesEngine.pipeline;

/**
 * the type pipeline.
 * @param <I> the type parameter
 * @param <O> the type parameter
 */
public class Pipeline<I,O> {
    private final Handler<I,O> currentHandler;

    public Pipeline(Handler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

    /**
     * add handler pipeline.
     * @param newHandler the new handler
     * @param <K> the type parameter
     * @return return pipeline
     */
    public <K> Pipeline<I, K> addHandler(Handler<O, K> newHandler) {
        return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
    }

    public O execute(I input) {
        return currentHandler.process(input);
    }

}
