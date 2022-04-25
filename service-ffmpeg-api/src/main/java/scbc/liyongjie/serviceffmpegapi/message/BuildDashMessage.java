package scbc.liyongjie.serviceffmpegapi.message;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/15
 */

public class BuildDashMessage {
    private String uuid;
    private String buildDashPath;
    private String originPath;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBuildDashPath() {
        return buildDashPath;
    }

    public void setBuildDashPath(String buildDashPath) {
        this.buildDashPath = buildDashPath;
    }

    public String getOriginPath() {
        return originPath;
    }

    public void setOriginPath(String originPath) {
        this.originPath = originPath;
    }
}
