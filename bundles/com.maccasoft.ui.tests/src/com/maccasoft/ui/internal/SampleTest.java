/*
 * Copyright (c) 2022 Marco Maccaferri and others.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package com.maccasoft.ui.internal;

import static org.junit.Assert.assertEquals;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SampleTest {

    Display display;
    Shell shell;

    @Before
    public void setUp() throws Exception {
        display = Display.getDefault();
        shell = new Shell(display);
    }

    @After
    public void tearDown() throws Exception {
        while (display.readAndDispatch()) {

        }
        shell.dispose();
        while (display.readAndDispatch()) {

        }
        display.dispose();
    }

    @Test
    public void test() {
        Label label = new Label(shell, SWT.NONE);
        label.setText("Label");
        assertEquals("Label", label.getText());
    }

}
