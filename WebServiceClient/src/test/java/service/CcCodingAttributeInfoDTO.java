package service;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description: cc 属性信息
 */
@Data
public class CcCodingAttributeInfoDTO implements Serializable {

    private static final long serialVersionUID = -3628469724795296287L;

    private String ccId;

    private String attributeName;

    private String attributeGroup;

    private String attributeInfo;

    public CcCodingAttributeInfoDTO(String ccId, String attributeName, String attributeGroup, String attributeInfo) {
        this.ccId = ccId;
        this.attributeName = attributeName;
        this.attributeGroup = attributeGroup;
        this.attributeInfo = attributeInfo;
    }

    public CcCodingAttributeInfoDTO() {

    }
}
