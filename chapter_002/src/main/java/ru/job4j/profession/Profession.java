package ru.job4j.profession;

/**
 * Требования к задаче:
 * 1. Откройте схему, которую вы составили в задании "Создать классы профессий" из 1-го урока;
 * 2. Создайте базовый класс Profession - вынесите туда все общие поля и методы;
 * 3. Создайте классы Doctor, Engineer, Teacher, унаследовав их от Profession;
 * 4. Реализуйте в них недостающие поля и методы согласно вашей схеме.
 *
 * Если в вашей схеме не хватает методов или они отличаются, просто добавьте не достающие классы или измените методы.
 *
 * Классы и методы должны быть такими как указаны в задании.
 * Примеры методов:
 * Метод public Diagnose heal(Pacient pacient) {} из класса Doctor возвращает диагноз.
 *
 * Метод public getName из класса Proffesion (т.е. общий для всех унаследованных классов) возвращает имя при вызове его
 * для любого класса Doctor, Teacher, Engineer.
 *
 * Классы Diagnose и т.д. Вы должны создать сами.
 *
 * Важно внутри методы ничего не должны делать.  Оставь эти методы пустые!
 * Что не нужно делать:
 * 1. Здесь не надо использовать Scanner, System.in, System.out.println.
 * 2. В программе не должно быть ввода и вывода данных.
 * 3. Не надо создавать метод public static void main(String[] args) - так вы занимаетесь ручным тестированием.
 * В курсе используется только автоматическое тестирование за счет JUnit.
 * Список доп. литературы:
 * 1. Head First Java (Кэти Сьерра Изучаем Java), глава 7. Страница 198.
 * 2. Хорстманн К., Корнелл Г. - Java. Библиотека профессионала. Том 1. Основы. 10-е издание. Глава 5. Страница 193.
 */

public class Profession {
    protected String name;
    protected String profession;

    public Profession() {
    }

    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return this.name;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
