package org.example.first.subPackage;

import org.example.first.PrintNumber;

public class Subtract {
    public void subtract(int a,int b){
        PrintNumber print=new PrintNumber();
        //print.print(a,b);    print if not public, subpackages can also not access it
        System.out.println(a-b);
    }
}
