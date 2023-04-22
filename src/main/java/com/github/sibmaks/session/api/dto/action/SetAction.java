package com.github.sibmaks.session.api.dto.action;

import lombok.Getter;

import java.io.Serializable;

/**
 * Action set attribute value in session.<br/>
 * In case if attribute not exists when a new one should be created.<br/>
 * In case if attribute has the same value, when nothing should happen.
 *
 * @author sibmaks
 * @since 2023-04-14
 */
@Getter
public final class SetAction extends Action {
    private final Serializable attributeValue;

    public SetAction(String section, String attributeName, Serializable attributeValue) {
        super(section, attributeName);
        this.attributeValue = attributeValue;
    }
}
