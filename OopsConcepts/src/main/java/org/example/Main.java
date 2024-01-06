package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class Emp{  // default access modifier is public
    static String ceo;  // related to class and not object
    int salary;  String name;
    static{             // for defining static variable once when the class loads
        ceo="Larry";
    }
    Emp(int salary,String name){
        this.salary=salary;
        this.name=name;
    }
    void print(){
        System.out.println(ceo +"-" +salary+"-"+name);
    }
}

class AccountingEmp extends Emp{

    String designation; int age;
    AccountingEmp(int salary, String name,String des,int age) {
        super(salary, name);
        designation=des;
        this.age=age;
    }
    void print(){  // override print
        System.out.println(ceo +"-" +salary+"-"+name+"-"+age+"-"+designation);
        super.print();  // calling overiden function
    }
}

abstract class BaseClass{
    abstract void run();
}
class revClass extends BaseClass{
    @Override
    void run() {

    }
}
public class Main {
    public static void main(String[] args) {
        AccountingEmp emp1=new AccountingEmp(1000,"Harsh","ABC",24);
        AccountingEmp emp2=new AccountingEmp(2000,"Mudgal","DEF",28);
        emp1.print();
        emp2.print();

        AccountingEmp.ceo="Lorry";  // static keyword
        System.out.println("Ceo Changed");

        emp1.print();
        emp2.print();

    }
}