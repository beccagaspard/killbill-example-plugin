package com.example;

import org.killbill.billing.osgi.api.OSGIPluginProperties;
import org.killbill.billing.osgi.libs.killbill.KillbillActivatorBase;
import org.killbill.billing.plugin.core.resources.jooby.PluginApp;
import org.killbill.billing.plugin.core.resources.jooby.PluginAppBuilder;
import org.osgi.framework.BundleContext;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;

import java.util.Hashtable;

import static org.osgi.service.log.LogService.LOG_INFO;

public class ExampleActivator extends KillbillActivatorBase {

    public static final String PLUGIN_NAME = "killbill-example-plugin";

    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);

        logService.log(LOG_INFO, "Starting " + PLUGIN_NAME);

        final PluginApp pluginApp = new PluginAppBuilder(PLUGIN_NAME,
                killbillAPI,
                logService,
                dataSource,
                super.clock,
                configProperties)
                .withRouteClass(ExampleServlet.class)
                .build();

        final HttpServlet httpServlet = PluginApp.createServlet(pluginApp);
        registerServlet(context, httpServlet);
    }

    private void registerServlet(final BundleContext context, final HttpServlet servlet) {
        final Hashtable<String, String> props = new Hashtable<String, String>();
        props.put(OSGIPluginProperties.PLUGIN_NAME_PROP, PLUGIN_NAME);
        registrar.registerService(context, Servlet.class, servlet, props);
    }

}
