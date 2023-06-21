package repository;

import entity.TodoList;

public interface TodoListRepository {

    TodoList[] getAll();

    void add(TodoList todolist);

    boolean remove(Integer number);

}
