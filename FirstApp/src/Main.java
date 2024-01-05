import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            System.out.println("Hello");
            System.out.println("Hello 1");
            System.out.println("Hello 2");

            System.out.println(printDiffVariables());

            if(args.length!=0){
                System.out.println("Args are present");
                for(String s: args) {
                    System.out.print(s+" ");
                }
            }
            else{
                System.out.print("No args found");
            }
            System.out.println();

            float[] f=new float[4];  f[0]=1;f[2]=2;f[3]=3;f[1]=1;
            for(float i:f)
                System.out.print(i+" ");
            System.out.println();
            char c='s';
            switch(c) {
                case 'a':
                    System.out.println("No Match:a");
                    break;
                case 'b':
                    System.out.println("No Match:b");
                    break;
                case 's':
                    System.out.println("Right Match:s");
                    break;
                default:
                    System.out.println("No Match: random");
                    break;
            }

            StringBuilder sb=new StringBuilder();
            sb.append("This is "); sb.append(78.1);sb.append(" string builder");
            System.out.println(sb.toString());

            Scanner sc=new Scanner(System.in);
            System.out.print("Enter line: ");
            String s=sc.nextLine();  /* .split(" ") this would give an array as output which has splited elements*/
            System.out.println(s);
        }
        static int printDiffVariables(){
            byte b=23;
            int i=16;
            short s=12346;
            long l=34278637L;

            float f=1f;
            double d=1d;

            boolean x=true;
            char c='A';
            System.out.print(b+" "+i+" "+s+" "+l+" "+f+" "+d+" "+x+" "+c+" ");
            return 6;
        }
}