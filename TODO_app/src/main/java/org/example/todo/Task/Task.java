package org.example.todo.Task;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDate date;  // day/month/year   09/01/2024

    private boolean completed;

    private static DateTimeFormatter formatter ;
    public Task(int id,String title,String description , String date){
        formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.id=id;  this.title=title; this.description=description;
        this.date=LocalDate.parse(date,formatter);
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

    public LocalDate getDate() {                          // date
        return date;
    }
    public void setDate(String date) {
        this.date = LocalDate.parse(date,formatter);
    }

    public void setCompleted(boolean x){this.completed=x;}
    public boolean isCompleted() {return completed;}


    public void printTask(boolean printDate){
        if(printDate){
            System.out.println(formatter.format(date));
        }
        System.out.println("Id: "+id);
        System.out.println("Title: " + title);
        System.out.println("Description: "+ description);
        System.out.println("Completed: " + (completed? "Yes":"NO") );
        System.out.println();
    }

}
