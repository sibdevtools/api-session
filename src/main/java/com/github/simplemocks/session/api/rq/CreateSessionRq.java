package com.github.simplemocks.session.api.rq;

import com.github.simplemocks.session.api.dto.SessionOwnerType;
import jakarta.annotation.Nonnull;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Session creation request
 *
 * @param sections    shared sections data
 * @param ownerType   session owner type
 * @param ownerId     session owner id
 * @param permissions list of user permissions
 * @author sibmaks
 * @since 0.0.12
 */
@Builder
public record CreateSessionRq(
        @Nonnull Map<String, Map<String, Serializable>> sections,
        @Nonnull SessionOwnerType ownerType,
        @Nonnull String ownerId,
        @Nonnull List<String> permissions
) {
}
