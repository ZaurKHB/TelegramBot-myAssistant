import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyAssistant extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {


        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();


                SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(update.getMessage().getFrom().getFirstName());

            System.out.println(chat_id);

            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

                message // Create a message object object
                        .setChatId(chat_id)
                        .setText("Select one option");
                // Create ReplyKeyboardMarkup object
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                // Create the keyboard (list of keyboard rows)
                List<KeyboardRow> keyboard = new ArrayList();
                // Create a keyboard row
                KeyboardRow row = new KeyboardRow();
                // Set each button, you can also use KeyboardButton objects if you need something else than text
                row.add("lectures");
                row.add("Sabah");

            // Add the first row to the keyboard
                keyboard.add(row);

            row = new KeyboardRow();
            // Set each button for the second line
            row.add("lectures");
            row.add("Bura");
            keyboard.add(row);

            // Set the keyboard to the markup
                keyboardMarkup.setKeyboard(keyboard);
                // Add it to the message
                message.setReplyMarkup(keyboardMarkup);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                if (message_text.equals("lectures")){

                    LocalDate dayOfWeek = LocalDate.now();


                    switch (  dayOfWeek.getDayOfWeek()) {

                        case MONDAY : String lessonss="Subject: Big Data \n Time: 10:00-11:15 \n Venue: SPIA: 301\n";
                            System.out.println(lessonss);
                            break;
                        case TUESDAY :  System.out.println("2ci gun dersleri");
                            break;
                        case WEDNESDAY : String lessons="Subject: Big Data \n   Time: 10:00-11:15 \n   Venue: SPIA: 301\n" +
                                                            "Subject: Career \n   Time: 1:15-2:30 \n   Venue: SPIA: 301\n"+
                                                "Subject: Operating Systems \n   Time: 2:45-4:00 \n    Venue: SB: 303 \n" +
                                                    "Subject: Philosophy \n   Time: 4:15-5:30 \n   Venue: SB: 301 \n";

                            System.out.println(lessons);
                            message.setChatId(chat_id).setText(lessons);
                            try {
                                execute(message);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                            break;
                        case THURSDAY: System.out.println("4ci gun dersleri");
                            break;
                        case FRIDAY: System.out.println("5ci gun dersleri");
                            break;
                        default:
                            System.out.println("Happy Weeked");
                    }

                }
            if (message_text.equals("Sabah")){

                LocalDate dayOfWeek = LocalDate.now();


                switch (  dayOfWeek.getDayOfWeek().plus(1) ) {

                    case MONDAY :  System.out.println("1ci gun dersleri");
                        break;
                    case TUESDAY :  System.out.println("2ci gun dersleri");
                        break;
                    case WEDNESDAY : System.out.println("3ci gun dersleri");
                        break;
                    case THURSDAY: System.out.println("4ci gun dersleri");
                        break;
                    case FRIDAY: System.out.println("5ci gun dersleri");
                        break;
                    default:
                        System.out.println("Happy Weeked");
                }

            }



            }

        }

    public String getBotUsername() {
        return null;
    }

    public String getBotToken() {
      return   "465456769:AAErcXblY9XLhtWI1iZZ5_rHd2IXPIeJW6Q";
    }
}