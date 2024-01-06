package org.example.first;

public class AddNumber{
    public void add(int a,int b){
        PrintNumber obj=new PrintNumber();// can access even if PrintNumber is not public
        obj.print(a,b);
        System.out.println(a+b);
    }
}
