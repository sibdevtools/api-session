package com.github.simplemocks.session.api.rs;

import com.github.simplemocks.common.api.dto.ErrorRsDto;
import com.github.simplemocks.common.api.rs.StandardBodyRs;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Get attribute names response
 *
 * @author sibmaks
 * @since 0.0.13
 */
public class GetAttributeNamesRs extends StandardBodyRs<HashSet<String>> {

    /**
     * Construct get attribute names response
     *
     * @param attributeNames attribute names
     */
    public GetAttributeNamesRs(@Nullable Set<String> attributeNames) {
        super(
                Optional.ofNullable(attributeNames)
                        .map(HashSet::new)
                        .orElseGet(HashSet::new)
        );
    }

    /**
     * Construct get attribute names response with error
     *
     * @param error happened error
     */
    public GetAttributeNamesRs(@Nonnull ErrorRsDto error) {
        super(error);
    }
}
