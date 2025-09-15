
    public abstract class Staff {
        public abstract int getNumberStaff();

        public abstract void setNumberStaff(int numberStaff);

        public abstract String getStaffLocation();

        public abstract void setStaffLocation(String staffLocation);

        public abstract String getStaffHiringProcess();
        abstract class Staff implements iStaff{

            protected int NumberStaff;
            protected String StaffLocation;

            public Staff(int NumberStaff, String StaffLocation){
                this.NumberStaff=NumberStaff;
                this.StaffLocation=StaffLocation;

            }
            @Override
            public int getNumberStaff() {
                return NumberStaff;
            }

            public void setNumberStaff(int numberStaff) {
                NumberStaff = numberStaff;
            }
            @Override
            public String getStaffLocation() {
                return StaffLocation;
            }

            public void setStaffLocation(String staffLocation) {
                StaffLocation = staffLocation;
            }


        }


    }

}
