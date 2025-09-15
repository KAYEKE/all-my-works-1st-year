public class Main {
    public static void main(String[] args){
        String getStaffHiringProcess;
        StaffHiring staff1= new StaffHiring(30, "cape town");
        StaffHiring staff2= new StaffHiring(30, "Durban");

        System.out.println(staff1.getStaffHiringProcess());
        System.out.println(staff2.getStaffHiringProcess());
    }

}

