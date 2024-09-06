package com.github.simple_mocks.session.api;

import com.github.simple_mocks.session.api.dto.query.action.Action;
import com.github.simple_mocks.session.api.dto.query.action.AddAction;
import com.github.simple_mocks.session.api.dto.query.action.DeleteAction;
import com.github.simple_mocks.session.api.dto.query.action.SetAction;
import com.github.simple_mocks.session.api.dto.query.impl.ModificationQueryImpl;
import com.github.simple_mocks.session.api.dto.query.ModificationQuery;
import jakarta.annotation.Nonnull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Modifiable query builder.
 *
 * @author sibmaks
 * @since 0.0.6
 */
public final class ModificationQueryBuilder {
    private final List<Action> actions;

    private ModificationQueryBuilder() {
        this.actions = new ArrayList<>();
    }

    /**
     * Create builder instance of {@link ModificationQueryBuilder}
     *
     * @return instance of {@link ModificationQueryBuilder}
     */
    public static ModificationQueryBuilder builder() {
        return new ModificationQueryBuilder();
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
     * Add create attribute action<br/>
     *
     * @param section   section in session
     * @param attribute attribute code
     * @param value     attribute value
     * @param <T>       type of attribute
     * @return self reference
     */
    public <T extends Serializable> ModificationQueryBuilder create(@Nonnull String section,
                                                                    @Nonnull String attribute,
                                                                    T value) {
        var action = new AddAction(section, attribute, value);
        this.actions.add(action);
        return this;
    }

    /**
     * Add change attribute value action<br/>
     *
     * @param section   section in session
     * @param attribute attribute code
     * @param value     attribute value
     * @param <T>       type of attribute
     * @return self reference
     */
    public <T extends Serializable> ModificationQueryBuilder change(@Nonnull String section,
                                                                    @Nonnull String attribute,
                                                                    T value) {
        var action = new SetAction(section, attribute, value, false);
        this.actions.add(action);
        return this;
    }

    /**
     * Add create or change attribute value action<br/>
     *
     * @param section   section in session
     * @param attribute attribute code
     * @param value     attribute value
     * @param <T>       type of attribute
     * @return self reference
     */
    public <T extends Serializable> ModificationQueryBuilder createOrChange(@Nonnull String section,
                                                                            @Nonnull String attribute,
                                                                            T value) {
        var action = new SetAction(section, attribute, value, true);
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
    public ModificationQueryBuilder remove(@Nonnull String section,
                                           @Nonnull String attribute) {
        var action = new DeleteAction(section, attribute);
        this.actions.add(action);
        return this;
    }


}
