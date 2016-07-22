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

package com.maccasoft.core.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

    public static final String PLUGIN_ID = "com.maccasoft.core";

    private static BundleContext bundleContext;
    private static Activator instance;

    public static BundleContext getContext() {
        return bundleContext;
    }

    public static Activator getDefault() {
        return instance;
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        bundleContext = context;
        instance = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        bundleContext = null;
        instance = null;
        super.stop(context);
    }

    public static void log(IStatus status) {
        if (instance == null) {
            if (status.getException() != null) {
                status.getException().printStackTrace();
            }
        }
        else {
            instance.getLog().log(status);
        }
    }

    public static void log(String message, Throwable throwable) {
        Status status = new Status(IStatus.ERROR, PLUGIN_ID, message, throwable);
        if (instance != null) {
            instance.getLog().log(status);
        }
        else {
            System.err.println(status);
        }
    }
}
