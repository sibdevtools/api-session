package com.github.simplemocks.session.api.rs;

import com.github.simplemocks.common.api.dto.ErrorRsDto;
import com.github.simplemocks.common.api.rs.StandardBodyRs;
import com.github.simplemocks.session.api.dto.SessionId;
import jakarta.annotation.Nonnull;

/**
 * Update session response
 *
 * @author sibmaks
 * @since 0.0.13
 */
public class UpdateSessionRs extends StandardBodyRs<SessionId> {

    /**
     * Construct update session response
     *
     * @param sessionId session id
     */
    public UpdateSessionRs(@Nonnull SessionId sessionId) {
        super(sessionId);
    }

    /**
     * Construct update session response with error
     *
     * @param error happened error
     */
    public UpdateSessionRs(@Nonnull ErrorRsDto error) {
        super(error);
    }
}
