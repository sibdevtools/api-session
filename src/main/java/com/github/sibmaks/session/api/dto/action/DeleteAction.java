package com.github.sibmaks.session.api.dto.action;

/**
 * Action delete attribute from session.<br/>
 * In case if attribute not exists, nothing happened
 *
 * @author sibmaks
 * @since 2023-04-14
 */
public final class DeleteAction extends Action {

    public DeleteAction(String section, String attributeName) {
        super(section, attributeName);
    }
}
