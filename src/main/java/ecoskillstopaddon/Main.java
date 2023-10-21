package ecoskillstopaddon;


import ecoskillstopaddon.papi.PAPI_Hook;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new PAPI_Hook().register();
    }

}
