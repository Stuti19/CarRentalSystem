package Customer;

abstract class absCustomer{
    abstract public String getId();
    abstract public String getName();
    abstract public int getAge();
}
public class Customer extends absCustomer {
    String customerId;
    String customerName;
    int customerAge;

    Customer(String customerId,String customerName,int customerAge){
        this.customerId=customerId;
        this.customerName=customerName;
        this.customerAge=customerAge;
    }

    public String getId(){
        return customerId;
    }
    public String getName(){
        return customerName;
    }
    public int getAge(){
        return customerAge;
    }

}
