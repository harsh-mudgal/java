package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public  class Main {
    private static int[] buffer;
    private static int count;

    private static final Object lock=new Object();
    static class Producer {
        void produce() {
//            synchronized (lock) {         Using synchronized
//                while (isFull(buffer)) {
//                }
//                buffer[count++] = 1;
//            }

              synchronized (lock){
                  if(isFull(buffer)) {
                      try {
                          lock.wait();
                      }
                      catch (Exception e){
                          System.out.println(e.getMessage());
                      }
                  }
                  buffer[count++] = 1;
                  lock.notify();
              }
        }
    }

    static class Consumer {
        void consume() {
//            synchronized (lock) {          Using synchronized
//                while (isEmpty(buffer)) {
//                }
//                buffer[--count] = 0;
//            }

            synchronized (lock){
                if(isEmpty(buffer)) {
                    try {
                        lock.wait();
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                buffer[--count] = 0;
                lock.notify();
            }
        }
    }
    static boolean isEmpty(int[] buf){
        return count==0;
    }
    static boolean isFull(int[] bf){
        return count==buffer.length;
    }
    public static void main(String[] args) throws InterruptedException{
        buffer=new int[10];
        count=0;

        Producer prod=new Producer();
        Consumer cons=new Consumer();
        Runnable produceTask=()->{
            for(int i=0;i<55;i++){
                prod.produce();
            }
            System.out.println("Done Producing");
        };
        Runnable consumeTask=()->{
            for(int i=0;i<53;i++){
                cons.consume();
            }
            System.out.println("Done Consuming");
        };
        Thread one=new Thread(consumeTask);
        Thread sec=new Thread(produceTask);
        one.start();sec.start();
        one.join();sec.join();
        System.out.println("Data: " + count);
    }
}