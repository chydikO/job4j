package ru.job4j.tracker;

public class Item {
    /**
     * name - имя заявки
     * description - описание
     * create - создана
     */
    protected String id;
    protected String name;
    protected String description;
    protected long create;
    protected String[] comments;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public long getCreate() {
        return this.create;
    }

    public void setCreate() {
        this.create = create;
    }

    public String[] getComments() {
        return this.comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public Item() {
        }

    public  Item(String name, String desc, long created) {
        this.name = name;
        this.description = desc;
        this.create = created;
    }
}
