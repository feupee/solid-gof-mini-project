package com.felipe.solidgof.config;

/**
 * Singleton: a single, globally accessible configuration object.
 * Keep it minimal; in real systems prefer dependency injection for configurables.
 */
public final class AppConfig {
    private static volatile AppConfig instance;

    private final String environment;

    private AppConfig() {
        this.environment = System.getenv().getOrDefault("APP_ENV", "dev");
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public String environment() {
        return environment;
    }
}
