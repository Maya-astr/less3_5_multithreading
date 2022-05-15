package less3_5_dom_z;

public class Tunnel extends Stage{
    public Tunnel(){
        this.length = 80;
        this.description = "Tunnel" + length + "meters";
    }
    @Override
    public void go(Car c){
        try {
           try {
               System.out.println(c.getName() + "preparing for the stage (waiting):" + description);
               Thread.sleep(length/c.getSpeed() * 1000);
            } catch (InterruptedException e){
               e.printStackTrace();
           }finally {
               System.out.println(c.getName() + "finished the stage:" + description);
           }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
