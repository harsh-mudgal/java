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
    public static String[] testCase={"1","17/10/2024:First:adaksdjhsakldj",
        "1","09/02/2023:Sec:dsfsdf",
            "1","05/01/2022:Third:sdfsd",
            "2",
            "4","2",
            "2",
            "5","Se",
            "3","3",
            "2"
    };
    public static int i=0;
    public static void main(String[] args) {
        System.out.println("Welcome to TODO APP");
        System.out.println("Enter -1 TO EXIT");
        System.out.println("Enter 1 to add task in format of <Date>:<Title>:<Description>");
        System.out.println("Enter 2 to retrieve all tasks grouped by date");
        System.out.println("Enter 3 to delete task by id");
        System.out.println("Enter 4 to make task as completed");
        System.out.println("Enter 5 to start search of tasks that start with a particular word");

        //Scanner sc=new Scanner(System.in);
        TodoApp todoApp=new TodoApp();
        while(i<testCase.length){
            String s;
            System.out.println("Enter code: ");
            //s=sc.nextLine();
            s=testCase[i++];
            System.out.println(s);
            switch(s){
                case "-1":
                    System.out.println("Exiting......");
                    System.exit(0);
                    break;

                case "1":
                    System.out.println("Enter task in the format <Date(eg:dd/mm/yyyy)>:<Title>:<Description> ");
                    //String t=sc.nextLine();
                    String t=testCase[i++];
                    System.out.println(t);
                    boolean x=todoApp.addTask(t);
                    successError(x);
                    break;

                case "2":
                    todoApp.getTasksByDate();
                    break;

                case "3":
                    System.out.println("Enter task id to be deleted");
                    //String id=sc.nextLine();
                    String id=testCase[i++];
                    System.out.println(id);
                    successError(todoApp.deleteTask(id));
                    break;

                case "4":
                    System.out.println("Enter task id to be marked as completed");
                    //String i=sc.nextLine();
                    String ip=testCase[i++];
                    System.out.println(ip);
                    successError(todoApp.markComplete(ip));
                    break;

                case "5":
                    System.out.println("Enter word to be used for searching tasks");
                    //String word=sc.nextLine();
                    String word=testCase[i++];
                    System.out.println(word);
                    boolean tf=todoApp.searchTaskBasedOnWord(word);
                    if(!tf)
                        System.out.println("No results found....");
                    break;

                default:
                    System.out.println("Please enter a suitable input");
                    break;

            }
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
        }
    }
}