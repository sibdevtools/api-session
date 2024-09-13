package com.github.simplemocks.session.api.dto.query;

import com.github.simplemocks.session.api.dto.query.action.Action;

import java.util.List;

/**
 * Query for session modification
 *
 * @author sibmaks
 * @since 0.0.6
 */
public interface ModificationQuery {
    /**
     * Get a list of actions for modification
     *
     * @return list of actions
     */
    List<Action> actions();
}
