import java.util.*;

public class ClubManager {
    List<Club> clubList = new ArrayList<>();

    public void addClub(Club club) {
        clubList.add(club);
    }

    public List<Club> getClubList(String srcfilename, String destfilename) {
        FileManager fManager = new FileManager();
        clubList = fManager.loadEncryptedList(srcfilename);
        fManager.exportToTxt();
        return clubList;
    }
}
