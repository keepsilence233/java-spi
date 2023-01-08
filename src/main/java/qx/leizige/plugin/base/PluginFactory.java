package qx.leizige.plugin.base;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class PluginFactory {

    public void installPlugins() {
        Map<String, Object> context = new LinkedHashMap<>();
        ServiceLoader<Plugin> serviceLoader = ServiceLoader.load(Plugin.class);
        Iterator<Plugin> pluginIterator = serviceLoader.iterator();
        while (pluginIterator.hasNext()) {
            Plugin plugin = pluginIterator.next();
            plugin.install(context);
        }
    }


    public static void main(String[] args) {
        new PluginFactory().installPlugins();
    }
}
