public class Overtime{
    private Integer duration;
    private Float percent;
    
    public Overtime(Integer duration, Float percent) {
        this.duration = duration;
        this.percent = percent;
    }
    
    public Integer GetDuration() {
        return this.duration;
    }
    
    public Float GetPercent() {
        return this.percent;
    }
    
    public Integer GetSalary(Salary salary) {
       return (int) (salary.GetAmount() * this.percent);
    }
}