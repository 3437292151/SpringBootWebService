package service;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description:
 */
@Data
public class CcCodingDescDTO implements Serializable {
    private static final long serialVersionUID = -3628469724795296287L;

    private String ccId;

    private String language;

    private String shortDesc;

    private String longDesc;

    public CcCodingDescDTO(String ccId, String language, String shortDesc, String longDesc) {
        this.ccId = ccId;
        this.language = language;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }

    public CcCodingDescDTO() {
    }
}
