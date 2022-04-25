package scbc.liyongjie.nettywebsocketserverhome.po;

public class User {
    private String number;

    private String name;

    private String pwdsalt;

    private String avatar;

    private String date;

    private String pwdshash;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        sb.append(", number=").append(number);
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
        User other = (User) that;
        return (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
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
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPwdsalt() == null) ? 0 : getPwdsalt().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getPwdshash() == null) ? 0 : getPwdshash().hashCode());
        return result;
    }
}