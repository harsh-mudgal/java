package org.example.todo;

public interface todoInterface {
     boolean addTask(String s);
     boolean deleteTask(String id);
     boolean markComplete(String id);
     boolean searchTaskBasedOnWord(String word);
     void getTasksByDate();

}
