import ru.sbt.PluginManager;
import ru.sbt.plugin.Plugin;


public class MainClass {
    public static void main(String[] args) throws Exception {
        String pluginsDir = System.getProperty("user.dir") + "/pluginRootDirectory/pluginName/";
        System.out.println(pluginsDir);
        PluginManager man = new PluginManager(pluginsDir);
        Plugin t = man.load("Bean.class", "Bean", "3");
    }
}
