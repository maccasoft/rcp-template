/*
 * Copyright (c) 2015 Marco Maccaferri and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marco Maccaferri - initial API and implementation
 */

package com.maccasoft.ui.internal.actions;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.RetargetAction;

/**
 * Retargettable action used to open a view-specific settings dialog.
 *
 * @since 1.0
 */
public class SettingsAction extends RetargetAction {

    public SettingsAction(IWorkbenchWindow window) {
        super("settings", "Settings...");
        window.getPartService().addPartListener(this);
        setActionDefinitionId("org.eclipse.ui.edit.settings"); //$NON-NLS-1$
    }
}
