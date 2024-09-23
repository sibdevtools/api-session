package com.github.sibdevtools.session.api.rq;

import com.github.sibdevtools.session.api.dto.SessionId;
import jakarta.annotation.Nonnull;
import lombok.Builder;

/**
 * Session get attribute request
 *
 * @param sessionId session identifier
 * @param section   section in session
 * @param attribute attribute code
 * @author sibmaks
 * @since 0.0.12
 */
@Builder
public record GetSessionAttributeRq(
        @Nonnull SessionId sessionId,
        @Nonnull String section,
        @Nonnull String attribute
) {
}
