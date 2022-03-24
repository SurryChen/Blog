import com.example.blog.dao.UserInformationConfirmDao;
import org.junit.jupiter.api.Test;

public class UserInformationTest {
    /**
     * true是说明存在该用户，false是说明不存在该用户
     * @throws Exception
     */
    @Test
    public void nameAccountTest() throws Exception {
        boolean test_two = new UserInformationConfirmDao().nameConfirm("无妄子");
        System.out.println(test_two);
        boolean test_one = new UserInformationConfirmDao().accountConfirm("123456");
        System.out.println(test_one);
    }
}
