package com.prayerbot;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getBotName() {
        return dotenv.get("BOT_USERNAME");
    }

    public static String getBotToken() {
        return dotenv.get("BOT_TOKEN");
    }
}
