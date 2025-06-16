package com.prayerbot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@RequiredArgsConstructor
public class PrayerbotApplication {
	private final PrayerBot prayerBot;

	public static void main(String[] args) {
		SpringApplication.run(PrayerbotApplication.class, args);
	}


	@PostConstruct
	public void init() throws Exception {
		TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
		api.registerBot(prayerBot);
	}

}
