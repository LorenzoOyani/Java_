//package org.example;
//
//
////Todos
///**
// * Objects is a utility class introduced in java 7 for comparing, PersonEquals and hashing and performing null-safe operations
// * A utility class in Java is a class that provide a list of static methods and
// * <p>
// * spring conversion service.
// */
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
///**
// * viewTodoList
// * EditTodoLists
// * addNewTodoListToGroup
// * EditTodoLabels
// * EditTheList
// */
//
//public class TodoHash {
//    static int id = 0;
//    static int i;
//
//
//    static boolean isEmpty(ArrayList<HashMap<String, Object>> todolist) {
//        return todolist.isEmpty();
//    }
//
//    public static void editTodoList(ArrayList<HashMap<String, Object>> todos) {
//        Scanner sc = new Scanner(System.in);
//        HashMap<String, Object> newList = selectList(todos);
//
//        while (true) {
//            System.out.println("1. \nEditTasksLabels 2. ");
//            int selection = sc.nextInt();
//            sc.nextLine();
//            switch (selection) {
//                case 1 -> editTasksLabel(newList);
//                break;
//                case 2 -> editTodoTaskList(newList);
//                break;
//                case 3 -> addTasksToLists(newList);
//                break;
//                default -> {
//                    return;
//                }
//            }
//        }
//
//    }
//
//    public static void editTodoTaskList(HashMap<String, Object> todoList) {
//        System.out.println("The list of todo to edit");
//        System.out.println(todoList.get("Todo List"));
//        ArrayList<String> list = (ArrayList<String>) todoList.get("Todo List");
//
//        for (String tasks : list) {
//            System.out.println(i + "." + tasks);
//            if (i < tasks.length()) i++;
//        }
//        Scanner sc = new Scanner(System.in);
////        int selections  = sc.nextInt();
//        System.out.printf("selected: %d%n", list.get(i - 1));
//        System.out.println("Enter a new Task.");
//        sc.nextLine();
//        String newTask = sc.nextLine();
//        list.set(i - 1, newTask);
//        todoList.put("Todo List", list);
//
//
//    }
//
//    public static void addNewTodoGroup(ArrayList<HashMap<String, Object>> todoList) {
//        if (isEmpty(todoList)) System.out.println("list is empty!");
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Add a new Todo Group: ");
//        String GroupName = sc.nextLine();
//        HashMap<String, Object> newList = new HashMap<>();
//        ArrayList<String> list = new ArrayList<>();
////        list.add(GroupName);
//        list.add("first task");
//        newList.put("Group name", GroupName);
//        newList.put("id", ++id);
//        newList.put("Todo List", list);
//
//        todoList.add(newList);
//        viewTodoList(todoList);
//
//
//    }
//
//    public static void addTasksToLists(HashMap<String, Object> selectedTaskList) throws ClassCastException {
//        ArrayList<String> list = (ArrayList<String>) selectedTaskList.get("id");
//        if (list.isEmpty()) {
//            System.out.println("list is empty!");
//        }
//        Scanner sc = new Scanner(System.in);
//        String selections = sc.nextLine();
//        list.add("tasks");
//        selectedTaskList.put("Group name", selections);
//        selectedTaskList.put("id", ++id);
//        selectedTaskList.put("tasks", list);
//
//        System.out.println("Todolist is updated\n");
//
//    }
//
//    public static HashMap<String, Object> selectList(ArrayList<HashMap<String, Object>> todos) {
//        i = 1;
//        if (isEmpty(todos)) return null;
//
//        for (HashMap<String, Object> list : todos) {
//            System.out.println(list.get("id") + " " + list.get("group Name"));
//            i++;
//
//        }
//        Scanner sc = new Scanner(System.in);
//        // always put a selection in a new list
//        HashMap<String, Object> selectedList = null;
//        int selection = sc.nextShort();
//        for (HashMap<String, Object> newList : todos) {
//            if (newList.get("id").PersonEquals(selection)) {
//                selectedList = newList;
//            }
//        }
//        System.out.printf("selected lists is: %s%n", selectedList);
//        return selectedList;
//
//    }
//
//
//    static void viewTodoList(ArrayList<HashMap<String, Object>> list) {
//        if (isEmpty(list)) {
//            System.out.println("is empty!");
//        }
//        i = 1;
//        for (HashMap<String, Object> lists : list) {
//            System.out.println(lists.get("id") + "." + list.get(Integer.parseInt("Get name")));
//            i++;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
////        sc.nextLine()
//        int input = sc.nextInt();
//        ArrayList<HashMap<String, Object>> globalTodos = new ArrayList<HashMap<String, Object>>();
//        while (true && input > 0) {
//            System.out.println("1. viewTodoList\n 2. editTodoList 3. addNewTodoGroup");
//            switch (input) {
//                case 1:
//                    viewTodoList(globalTodos);
//                    break;
//                case 2:
//                    editTodoList(globalTodos);
//                    break;
//                case 3:
//                    addNewTodoGroup(globalTodos);
//                    break;
//                default: {
//                    return;
//                }
//
//            }
//        }
//
//    }
//
//}