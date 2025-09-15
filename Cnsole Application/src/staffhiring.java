public class staffhiring extends Staff{

            public staffhiring(int NumberStaff, String StaffLocation) {
                super(NumberStaff, StaffLocation);
            }

            @Override
            public int getNumberStaff() {
                return super.getNumberStaff();
            }

            @Override
            public void setNumberStaff(int numberStaff) {
                super.setNumberStaff(numberStaff);
            }

            @Override
            public String getStaffLocation() {
                return super.getStaffLocation();
            }

            @Override
            public void setStaffLocation(String staffLocation) {
                super.setStaffLocation(staffLocation);
            }

            @Override
            public String getStaffHiringProcess() {
                if (NumberStaff<50){
                    return "Hire more staff at"+ StaffLocation + "current staff: "+NumberStaff;
                }else {
                    return "No hiring required at"+ StaffLocation + "current staff: "+NumberStaff;
                }

            }
        }

    }

