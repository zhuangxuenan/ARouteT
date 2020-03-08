package com.king.commonlib.base.mvvm.binding.command;


/**
 * Represents a function with zero arguments.
 *
 * @param <T> the result type
 */
public interface BindingFunction<T> {
    T call();
}
