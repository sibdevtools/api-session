package com.github.sibmaks.session.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sibmaks
 * @since 2023-04-22
 */
@Getter
@AllArgsConstructor
class SessionIdImpl implements SessionId {
    private final String uID;
    private final long version;
}
