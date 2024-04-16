package com.github.simple_mocks.session.api.dto.action;

import lombok.*;

import java.io.Serializable;

/**
 * Common action, what can be applied to session.<br/>
 * Any action affecting some section and attribute in it.
 *
 * @author sibmaks
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public sealed class Action implements Serializable permits AddAction, DeleteAction, SetAction {
    /**
     * The name of the section
     */
    private final String section;
    /**
     * Attribute name
     */
    private final String attributeName;
}
