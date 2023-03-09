package cz.cvut.fel.pjv.model;

public class ServiceBook {
    private final String[] serviceRecords = new String[10];

    public ServiceBook(Car car) {
        car.setServiceBook(this);
    }

    public void addRecord(String record) {
        for (int i = 0; i < serviceRecords.length; i++) {
            if (serviceRecords[i] == null) {
                serviceRecords[i] = record;
                break;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (String i : serviceRecords) {
            if (i != null){
                result = result + i + '\n';
            }
        }
        return result;
    }
}
