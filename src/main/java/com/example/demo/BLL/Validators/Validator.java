package com.example.demo.BLL.Validators;

/**
 * The interface Validator.
 *
 * @param <T> the type parameter
 */
public interface Validator<T> {
    /**
     * Validate boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean validate(T t);
}
