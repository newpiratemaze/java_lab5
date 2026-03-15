package org.example;
import org.example.config.BotConfig;
import org.example.processor.SortQuiz;
import org.example.processor.TextProcessor;
import org.example.processor.UserSession;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class TextProcessorBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    public SortQuiz sortQuiz = new SortQuiz();

    public String state = "echo";

    public boolean isAnswerCorrect = false;
    public UserSession userSession = new UserSession();

    // Конструктор принимает токен для инициализации клиента
    public TextProcessorBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
    }


    @Override
    public void consume(Update update) {
        // Проверяем, что полученное обновление содержит текстовое сообщение
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            // Определяем ответ в зависимости от команды
            String answerText;
            if (userMessageText.equals("/start")) {
                answerText = "Привет! Я эхо-бот. Просто напиши мне что-нибудь.";
            } else if (userMessageText.equals("/help")) {
                answerText = "Я повторю за тобой любое текстовое сообщение.";
            }
            else if (userMessageText.equals("/echo"))
            {
                answerText = "Состояние: echo";
                state = "echo";
            }
            else if (userMessageText.equals("/quiz"))
            {
                //answerText = "Состояние: quiz";
                //answerText = sortQuiz.getQuizMap()+"";
                answerText = sortQuiz.getQuiz();

                state = "quiz";

            }
            else if (userMessageText.equals("/score"))
            {
                answerText = "Ваш счет: "+userSession.getScore();
            }
            else if (state == "quiz")
            {
                //String[] userMessage = userMessageText.split(" ");
                String correctAnswer = sortQuiz.getCorrectAnswer();

                String[] correctAnswerArray = correctAnswer.split(", ");
                String[] userAnswerArray = userMessageText.split(" ");

                if(correctAnswerArray.length != userAnswerArray.length)
                {
                    answerText = "Неверный ввод ответа!\n" +
                            "Пример: 1 2 3 4";
                }


                isAnswerCorrect = sortQuiz.checkAnswer(userMessageText);

                if(isAnswerCorrect)
                {
                    userSession.increaseScore();
                    answerText = "Правильный ответ!\n" +
                            "Добавлено +1 очко к счету.";

                }
                else {
//                    answerText = "Неправильный ответ!\n" +
//                            "Правильный ответ: "+correctAnswer +"\n" +
//                            "userMessageText: "+ userMessageText;
                    answerText = "Неправильный ответ!";
                }
            }

            else if (state =="echo") {


                TextProcessor textProcessor = new TextProcessor();


                answerText = "Эхо: " + textProcessor.getMorseCode(userMessageText);
                //answerText = "Эхо: " + userMessageText;
            }
            else {
                answerText = "Состояние: "+state;
            }

            // Создаем объект ответного сообщения с использованием билдера
            SendMessage reply = SendMessage
                    .builder()
                    .chatId(chatId)
                    .text(answerText)
                    .build();

            // Пытаемся отправить сообщение
            try {
                telegramClient.execute(reply);
            } catch (TelegramApiException e) {
                System.err.println("❌ Ошибка обработки сообщения: " + e.getMessage());
                e.printStackTrace();
                //sendText(chatId, "⚠️ Произошла ошибка. Попробуйте еще раз.");
            }
        }
    }
}
