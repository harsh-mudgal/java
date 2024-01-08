package org.example.todo;

import org.example.todo.Task.Task;

import java.time.LocalDate;
import java.util.*;

public class TodoApp implements todoInterface {
    static int tot=0;
    HashMap<Integer,Task> map=new HashMap<>();
    TreeMap<LocalDate,ArrayList<Integer>> dateWiseMap=new TreeMap<>();

    @Override
    public boolean addTask(String s){
        String[] arr=s.split(":");  // date,title,desc
        try {
            Task task = new Task(tot + 1, arr[1], arr[2], arr[0]);
            tot++;
            map.put(task.getId(),task);
            if(!dateWiseMap.containsKey(task.getDate())){
                dateWiseMap.put(task.getDate(),new ArrayList<>());
            }
            dateWiseMap.get(task.getDate()).add(task.getId());
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteTask(String id){
        try {
            int ID = Integer.parseInt(id);
            dateWiseMap.get(map.get(ID).getDate()).remove(Integer.valueOf(ID));
            map.remove(ID);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean markComplete(String id){
        try {
            int ID = Integer.parseInt(id);
            map.get(ID).setCompleted(true);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean searchTaskBasedOnWord(String word) {
        int flag=0;
        for (HashMap.Entry<Integer, Task> entry : map.entrySet()) {
            //int key = entry.getKey();
            Task value = entry.getValue();

            if (value.getTitle().startsWith(word)) {
                flag=1;
                value.printTask(true);
            }
        }
        return flag != 0;
    }

    @Override
    public void getTasksByDate() {
        for (Map.Entry<LocalDate, ArrayList<Integer>> entry : dateWiseMap.entrySet()) {
            LocalDate date = entry.getKey();
            ArrayList<Integer> ids = entry.getValue();
            if(ids.isEmpty()){
                continue;
            }
            System.out.println(date+":");
            for(int ele: ids){
                map.get(ele).printTask(false);
            }
            System.out.println();
        }
    }
}
