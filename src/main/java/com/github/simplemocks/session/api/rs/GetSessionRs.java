package com.github.simplemocks.session.api.rs;

import com.github.simplemocks.common.api.rs.StandardBodyRs;
import com.github.simplemocks.session.api.dto.Session;
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
}
