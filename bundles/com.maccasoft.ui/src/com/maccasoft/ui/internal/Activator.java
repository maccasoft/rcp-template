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

package com.maccasoft.ui.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "com.maccasoft.ui";

    private static BundleContext bundleContext;
    private static Activator instance;

    public Activator() {
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

    public static BundleContext getContext() {
        return bundleContext;
    }

    public static Activator getDefault() {
        return instance;
    }

    public static ImageDescriptor getImageDescriptor(String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    public static void log(IStatus status) {
        if (instance != null) {
            instance.getLog().log(status);
        }
        else {
            System.err.println(status);
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
