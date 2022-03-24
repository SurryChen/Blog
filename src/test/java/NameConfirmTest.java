import com.example.blog.dao.UserInformationConfirmDao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NameConfirmTest {
    public static void main(String[] args) throws Exception {
        UserInformationConfirmDao user = new UserInformationConfirmDao();
        boolean flag = user.nameConfirm("无");
        System.out.println(flag);
    }
}
