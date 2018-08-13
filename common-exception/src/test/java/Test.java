import com.vigoss.shop.common.exception.ShopException;
import com.vigoss.shop.common.exception.common.NetworkException;

/**
 * @Author:czq
 * @Description:
 * @Date: 12:53 2018/5/21
 * @Modified By:
 */
public class Test {
    @org.junit.Test
    public void test1(){
        try {
            throw new NetworkException();
        }catch (ShopException s){
            System.out.println(s.printMsg());
        }
    }
}
