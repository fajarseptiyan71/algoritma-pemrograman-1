public class Salary{
    private String type;
    private Integer amount;
    
    public Salary(String type, Integer amount) {
        this.type = type;
        this.amount = amount;
    }
    
    public Integer GetAmount() {
        return this.amount;
    }
    
    public String GetType() {
        return this.type;
    }
    
    public Integer GetSalary(Integer overtime) {
       return this.amount + overtime;
    }
}