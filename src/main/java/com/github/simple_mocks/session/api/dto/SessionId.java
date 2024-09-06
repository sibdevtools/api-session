package com.github.simple_mocks.session.api.dto;

/**
 * Session identifier
 *
 * @author sibmaks
 * @since 0.0.1
 */
public interface SessionId {

    /**
     * Session unique identifier
     *
     * @return unique identifier
     */
    String getUID();

    /**
     * Version of session. Version is incremental.
     *
     * @return version
     */
    long getVersion();

    /**
     * Check is the session identifiers same or not.<br/>
     * By default, a session version should not affect checking.
     *
     * @param sessionId session identifier
     * @return true - session the same, false - otherwise
     */
    default boolean same(SessionId sessionId) {
        if (sessionId == null) {
            return false;
        }
        var uid = getUID();
        var otherUID = sessionId.getUID();
        return uid.equals(otherUID);
    }

    /**
     * Create default instance of session id
     *
     * @param uid     session uid
     * @param version session version
     * @return session identifier
     */
    static SessionId of(String uid, long version) {
        return new SessionIdImpl(uid, version);
    }
}
