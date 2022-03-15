package cn.scbc.servicevideouploadapi.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/11
 */


public class SecondPassPoJo {

    private String fileMd5;

    @Override
    public String toString() {
        return "SecondPassPoJo{" +
                "fileMd5='" + fileMd5 + '\'' +
                '}';
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }
}
