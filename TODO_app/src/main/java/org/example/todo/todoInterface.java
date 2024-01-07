package org.example.todo;

public interface todoInterface {
    public boolean addTask(String s);
    public boolean deleteTask(String id);
    public boolean markComplete(String id);
    public boolean searchTaskBasedOnWord(String word);
    public void getTasksByDate();

}
