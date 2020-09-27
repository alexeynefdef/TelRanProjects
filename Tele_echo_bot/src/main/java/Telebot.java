import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Telebot extends TelegramLongPollingBot {

    public static void main(String[] args) {

        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Telebot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage()
                    .enableMarkdown(true)
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText())
                    .setReplyToMessageId(update.getMessage().getMessageId())
                    .setText("So what?");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    public String getBotUsername() {
        return "";
    }

    public String getBotToken() {
        return "";
    }
}
