package org.example;

import org.example.todo.TodoApp;

import java.util.Scanner;

public class Main {
    public static void successError(boolean x){
        if(x)
            System.out.println("Success....");
        else
            System.out.println("Error......");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to TODO APP");
        System.out.println("Enter -1 TO EXIT");
        System.out.println("Enter 1 to add task in format of <Date>:<Title>:<Description>");
        System.out.println("Enter 2 to retrieve all tasks grouped by date");
        System.out.println("Enter 3 to delete task by id");
        System.out.println("Enter 4 to make task as completed");
        System.out.println("Enter 5 to start search of tasks that start with a particular word");

        Scanner sc=new Scanner(System.in);
        TodoApp todoApp=new TodoApp();
        while(true){
            String s;
            System.out.println("Enter code: ");
            s=sc.nextLine();
            switch(s){
                case "-1":
                    System.out.println("Exiting......");
                    System.exit(0);
                    break;

                case "1":
                    System.out.println("Enter task in the format <Date(eg:dd/mm/yyyy)>:<Title>:<Description> ");
                    String t=sc.nextLine();
                    boolean x=todoApp.addTask(t);
                    successError(x);
                    break;

                case "2":
                    todoApp.getTasksByDate();
                    break;

                case "3":
                    System.out.println("Enter task id to be deleted");
                    String id=sc.nextLine();
                    successError(todoApp.deleteTask(id));
                    break;

                case "4":
                    System.out.println("Enter task id to be marked as completed");
                    String i=sc.nextLine();
                    successError(todoApp.markComplete(i));
                    break;

                case "5":
                    System.out.println("Enter word to be used for searching tasks");
                    String word=sc.nextLine();
                    boolean tf=todoApp.searchTaskBasedOnWord(word);
                    if(!tf)
                        System.out.println("No results found....");
                    break;

                default:
                    System.out.println("Please enter a suitable input");
                    break;

            }
        }
    }
}