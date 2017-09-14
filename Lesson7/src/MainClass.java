import ru.sbt.PluginManager;


public class MainClass {
    public static void main(String[] args) throws Exception {
        String pluginsDir = System.getProperty("user.dir") + "/pluginRootDirectory/pluginName/";
        System.out.println(pluginsDir);
        PluginManager man = new PluginManager(pluginsDir);
        man.load("Bean.class", "Bean", "3");
    }
}
