package less3_5_dom_z;

public class Road extends Stage{
    public Road(int length) {
       this.length = length;
       this.description = "Road "+ length + "meters";
    }
    @Override
    public void go(Car c)  {
        try {
            System.out.println(c.getName() + " the stage started:  " + description);
            Thread.sleep(length/c.getSpeed() * 1000);
            System.out.println(c.getName() + "finished the stage:" + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
