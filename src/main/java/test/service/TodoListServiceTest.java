package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {

    public static void main(String[] args) {
        testRemoveTodolist();
    }

    public static void testShowTodoList() {
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Belajar Java");
        todoListRepository.data[1] = new TodoList("Belajar Javascript");
        todoListRepository.data[2] = new TodoList("Belajar PHP");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();

    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListServiceImpl todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java");
        todoListService.addTodoList("Belajar Javascript");
        todoListService.addTodoList("Belajar PHP");

        todoListService.showTodoList();

    }

    public static void testRemoveTodolist() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListServiceImpl todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java");
        todoListService.addTodoList("Belajar Javascript");
        todoListService.addTodoList("Belajar PHP");

        todoListService.showTodoList();

        todoListService.removeTodoList(5);
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(1);
        todoListService.showTodoList();
    }

}
