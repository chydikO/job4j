package ru.job4j.tracker;

public class ConsoleInput {

    public enum MenuItem {
        ADD("Add new Item"),
        SHOW("Show all items"),
        EDIT("Edit item"),
        DELETE("Delete item"),
        FINDBYID("Find item by Id"),
        FINDBYNAME("Find items by name"),
        EXITPRG("Exit Program")
        ;

        private final String text;

        /**
         * @param text
         */
        MenuItem(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    String asas = MenuItem.FINDBYID.toString();
    MenuItem menu = MenuItem.EDIT;
}
