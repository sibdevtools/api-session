package com.github.simple_mocks.session.api.dto.action;

/**
 * Action delete attribute from session.<br/>
 * In case if attribute doesn't exist, nothing happened
 *
 * @author sibmaks
 * @since 0.0.1
 */
public final class DeleteAction extends Action {

    /**
     * Construct action for deleting attribute from a section
     *
     * @param section        section code
     * @param attributeName  attribute name
     */
    public DeleteAction(String section, String attributeName) {
        super(section, attributeName);
    }
}
