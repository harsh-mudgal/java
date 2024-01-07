package org.example.todo.Task;

public class Task {
    private int id;
    private String title;
    private String description;
    private String date;  // day/month/year   09/01/2024

    private boolean completed;

    public Task(int id,String title,String description , String date){
        this.id=id;  this.title=title; this.description=description; this.date=date;
        this.completed=false;
    }

    public int getId() {                                  // id
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {                           // title
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {                    // description
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {                          // date
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setCompleted(boolean x){this.completed=x;}
    public boolean isCompleted() {return completed;}


    public void printTask(boolean printDate){
        if(printDate){
            System.out.println(date);
        }
        System.out.println("Title: " + title);
        System.out.println("Description: "+ description);
        System.out.println("Completed: " + (completed? "Yes":"NO") );
        System.out.println();
    }

}
