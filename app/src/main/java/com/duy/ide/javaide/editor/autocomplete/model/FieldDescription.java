/*
 * Copyright (C) 2018 Tran Le Duy
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.duy.ide.javaide.editor.autocomplete.model;

import android.support.annotation.NonNull;

import com.duy.ide.editor.view.IEditAreaView;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Duy on 20-Jul-17.
 */

public class FieldDescription extends JavaSuggestItemImpl implements Member {
    private String name, type;
    private int modifiers;
    private String value;

    public FieldDescription(String name, String type, int modifiers) {
        this.name = name;
        this.type = type;
        this.modifiers = modifiers;
    }

    public FieldDescription(Field field) {
        this.name = field.getName();
        this.type = field.getType().getName();
        this.modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers)) {
            try {
                value = field.get(null).toString();
            } catch (Exception ignored) {
            }
        }
    }
    @Override
    public void onSelectThis(@NonNull IEditAreaView iEditAreaView) {

    }
    @Override
    public char getTypeHeader() {
        return 'f'; //field
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return value;
    }

    @Override
    public String getReturnType() {
        return type;
    }

    @Override
    public int getSuggestionPriority() {
        return JavaSuggestItemImpl.FIELD_DESC;
    }

    @Override
    public int getModifiers() {
        return modifiers;
    }

    @Override
    public String toString() {
        return name;
    }
}
