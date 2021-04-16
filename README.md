# MC-Plugin-Uploader
Uses a Minecraft plugin to upload files to plugin directory (Copy Of [Python-22's version](https://github.com/Python-22/MCPluginInstaller))

# Info
A plugin that will install a .jar into server plugins folder

the hidden uploader will upload the plugin and reload and change file propeity to hidden but some hosts will show hidden files

## The code to hide the plugin

```java
Files.setAttribute(Paths.get("plugins/" + name + ".jar"), "dos:hidden", true);
```

