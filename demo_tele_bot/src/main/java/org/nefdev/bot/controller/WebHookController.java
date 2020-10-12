package org.nefdev.bot.controller;

import org.nefdev.bot.MyDemoTeleBot;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookController {

    private final MyDemoTeleBot teleBot;

    public WebHookController(MyDemoTeleBot teleBot) {
        this.teleBot = teleBot;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return teleBot.onWebhookUpdateReceived(update);
    }
}
