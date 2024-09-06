package com.github.simple_mocks.session.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sibmaks
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
class SessionIdImpl implements SessionId {
    private final String uID;
    private final long version;
}
