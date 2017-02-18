package com.antviktorov.io;

import com.antviktorov.io.chat.ConsoleChat;
import com.antviktorov.io.chat.Input;
import com.antviktorov.io.chat.StubInput;
import com.antviktorov.io.chat.states.Actions;
import org.junit.Test;

/**
 * Created by antonviktorov on 18.02.17.
 */
public class ConsoleChatTest {
    @Test
    public void testConsoleChat() {
        Input input = new StubInput(
                new String[] {
                        "test", "test123", Actions.ACTION_STOP,
                        "hello", "world", Actions.ACTION_RUN,
                        "Who are you?", "What's up?", "Bye, bye", Actions.ACTION_FINISH
                }
        );
        ConsoleChat chat = new ConsoleChat(input, true);
        chat.start();
    }
}
