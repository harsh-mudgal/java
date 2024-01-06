package org.example;
import org.example.first.AddNumber;
import org.example.first.PrintNumber;
import org.example.first.subPackage.Subtract;

//import org.example.first.*;  import all files in first package but not SUBPACKAGES inside
//import java.lang.*;          no need to import default
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method");
        PrintNumber print=new PrintNumber();// PrintNumber class should be public to be used here
        //print.print(1,2);                 // method is not public so it cannot be used here

        AddNumber add=new AddNumber();
        add.add(2,3);

        Subtract sub=new Subtract();
        sub.subtract(5,9);
    }
}