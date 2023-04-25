
package pjv.hodina10.bankaccount;

import java.util.ArrayList;
import java.util.List;


public class Shop {
    
    List<Person> customers;
    double [] bills;
    
    
    public Shop(List<Person> customers, double [] bills){
        this.customers = customers;
        this.bills = bills;
    }
    
    public void makeCustomersPayBills() throws InterruptedException{
        List<Thread> threads = new ArrayList<>();
         for(Person customer : customers){
            for(double payment : bills){
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            customer.removeAmountFromBankAccount(payment);
                        } catch (InterruptedException ex) {
                            System.out.println("Thread interrupted");
                        }
                    }
                };
                thread.start();
                threads.add(thread);
            }
        }
        for (Thread t : threads) {
            try{
                t.join();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
    
}
