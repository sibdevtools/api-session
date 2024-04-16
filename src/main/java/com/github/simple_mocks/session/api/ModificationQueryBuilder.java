package com.github.simple_mocks.session.api;

import com.github.simple_mocks.session.api.dto.action.Action;
import com.github.simple_mocks.session.api.dto.action.DeleteAction;
import com.github.simple_mocks.session.api.dto.action.SetAction;
import com.github.simple_mocks.session.api.impl.ModificationQueryImpl;
import jakarta.annotation.Nonnull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sibmaks
 * @since 0.0.6
 */
public final class ModificationQueryBuilder {
    private final List<Action> actions;

    private ModificationQueryBuilder(Action action) {
        this.actions = new ArrayList<>();
        this.actions.add(action);
    }

    /**
     * Create builder instance of {@link ModificationQueryBuilder}
     *
     * @param action 1st action
     * @param <T>    type of action
     * @return instance of {@link ModificationQueryBuilder}
     */
    public static <T extends Action> ModificationQueryBuilder builder(T action) {
        return new ModificationQueryBuilder(action);
    }

    /**
     * Build modification query
     *
     * @return instance of {@link ModificationQuery}
     */
    public ModificationQuery build() {
        return new ModificationQueryImpl(Collections.unmodifiableList(actions));
    }

    /**
     * Add put attribute value action<br/>
     *
     * @param section   section in session
     * @param attribute attribute code
     * @param value     attribute value
     * @param <T>       type of attribute
     * @return self reference
     */
    public <T extends Serializable> ModificationQueryBuilder putAttribute(@Nonnull String section,
                                                                          @Nonnull String attribute,
                                                                          T value) {
        var action = new SetAction(section, attribute, value);
        this.actions.add(action);
        return this;
    }

    /**
     * Add remove attribute action<br/>
     *
     * @param section   section in session
     * @param attribute attribute code
     * @return self reference
     */
    public ModificationQueryBuilder removeAttribute(@Nonnull String section,
                                                    @Nonnull String attribute) {
        var action = new DeleteAction(section, attribute);
        this.actions.add(action);
        return this;
    }


}
