package com.github.simple_mocks.session.api.impl;

import com.github.simple_mocks.session.api.ModificationQuery;
import com.github.simple_mocks.session.api.dto.action.Action;

import java.util.List;

/**
 * @author sibmaks
 * @since 0.0.6
 */
public record ModificationQueryImpl(List<Action> actions) implements ModificationQuery {
}
