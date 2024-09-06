package com.github.simple_mocks.session.api.dto;

import java.util.Set;

/**
 * Session description, the base session consists from:
 * - id - some unique identifier.
 * - owner type - session can be created not only for some users, but for services too.
 * - owner id - service or user identifier.
 * - sections - set of section names created in session.
 *
 * @author sibmaks
 * @since 0.0.1
 */
public interface Session {
    /**
     * Session identifier
     *
     * @return session id
     */
    SessionId getId();

    /**
     * Session owner type.<br/>
     * Session can belong to user or service
     *
     * @return session owner type
     */
    SessionOwnerType getOwnerType();

    /**
     * Session owner id.<br/>
     * Unique identifier of the owner in the cut {@link SessionOwnerType}
     *
     * @return session owner id
     */
    String getOwnerId();

    /**
     * Session sections that current service allow to access
     *
     * @return set of sections
     */
    Set<String> getSections();

    /**
     * Session owner permission list.
     *
     * @return set of permissions
     */
    Set<String> getPermissions();
}
