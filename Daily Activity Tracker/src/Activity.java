public class Activity{
    protected String name;
    protected int duration;

    public Activity() {
    }
    public Activity(String name, int duration){
        this.name=name;
        this.duration=duration;
    }

    public String getBasicDetails(){
        return "Activity"+name+"duration"+duration+"mins";

}
}
