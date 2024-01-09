package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    interface ProdFilter{
        boolean accept(Product p);
    }
    static void print(List<Product> p, ProdFilter f){
        p.forEach((a)-> {
            if(f.accept(a))
                System.out.println(a.prodName);
        });
    }
    public static void main(String[] args) {
        List<Product> products=new ArrayList<>() ;
        products.add(new Product("A",50,1));
        products.add(new Product("B",100,7));
        products.add(new Product("C",5,10));
        products.add(new Product("D",10,5));

        products.sort((a,b)-> a.price - b.price);   // simple lambda
        /*
            open function sort and check its comparator's interface and check the abstract functions
            return type which in this case is int
        */
        products.stream().map(Product::getPrice).forEach(System.out::println);  // using function reference




        int limit=3;
        ProdFilter filter=a -> a.quantity > limit;  // limit should be final
        //limit=4;  ERROR limit not final.......because we havent called prodfilter but the limit is changed
        // internally upon creation it creates a copy of the variable
        // because it might be possible that the original variable is removed from memory and filter presists
        print(products,filter);


        // we can not reassign a variable as above
        // but we can change a state in object as given below
        List<Product> cheap=new ArrayList<>();
         products.forEach(a -> {
             if (a.price < 100)
                 cheap.add(a);
         });
         System.out.println();
        cheap.stream().map(a-> a.prodName).forEach(System.out::println);

        // since we are not creating a new object.. this keyword would be representing the same object

    }
}