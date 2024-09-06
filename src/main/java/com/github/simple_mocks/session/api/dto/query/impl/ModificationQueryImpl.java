package com.github.simple_mocks.session.api.dto.query.impl;

import com.github.simple_mocks.session.api.dto.query.ModificationQuery;
import com.github.simple_mocks.session.api.dto.query.action.Action;

import java.util.List;

/**
 * ModificationQuery implementation
 *
 * @param actions list of actions which should be executed in session
 * @author sibmaks
 * @since 0.0.6
 */
public record ModificationQueryImpl(List<Action> actions) implements ModificationQuery {
}
