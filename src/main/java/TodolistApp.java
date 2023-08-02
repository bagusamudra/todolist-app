@Deprecated
public class TodolistApp {

    public static String[] model = new String[10];

    public static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Show todoList
     */
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi Todolist";
        showTodoList();
    }

    /**
     * Add todoList to list
     * @param todo;
     */
    public static void addTodoList(String todo) {
        // cek if model is full?
        var isFull = true;
        for (String s : model) {
            if (s == null) {
                // available empty model
                isFull = false;
                break;
            }
        }

        // if full, resize array 2x
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            System.arraycopy(temp, 0, model, 0, temp.length);
        }

        // add to array position which is NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Example Todo No." + i);
        }

        showTodoList();
    }

    /**
     * Delete todoList from list
     * @param number;
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");
        addTodoList("Four");
        addTodoList("Five");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var address = input("Address");
        System.out.println(address);
    }

    /**
     * Show view todoList
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("x. Out");

            var input = input("Choose");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equalsIgnoreCase("x")) {
                break;
            } else {
                System.out.println("Option is not valid");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    /**
     * Show view add todoList
     */
    public static void viewAddTodoList() {
        System.out.println("ADD TODOLIST");

        var todo = input("Todo (x to Cancel)");

        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Show view delete todoList
     */
    public static void viewRemoveTodoList() {
        System.out.println("DELETE TODOLIST");

        var number = input("Number to Delete (x to Cancel)");

        if (number.equals("x")) {
            // cancel
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Failed to delete todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }

}
