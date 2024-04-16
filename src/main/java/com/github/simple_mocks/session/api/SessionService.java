package com.github.simple_mocks.session.api;

import com.github.simple_mocks.session.api.dto.Session;
import com.github.simple_mocks.session.api.dto.action.Action;
import com.github.simple_mocks.session.api.dto.action.DeleteAction;
import com.github.simple_mocks.session.api.dto.action.SetAction;

import java.io.Serializable;
import java.util.List;
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
    Session get(SessionId sessionId);

    /**
     * Get the last version of session common info.<br/>
     * In case if session doesn't exist when null should be returned.
     *
     * @param uid session uid
     * @return session or null
     */
    Session get(String uid);

    /**
     * Get attribute names from session's section.<br/>
     * In case if a section not exists when null should be returned.<br/>
     * If session isn't found when {@link SessionErrors#NOT_EXISTS} should be thrown.
     *
     * @param sessionId session identifier
     * @param section   section in session
     * @return attribute names
     */
    Set<String> getAttributeNames(SessionId sessionId, String section);

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
    <T extends Serializable> T getAttribute(SessionId sessionId, String section, String attribute);

    /**
     * Put attribute value into session's section<br/>
     * If session not found when {@link SessionErrors#NOT_EXISTS} should be thrown.<br/>
     * If a section is readonly when {@link SessionErrors#READONLY} should be thrown.
     *
     * @param sessionId session id
     * @param section   section in session
     * @param attribute attribute code
     * @param value     attribute value
     * @param <T>       type of attribute
     * @return new session identifier
     */
    default <T extends Serializable> SessionId putAttribute(
            SessionId sessionId,
            String section,
            String attribute,
            T value) {
        var action = new SetAction(section, attribute, value);
        return update(sessionId, List.of(action));
    }

    /**
     * Remove attribute value from session<br/>
     * If session not found when {@link SessionErrors#NOT_EXISTS} should be thrown.<br/>
     * If a section is readonly when {@link SessionErrors#READONLY} should be thrown.
     *
     * @param sessionId session id
     * @param section   section in session
     * @param attribute attribute code
     * @return new session identifier
     */
    default SessionId removeAttribute(SessionId sessionId, String section, String attribute) {
        var action = new DeleteAction(section, attribute);
        return update(sessionId, List.of(action));
    }

    /**
     * Update session by applying passed actions.<br/>
     * Method should apply actions transitionally, in case if some action can't be applied session state should be reset.<br/>
     * If session isn't found when {@link SessionErrors#NOT_EXISTS} should be thrown.<br/>
     * If any of sections are readonly when {@link SessionErrors#READONLY} should be thrown.
     *
     * @param sessionId session id
     * @param actions   actions
     * @return new session identifier
     */
    SessionId update(SessionId sessionId, List<? extends Action> actions);
}
