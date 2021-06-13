package ru.job4j.condition;

/**
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

class DummyBot {
    /**
     * Отвечает на вопросы.
     * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public static String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот".equals(question)) {
            // заменить ... на правильный ответ rsl = "ответ по заданию".
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) { // заменить ... на проверку, что этот вопрос известен боту и он знает как на него ответить.
            // заменить ... на правильный ответ rsl = "ответ по заданию".
            rsl = "До скорой встречи.";
        }
        return rsl;
    }

    public static void main(String[] args) {
        String rsl = DummyBot.answer("Привет, Бот");
        System.out.println(rsl);
        rsl = DummyBot.answer("Пока.");
        System.out.println(rsl);
    }
}
