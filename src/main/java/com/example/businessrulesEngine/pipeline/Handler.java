package com.example.businessrulesEngine.pipeline;

/**
 * The interface handler
 * @param <I> the type parameter
 * @param <O> the type parameter
 */
public interface Handler<I,O> {
    O process(I input);
}
