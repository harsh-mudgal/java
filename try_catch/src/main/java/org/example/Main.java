package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static double divide(int a, int b){
        try{
            int ans=  a /b;
            return ans;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        finally{
        // always gets executed even if we have return above
        //can overide above return statement
        //only scenario where it is not executed is System.exit(0);
            System.out.println("Finally");
        }
    }

    public static void nestedTryCatch(){
        /* If appropriate catch is not found inside then it executed finally block present inside
        before moving to the outside catch
        If it is found inside then it just executes catch + finally present inside and moves to outside
        */
        try{
            try {
                int a=5;
                int b=0;
                System.out.println(a/b);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array Index out of bound");
                //return -1;
            }finally {
                System.out.println("Final inside");
            }
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Final outside");
        }
    }

    //throws is used to handle checked exception such as IOException
    // it specifies that this function might throught an exception
    public static String throwKeyword(int age) throws customException {
        if(age < 15){
            throw new ArithmeticException("under 15");
        }
        if(age<18){
            throw new customException("Age is less than 18");
        }
        else {
            return "User eligible";
        }
    }

    public static void main(String[] args) {  // can access static function or variables only
        System.out.println(divide(4, 0));
        System.out.println("-----------");
        nestedTryCatch();
        try {
            System.out.println(throwKeyword(111));
        }
        catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        }
    }
}