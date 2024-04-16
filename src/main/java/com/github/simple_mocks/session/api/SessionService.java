package com.github.simple_mocks.session.api;

import com.github.simple_mocks.session.api.dto.Session;
import com.github.simple_mocks.session.api.dto.SessionOwnerType;
import jakarta.annotation.Nonnull;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
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
     * If session isn't found when {@link SessionErrors#NOT_EXISTS} should be thrown.
     *
     * @param sessionId session identifier
     * @param section   section in session
     * @return attribute names
     */
    Set<String> getAttributeNames(@Nonnull SessionId sessionId,
                                  @Nonnull String section);

    /**
     * Get attribute value from session.<br/>
     * In case if a section or attribute is not found, null should be returned.
     * If session isn't found when {@link SessionErrors#NOT_EXISTS} should be thrown.
     *
     * @param sessionId session identifier
     * @param section   section in session
     * @param attribute attribute code
     * @param <T>       type of attribute
     * @return attribute value or null
     */
    <T extends Serializable> T getAttribute(@Nonnull SessionId sessionId,
                                            @Nonnull String section,
                                            @Nonnull String attribute);

    /**
     * Create session with passed data.<br/>
     *
     * @param sections    shared sections data
     * @param ownerType   session owner type
     * @param ownerId     session owner id
     * @param permissions list of user permissions
     * @return new session identifier
     */
    SessionId create(@Nonnull Map<String, Map<String, Serializable>> sections,
                     @Nonnull SessionOwnerType ownerType,
                     @Nonnull String ownerId,
                     @Nonnull List<String> permissions);

    /**
     * Update session by applying passed actions.<br/>
     * Method should apply actions transitionally, in case if some action can't be applied session state should be reset.<br/>
     * If session isn't found when {@link SessionErrors#NOT_EXISTS} should be thrown.<br/>
     * If any of sections are readonly when {@link SessionErrors#READONLY} should be thrown.
     *
     * @param sessionId         session id
     * @param modificationQuery query to modify session
     * @return new session identifier
     */
    SessionId update(@Nonnull SessionId sessionId,
                     @Nonnull ModificationQuery modificationQuery);
}
