Import java.util.Scanner;
Public class Main {
    Private static void
    Public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String surname;
        String emailAdress;
        String studentNo;
        short mark1;
        short mark2;
        short assignment;
        short exam;

        System.out.println(“Please enter the name”);
        name = scanner.nextLine();
        System.out.println(“Please enter the surname”);
        surname = scanner.nextLine();
        System.out.println(“Please enter the email Adress”);
        emailAdress = scanner.nextLine();
        System.out.println(“Please enter the student Number”);
        studentNo = scanner.nextLine();
        System.out.println(“Please enter mark1”);
        mark1 = scanner.nextshort();
        System.out.println(“Please enter mark2”);
        mark2 = scanner.nextshort();
        System.out.println(“Please enter assignment”);
        assignment = scanner.nextshort();
        System.out.println(“Please enter exam”);
        exam = scanner.nextshort();

// condition
        if(FinalMark>=0 & FinalMark<=46)
            System.out.println(“fail”);
        If(FinalMark=47 & FinalMark=49
                System.out.println(“supp”);
        If(FinalMark>=54 & FinalMark>=70
                System.out.println(“pass”);


        double DpMark = (CalculateFinalMark+mark1+mark2+assignment);
        System.out.println(“DpMark:”+DpMark);

        double FinalMark = CalculateFinalMark(DpMark, exam);
        System.out.println(“FinalMark:”+FinalMark);

    }
    Public static double CalculateDpMark(short mark1, short mark2, short assignment) {
        Return ((double) (mark1 + mark2 + assignment) / 3)
    }
    {
        Public static double CalculateFinalMark(double DpMark, short exam) {
        Return ((DpMark *0.4) +(exam*0.6))
    }
    }
}



