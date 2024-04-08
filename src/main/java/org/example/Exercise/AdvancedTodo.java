package org.example.Exercise;

import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Scanner;

public class AdvancedTodo {
    static int i;

    //    ArrayList<Map<String, Integer>> todolist = new ArrayList<>();
    static boolean isEmpty(ArrayList<String> todolist) {
        return todolist.isEmpty();
    }

    /**
     * ArrayList or any of the Java collection framework extends iterables or can be iterated, and sorted.
     * List extends the iterable, randomAccess, serializable e.t.c;
     */
    static void viewTodoList(ArrayList<String> todolist) {
//        Iterator<String> it = todolist.listIterator();
        if (isEmpty(todolist)) {
            System.out.println("list is empty!");
        } else {
            int i = 1;
            for (String task : todolist) {
                System.out.println(i + "." + task);
                i++;
            }
        }

//        while (it.hasNext()) {
//            System.out.println(i + "." + it.next());
//            i++;
//        }
    }

    static void selectTodolist(ArrayList<String> todos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The selected list is : ");

        if (isEmpty(todos)) {
            System.out.println("todolist is empty!");
            return;
        }
        System.out.println("Available tasks in the lists: ");
        for (i = 0; i < todos.size(); i++) {
            System.out.println(STR."\{i + 1}.\{todos.get(i)}");
        }
        int selection = sc.nextInt();
        boolean newSelection = selection >= 1 && selection < todos.size();
        if (newSelection) {
            ArrayList<String> newSelectedList = new ArrayList<>();
            newSelectedList.add(todos.get(selection - 1));

        } else {
            System.out.println("Invalid list");
        }

    }


    static void deleteTodoList(@Nonnull ArrayList<String> todos) {

        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        viewTodoList(todos);
        String selectedList = todos.get(selection - 1);
        System.out.println(STR."selected \n :\{selectedList}");
        System.out.println("do you want to delete? (true/false): ");
        while (true) {
            sc.nextLine();
            String nextElement = sc.nextLine();

            if (nextElement.equalsIgnoreCase("true")) {
                todos.remove(selection - 1);
                System.out.println("Tasks deleted successfully");
                break;

            } else {
                System.out.println("deletion failed");
                viewTodoList(todos);
                break;
            }
        }


    }

    static void addTodoList(ArrayList<String> todos) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        todos.add(input);
        System.out.println("todo list updated\n");

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> todolist = new ArrayList<>();

        while (true) {
            System.out.println("1. viewTodoList\n 2. selectTodoList\n 3. deleteTodoList\n 4. addTodoList");

            int selection = sc.nextInt();
            switch (selection) {
                case 1:
                    viewTodoList(todolist);
                    break;
                case 2:
                    selectTodolist(todolist);
                    break;
                case 3:
                    deleteTodoList(todolist);
                    break;
                case 4:
                    addTodoList(todolist);
                    break;
                default:
                    return;
            }

        }
    }


}