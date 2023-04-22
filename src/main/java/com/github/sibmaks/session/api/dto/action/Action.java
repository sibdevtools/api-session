package com.github.sibmaks.session.api.dto.action;

import lombok.*;

import java.io.Serializable;

/**
 * Common action, what can be applied to session.<br/>
 * Any action affect some section and attribute in it.
 *
 * @author sibmaks
 * @since 2023-04-14
 */
@Getter
@AllArgsConstructor
public sealed class Action implements Serializable permits AddAction, DeleteAction, SetAction {
    private final String section;
    private final String attributeName;
}
