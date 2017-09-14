package ru.sbt;

import ru.sbt.module.loader.ModuleLoader;
import ru.sbt.plugin.Plugin;


public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {

        this.pluginRootDirectory = pluginRootDirectory;
    }


    public Plugin load(String pluginName, String pluginClassName, String key) throws Exception {

        ModuleLoader loader = new ModuleLoader(this.pluginRootDirectory, ClassLoader.getSystemClassLoader(), key);

        Class clazz = loader.loadClass(pluginClassName);
        Plugin execute = (Plugin) clazz.newInstance();

        return execute;
    }

}
