package com.github.sibmaks.session.api;

import com.github.sibmaks.session.api.dto.Session;
import com.github.sibmaks.session.api.dto.action.Action;
import com.github.sibmaks.session.api.dto.action.DeleteAction;
import com.github.sibmaks.session.api.dto.action.SetAction;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author sibmaks
 * @since 2023-04-11
 */
public interface SessionService {

    /**
     * Get session common info.<br/>
     * In case if session not exists when null should be returned.
     *
     * @param sessionId session identifier
     * @return session or null
     */
    Session get(SessionId sessionId);

    /**
     * Get the last version of session common info.<br/>
     * In case if session not exists when null should be returned.
     *
     * @param uid session uid
     * @return session or null
     */
    Session get(String uid);

    /**
     * Get attribute names from session's section.<br/>
     * In case if section not exists when null should be returned.<br/>
     * If session not found when {@link SessionErrors#NOT_EXISTS} should be thrown.
     *
     * @param sessionId session identifier
     * @param section section in session
     * @return attribute names
     */
    Set<String> getAttributeNames(SessionId sessionId, String section);

    /**
     * Get attribute value from session.<br/>
     * In case if section or attribute not found null should be returned.
     * If session not found when {@link SessionErrors#NOT_EXISTS} should be thrown.
     *
     * @param sessionId session identifier
     * @param section section in session
     * @param attribute attribute code
     * @return attribute value or null
     * @param <T> type of attribute
     */
    <T extends Serializable> T getAttribute(SessionId sessionId, String section, String attribute);

    /**
     * Put attribute value into session's section<br/>
     * If session not found when {@link SessionErrors#NOT_EXISTS} should be thrown.<br/>
     * If section is readonly when {@link SessionErrors#READONLY} should be thrown.
     *
     * @param sessionId session id
     * @param section section in session
     * @param attribute attribute code
     * @param value attribute value
     * @param <T> type of attribute
     */
    default <T extends Serializable> void putAttribute(SessionId sessionId, String section, String attribute, T value) {
        var action = new SetAction(section, attribute, value);
        update(sessionId, Collections.singletonList(action));
    }

    /**
     * Remove attribute value from session<br/>
     * If session not found when {@link SessionErrors#NOT_EXISTS} should be thrown.<br/>
     * If section is readonly when {@link SessionErrors#READONLY} should be thrown.
     *
     * @param sessionId session id
     * @param section section in session
     * @param attribute attribute code
     */
    default void removeAttribute(SessionId sessionId, String section, String attribute) {
        var action = new DeleteAction(section, attribute);
        update(sessionId, Collections.singletonList(action));
    }

    /**
     * Update session by applying passed actions.<br/>
     * Method should apply actions transitionally, in case if some action can't be applied session state should be reset.<br/>
     * If session not found when {@link SessionErrors#NOT_EXISTS} should be thrown.<br/>
     * If any of sections are readonly when {@link SessionErrors#READONLY} should be thrown.
     *
     * @param sessionId session id
     * @param actions actions
     */
    void update(SessionId sessionId, List<? extends Action> actions);
}
