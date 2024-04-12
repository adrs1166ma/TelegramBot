package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "ChatBotadrs1166ma_bot";
    public static final String TOKEN = "7009056979:AAFqQpKfDPgYCCXjiJSjrmOepVv-zRa_ctY";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if (getMessageText().equals("/start")){
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera","step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Tomar una salchicha! +20 de fama","step_2_btn",
                            "¡Tomar un pescado! +20 de fama","step_2_btn",
                            "¡Tirar una lata de pepinillos! +20","step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspiradora","step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspirador por comida! +30 de fama","step_4_btn",
                            "Dar un paseo en el robot aspirador! +30 de fama","step_4_btn",
                            "¡Huir del robot aspirador! +30 de fama","step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(0);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Ponersela y encender","step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            addUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("pescado","step_6_btn",
                            "bola de hilo","step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            addUserGlory(0);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("hackear la contraseña","step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            addUserGlory(50);
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("siguiente","step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            addUserGlory(50);
            sendTextMessageAsync(FINAL_TEXT);
        }


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}