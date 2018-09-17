abstract class Car
{
    abstract void strtCar();
    void ac(){
         System.out.println("temp");
         
    }
    
    
    void lights(){
         System.out.println("temp");
         
    }
}

interface ElectricCar
{
    void strtBattery();
}

interface PetrolCar
{
    void strtEngine();
}


// Filename: HybridCar.java
public class HybridCar extends Car implements ElectricCar, PetrolCar
{
    static int cc;
    static String name;
    int type=0;
    
    HybridCar()
    {
        System.out.println("Hi");
        this.name="NA";
        this.cc=0;
    }
    
    HybridCar(String n)
    {
        System.out.println("Hi");
        this.name=n;
    }
    
    public class Sedan{
        
        Sedan(){
            System.out.println("Sedan Constructor");
        }
        
        void setName(String n){
            name=n;
        }
    }
    
    public class HatchBack{
        String name;
        HatchBack(){
            System.out.println("HatchBack Constructor");
        }
        void setName(String n){
            this.name=n;
        }
        
    }
    
    void strtCar(){
         System.out.println("Car Started");
         
    }
    
    public void strtBattery(){
        System.out.println("Electric motor initialised");
        
    }
    public void strtEngine(){
        System.out.println("Petrol engine spark ok");
        
    }
    
    


    public static void main(String args[])
    {
        
            
        HybridCar hybridCar=new HybridCar("temp");
        
        HybridCar.HatchBack obj1=hybridCar.new HatchBack();
        obj1.setName("Fit");
            
        
        HybridCar.Sedan obj2=hybridCar.new Sedan();
        obj2.setName("Insight");
        
        HybridCar obj4=null;
        HybridCar obj= new HybridCar();
        try{
        obj.strtCar();
        }catch(NullPointerException e){
            System.out.println("Hello je");
        }
        
        try{
        obj.strtBattery();
        }catch(NullPointerException e){
            System.out.println("Hello jee");
        }
        
        try{
        obj.strtEngine();
        }catch(NullPointerException e){
            System.out.println("Hello jeee");
        }
        
        finally
        {
           // HybridCar t1=new HybridCar();
            
            System.out.println("I give up");
        }
    }

}
