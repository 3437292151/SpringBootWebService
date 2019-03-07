package service;



import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description: cc 编码服务
 */
@WebService(targetNamespace="http://service.yu.com")
public interface CcCodingService {

    @WebMethod
    String saveCcCoding(List<CcCodingDTO> CcCodingArray);
}
