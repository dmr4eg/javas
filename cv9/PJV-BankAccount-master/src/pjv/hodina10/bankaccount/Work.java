
package pjv.hodina10.bankaccount;

import java.util.ArrayList;
import java.util.List;


public class Work {
    private List<Person> employees;
    private double[] payments;

    public Work(List<Person> employees, double[] payments) {
        this.employees = employees;
        this.payments = payments;
    }

    public void payPayments() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (Person employee : employees) {
            for (double payment : payments) {
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            employee.addAmountToBankAccount(payment);
                        } catch (InterruptedException ex) {
                            System.out.println("Thread interrupted");
                        }
                    }
                };
                thread.start();
            }
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
