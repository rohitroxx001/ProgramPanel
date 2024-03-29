package com.programpanel.application.plugin;

import com.programpanel.domain.plugin.entity.Plugin;

/**
 * Manages the plugin lifecycle.
 */
public interface PluginManager {
    void load(Plugin plugin);

    void unload(Plugin plugin);
}
