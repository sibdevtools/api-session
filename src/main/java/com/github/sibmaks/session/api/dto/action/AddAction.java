package com.github.sibmaks.session.api.dto.action;

import com.github.sibmaks.session.api.SessionErrors;
import lombok.Getter;

import java.io.Serializable;

/**
 * Action add new attribute in session.<br/>
 * If attribute already exists in section when {@link SessionErrors#ALREADY_EXISTS} should be thrown.
 *
 * @author sibmaks
 * @since 2023-04-14
 */
@Getter
public final class AddAction extends Action {
    private final Serializable attributeValue;

    public AddAction(String section, String attributeName, Serializable attributeValue) {
        super(section, attributeName);
        this.attributeValue = attributeValue;
    }
}
