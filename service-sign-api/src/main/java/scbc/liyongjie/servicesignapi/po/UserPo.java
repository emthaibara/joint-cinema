package scbc.liyongjie.servicesignapi.po;
/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 */
public class UserPo {
    private String uuid;

    private String name;

    private String pwdsalt;

    private String avatar;

    private String date;

    private String pwdshash;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwdsalt() {
        return pwdsalt;
    }

    public void setPwdsalt(String pwdsalt) {
        this.pwdsalt = pwdsalt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPwdshash() {
        return pwdshash;
    }

    public void setPwdshash(String pwdshash) {
        this.pwdshash = pwdshash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", name=").append(name);
        sb.append(", pwdsalt=").append(pwdsalt);
        sb.append(", avatar=").append(avatar);
        sb.append(", date=").append(date);
        sb.append(", pwdshash=").append(pwdshash);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserPo other = (UserPo) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPwdsalt() == null ? other.getPwdsalt() == null : this.getPwdsalt().equals(other.getPwdsalt()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getPwdshash() == null ? other.getPwdshash() == null : this.getPwdshash().equals(other.getPwdshash()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPwdsalt() == null) ? 0 : getPwdsalt().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getPwdshash() == null) ? 0 : getPwdshash().hashCode());
        return result;
    }
}