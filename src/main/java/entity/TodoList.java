package entity;

public class TodoList {

    private String todo;

    public TodoList(String todo) {
        this.todo = todo;
    }

    public TodoList() {
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
