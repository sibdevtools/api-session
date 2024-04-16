package com.github.simple_mocks.session.api.dto.action;

import lombok.Getter;

import java.io.Serializable;

/**
 * Action set attribute value in session.<br/>
 * In case if attribute doesn't exist when a new one should be created.<br/>
 * In case if attribute has the same value, when nothing should happen.
 *
 * @author sibmaks
 * @since 0.0.1
 */
@Getter
public final class SetAction extends Action {
    /**
     * Attribute value to set
     */
    private final Serializable attributeValue;
    /**
     * Add attribute if it doesn't exist
     */
    private final boolean addIfNotExists;

    /**
     * Construct action for change attribute value in section
     *
     * @param section           section code
     * @param attributeName     attribute name
     * @param attributeValue    attribute value
     * @param createIfNotExists whether to add an attribute if it doesn't exist
     */
    public SetAction(String section,
                     String attributeName,
                     Serializable attributeValue,
                     boolean createIfNotExists) {
        super(section, attributeName);
        this.attributeValue = attributeValue;
        this.addIfNotExists = createIfNotExists;
    }
}
