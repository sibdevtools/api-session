package com.github.simple_mocks.session.api.rq;

import com.github.simple_mocks.session.api.dto.SessionId;
import com.github.simple_mocks.session.api.dto.query.ModificationQuery;
import jakarta.annotation.Nonnull;
import lombok.Builder;

/**
 * Session updating request
 *
 * @param sessionId         session id
 * @param modificationQuery query to modify session
 * @author sibmaks
 * @since 0.0.12
 */
@Builder
public record UpdateSessionRq(
        @Nonnull SessionId sessionId,
        @Nonnull ModificationQuery modificationQuery
) {
}
