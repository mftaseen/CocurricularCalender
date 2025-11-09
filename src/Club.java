import java.util.Scanner;

public class Club {
    public String clubName;
    public String clubAbbr;
    public String clubDescription;
    public String clubWebsite;
    public String clubEmail;
    public String clubPhone;
    public String [] clubPrez = new String[2];
    public String [] clubGS = new String[2];

    public String password;

    public Club() {
    }

    public boolean newClub() {
        Club Club = new Club();
        Scanner Input = new Scanner(System.in);
        System.out.println("======== New Club Registration ========");
        System.out.print("Enter Club Name: ");
        Club.clubName = Input.nextLine();
        System.out.print("Enter Club Abbreviation: ");
        Club.clubAbbr = Input.nextLine();
        System.out.print("Enter Club Description: ");
        Club.clubDescription = Input.nextLine();
        System.out.print("Enter Club Website: ");
        Club.clubWebsite = Input.nextLine();
        System.out.print("Enter Club Email: ");
        Club.clubEmail = Input.nextLine();
        System.out.print("Enter Club Phone: ");
        Club.clubPhone = Input.nextLine();
        System.out.print("Enter the Name of Club President: ");
        Club.clubPrez[0] = Input.nextLine();
        System.out.print("Enter the Name of Club General Secretary: ");
        Club.clubGS[0] = Input.nextLine();
        System.out.print("Club Year: ");
        String year = Input.nextLine();
        Club.clubGS[1] = year;
        Club.clubPrez[1] = year;
        System.out.print("Enter the Initial Login Password: ");
        Club.password = Input.nextLine();
        System.out.println("Club Registration Successful!\nUsername: " + this.clubEmail + "\nPassword: " + this.password);
        return true;
    }

    public boolean passChange() {
        Scanner Input = new Scanner(System.in);
        System.out.print("Enter the Present Password: ");
        String password = Input.nextLine();
        if (password.equals(this.password)) {
            System.out.print("New Password: ");
            this.password = Input.nextLine();
            System.out.println("Password Changed Successfully!");
            return true;
        }
        else {
            System.err.println("Incorrect Password!");
            return false;
        }
    }
}