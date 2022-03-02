package cn.scbc.servicevideouploadapi.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/11
 */


public class MergeChunkPoJo {
    private String fileName;
    private String fileMd5;

    @Override
    public String toString() {
        return "MergeChunkPoJo{" +
                "fileName='" + fileName + '\'' +
                ", fileMd5='" + fileMd5 + '\'' +
                '}';
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }
}
