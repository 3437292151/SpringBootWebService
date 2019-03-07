package service;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description: cc 编码
 */
@Data
public class CcCodingDTO implements Serializable {

    private static final long serialVersionUID = -3628469724795296287L;

    private String id;

    private String name;

    private String largeName;

    private String smallName;

    private String disciplineName;

    private List<CcCodingDescDTO> ccCodingDescList;

    private List<CcCodingAttributeInfoDTO> ccCodingAttributeInfoList;

    public CcCodingDTO(String id, String name, String largeName, String smallName, String disciplineName) {
        this.id = id;
        this.name = name;
        this.largeName = largeName;
        this.smallName = smallName;
        this.disciplineName = disciplineName;
    }

    public CcCodingDTO() {
    }
}
