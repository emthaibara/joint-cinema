package cn.scbc.servicevideouploadapi.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/11
 */


public class SecondPassPoJo {

    private String fileMd5;
    private String fileType;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }
}
