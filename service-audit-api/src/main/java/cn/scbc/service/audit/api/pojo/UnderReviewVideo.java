package cn.scbc.service.audit.api.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/15
 */


public class UnderReviewVideo {

    private String uuid;

    private String originPath;

    private String buildDashPath;

    private String thumbnailPath;

    private String fileType;

    private String fileMd5;

    private String fileName;

    private String number;

    private String fileSize;

    private String duration;

    private String uploadDate;

    private String storeHouseUUID;

    private String auditVideoAccessPath;

    public String getAuditVideoAccessPath() {
        return auditVideoAccessPath;
    }

    public void setAuditVideoAccessPath(String auditVideoAccessPath) {
        this.auditVideoAccessPath = auditVideoAccessPath;
    }

    public String getStoreHouseUUID() {
        return storeHouseUUID;
    }

    public void setStoreHouseUUID(String storeHouseUUID) {
        this.storeHouseUUID = storeHouseUUID;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOriginPath() {
        return originPath;
    }

    public void setOriginPath(String originPath) {
        this.originPath = originPath;
    }

    public String getBuildDashPath() {
        return buildDashPath;
    }

    public void setBuildDashPath(String buildDashPath) {
        this.buildDashPath = buildDashPath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
