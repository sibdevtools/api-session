package com.github.simple_mocks.session.api.service;

import com.github.simple_mocks.session.api.dto.Session;
import com.github.simple_mocks.session.api.dto.SessionId;
import com.github.simple_mocks.session.api.rq.CreateSessionRq;
import com.github.simple_mocks.session.api.rq.GetSessionAttributeNamesRq;
import com.github.simple_mocks.session.api.rq.GetSessionAttributeRq;
import com.github.simple_mocks.session.api.rq.UpdateSessionRq;
import jakarta.annotation.Nonnull;

import java.io.Serializable;
import java.util.Set;

/**
 * Session service, provide ability to get, create, update session.
 *
 * @author sibmaks
 * @since 0.0.1
 */
public interface SessionService {

    /**
     * Get session common info.<br/>
     * In case if session doesn't exist when null should be returned.
     *
     * @param sessionId session identifier
     * @return session or null
     */
    Session get(@Nonnull SessionId sessionId);

    /**
     * Get the last version of session common info.<br/>
     * In case if session doesn't exist when null should be returned.
     *
     * @param uid session uid
     * @return session or null
     */
    Session get(@Nonnull String uid);

    /**
     * Get attribute names from session's section.<br/>
     * In case if a section doesn't exist when null should be returned.<br/>
     * If session isn't found when "NOT_EXISTS" should be thrown.
     *
     * @param rq get attributes names request
     * @return attribute names
     */
    Set<String> getAttributeNames(@Nonnull GetSessionAttributeNamesRq rq);

    /**
     * Get attribute value from session.<br/>
     * In case if a section or attribute is not found, null should be returned.
     * If session isn't found when "NOT_EXISTS" should be thrown.
     *
     * @param rq  get request
     * @param <T> type of attribute
     * @return attribute value or null
     */
    <T extends Serializable> T getAttribute(@Nonnull GetSessionAttributeRq rq);

    /**
     * Create session with passed data.<br/>
     *
     * @param rq creation request
     * @return new session identifier
     */
    SessionId create(@Nonnull CreateSessionRq rq);

    /**
     * Update session by applying passed actions.<br/>
     * Method should apply actions transitionally, in case if some action can't be applied session state should be reset.<br/>
     * If session isn't found when "NOT_EXISTS" should be thrown.<br/>
     * If any of the sections are readonly when "READONLY" should be thrown.
     *
     * @param rq update request
     * @return new session identifier
     */
    SessionId update(@Nonnull UpdateSessionRq rq);
}
