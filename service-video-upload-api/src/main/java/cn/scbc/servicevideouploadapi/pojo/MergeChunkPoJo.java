package cn.scbc.servicevideouploadapi.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/11
 */
public class MergeChunkPoJo {

    private String fileType;
    private String fileMd5;
    private String fileName;
    private String number;
    private String fileSize;

    @Override
    public String toString() {
        return "MergeChunkPoJo{" +
                "fileType='" + fileType + '\'' +
                ", fileMd5='" + fileMd5 + '\'' +
                ", fileName='" + fileName + '\'' +
                ", number='" + number + '\'' +
                ", fileSize='" + fileSize + '\'' +
                '}';
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
