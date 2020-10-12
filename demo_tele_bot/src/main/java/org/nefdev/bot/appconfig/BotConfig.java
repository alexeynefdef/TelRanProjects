package org.nefdev.bot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.nefdev.bot.MyDemoTeleBot;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {

    private String webHookPath;
    private String botUsername;
    private String botToken;

    private DefaultBotOptions.ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;

    @Bean
    public MyDemoTeleBot MyDemoTelegramBot() {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);

        options.setProxyHost(proxyHost);
        options.setProxyPort(proxyPort);
        options.setProxyType(proxyType);

        MyDemoTeleBot myDemoTeleBot = new MyDemoTeleBot(options);
        myDemoTeleBot.setBotUsername(botUsername);
        myDemoTeleBot.setBotToken(botToken);
        myDemoTeleBot.setWebHookPath(webHookPath);

        return myDemoTeleBot;
    }
}
