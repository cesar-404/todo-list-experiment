package br.com.bebopcode.todolist.enums;

public enum TaskPriority {

    HIGH(1),
    NORMAL(2),
    LOW(3);

    private final int order;

    TaskPriority(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
