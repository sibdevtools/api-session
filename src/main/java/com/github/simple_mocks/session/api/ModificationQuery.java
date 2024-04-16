package com.github.simple_mocks.session.api;

import com.github.simple_mocks.session.api.dto.action.Action;

import java.util.List;

/**
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
