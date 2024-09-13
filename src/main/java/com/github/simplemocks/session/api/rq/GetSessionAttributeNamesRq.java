package com.github.simplemocks.session.api.rq;

import com.github.simplemocks.session.api.dto.SessionId;
import jakarta.annotation.Nonnull;
import lombok.Builder;

/**
 * Session get attribute names request
 *
 * @param sessionId session identifier
 * @param section   section in session
 * @author sibmaks
 * @since 0.0.12
 */
@Builder
public record GetSessionAttributeNamesRq(
        @Nonnull SessionId sessionId,
        @Nonnull String section
) {
}
