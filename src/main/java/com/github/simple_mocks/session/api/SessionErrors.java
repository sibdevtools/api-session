package com.github.simple_mocks.session.api;

import com.github.simple_mocks.error_service.exception.ServiceError;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;

/**
 * @author sibmaks
 * @since 0.0.1
 */
@AllArgsConstructor
public enum SessionErrors implements ServiceError {
    /**
     * Session does not exist
     */
    NOT_EXISTS,
    /**
     * Session section is readonly
     */
    READONLY,
    /**
     * Attribute already exists in the section
     */
    ALREADY_EXISTS;


    @Nonnull
    @Override
    public String getErrorCode() {
        return name();
    }

    @Nonnull
    @Override
    public String getSystemCode() {
        return "SESSION";
    }
}
