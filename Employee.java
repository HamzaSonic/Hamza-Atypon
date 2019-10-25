public class Employee implements Cloneable{
    private String name,jobDescreption,dept ;
    long sin;int salary ,age ;
    public Employee(int sin,String name,int age){
        /**basic attributes for an employee */
        this.sin=sin;
        this.name=name;
        this.age=age;
    }
    public Employee(int sin,String name,int age ,String dept,String jobDescreption,int salary){
        /**full information about employee constructor*/
        this.sin=sin;
        this.name=name;
        this.age=age;
        this.dept=dept;
        this.jobDescreption=jobDescreption;
        this.salary=salary;
    }

    /**setters and getters methods for attributes except the name and sin because sin and name does not change*/
    public void setAge(int age) {
        this.age = age;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setJobDescreption(String jobDescreption) {
        this.jobDescreption = jobDescreption;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public long getSin() {
        return sin;
    }

    public String getDept() {
        return dept;
    }

    public String getJobDescreption() {
        return jobDescreption;
    }

    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object obj)
    {
        /**if the object is compared to itself*/
        if(this == obj)
            return true;
        /**the 2 objects must be from the same class */
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        /**if they have the same sin then it's the same employee*/
        Employee emp = (Employee) obj;
        return (emp.name.equals(this.name)  && emp.sin == this.sin);
    }

    @Override
    public int hashCode()
    {
        return (int) this.sin;
    }

    @Override
    public String toString() {
        String s= "I'm an employee my name is "+name+" and i work in the "+dept+" department and my social security number is "+sin;
        return s;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee e1=null;
        try{
            e1=(Employee)super.clone();
        }
        catch (CloneNotSupportedException e){}
        return e1;
    }
    /**the tax calculator in assignment 4*/
    public double taxCalculator() throws Exception1 {
        /**the limit i set was 130 $ so if the tax is greater than 130 it will throw an exception*/
        double tax;
        tax= 0.05*salary;
        if (tax<=130)return tax;
        else throw new Exception1();

    }
    /**the function that validate the SIN number*/
    private boolean isValid () throws Exception2{
        /**based on Canada SIN */
        long v=121212121;
        long v2=sin;
        int s=0;
        while (v2!=0){
            s+=v%10 *v2%10;
            v/=10;
            v2/=10;
        }

        if (s%10==0) return true;else throw new Exception2();
    }
    public int  insurance() throws Exception2 {
        /**if the sin is valid return the last 3 digits of the salary*/
        if (isValid()) return salary%1000;
        return 0;
    }

    public static void main(String[] args) throws Exception2 {
        /**2 employees to test the functionality of the code*/
        Employee e1=new Employee(131192544,"Hamza",25);
        e1.setDept("IT department ");
        e1.setJobDescreption("Java Developer ");
        e1.setSalary(2800);
        System.out.println(e1.toString());
        Employee e2=new Employee(231231423,"malik",30,"Marketing","call center",1400);
        /**the equals method*/
        if (e1.equals(e2)) System.out.println("same Employee"); else System.out.println("different employee ");
        System.out.println();
        /**now the tax and exceptions task*/
        Double tax;
        try {
             tax=e1.taxCalculator();
        }catch (Exception1 e){
            System.out.println("the tax is more than 130 $");
            tax=130.0;
        }
        System.out.println("the tax is "+tax);
        /**the sin validate*/
        int in;
        try{
            in=e1.insurance();

        }catch (Exception2 e){
            System.out.println("the SIN is not valid");
            in=0;

        }
        System.out.println("the insurance is "+in);

        /**this function to check if the valid function works so it will throw an exception*/
        Employee e3=new Employee(965942103,"ahmad",20);
        e3.setSalary(2000);
        int z=e3.insurance();



    }

}
