package com.github.simplemocks.session.api.rs;

import com.github.simplemocks.common.api.rs.StandardBodyRs;
import jakarta.annotation.Nullable;

import java.io.Serializable;

/**
 * Get attribute response
 *
 * @author sibmaks
 * @since 0.0.13
 */
public class GetSessionAttributeRs<T extends Serializable> extends StandardBodyRs<T> {

    /**
     * Construct get attribute response
     *
     * @param attribute attribute value
     */
    public GetSessionAttributeRs(@Nullable T attribute) {
        super(attribute);
    }
}
