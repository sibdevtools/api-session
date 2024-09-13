package com.github.simplemocks.session.api.rs;

import com.github.simplemocks.common.api.dto.ErrorRsDto;
import com.github.simplemocks.common.api.rs.StandardBodyRs;
import com.github.simplemocks.session.api.dto.Session;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Get session response
 *
 * @author sibmaks
 * @since 0.0.13
 */
public class GetSessionRs extends StandardBodyRs<Session> {

    /**
     * Construct get session response
     *
     * @param session session instance
     */
    public GetSessionRs(@Nullable Session session) {
        super(session);
    }

    /**
     * Construct get session response with error
     *
     * @param error happened error
     */
    public GetSessionRs(@Nonnull ErrorRsDto error) {
        super(error);
    }
}
