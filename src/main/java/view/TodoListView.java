package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true) {
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("x. Out");

            var input = InputUtil.input("Choose");

            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equalsIgnoreCase("x")) {
                break;
            } else {
                System.out.println("Option is not valid");
            }
        }
    }

    public void addTodoList() {
        System.out.println("ADD TODOLIST");

        var todo = InputUtil.input("Todo (x to Cancel)");

        if (todo.equals("x")) {
            // batal
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("DELETE TODOLIST");

        var number = InputUtil.input("Number to delete (x to Cancel)");

        if (number.equals("x")) {
            // batal
        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }

}
