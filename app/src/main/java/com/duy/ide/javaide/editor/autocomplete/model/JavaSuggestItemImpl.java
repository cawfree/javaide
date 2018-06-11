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


import com.android.annotations.NonNull;
import com.duy.ide.code.api.SuggestItem;
import com.duy.ide.editor.internal.suggestion.Editor;

/**
 * Created by Duy on 21-Jul-17.
 */

public abstract class JavaSuggestItemImpl implements SuggestItem {
    public static final int FIELD_DESC = 0;
    public static final int METHOD_DESC = 1;
    public static final int CLASS_DESC = 2;
    public static final int OTHER_DESC = 3;

    protected long lastUsed;
    private Editor editor;
    private String incomplete;

    @Override
    public int getSuggestionPriority() {
        return OTHER_DESC;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public String getIncomplete() {
        return incomplete;
    }

    public void setIncomplete(@NonNull String incomplete) {
        this.incomplete = incomplete;
    }
}
