package scbc.liyongjie.nettywebsocketserverhome.po;

public class Friend {
    private String me;

    private String friend;

    public String getMe() {
        return me;
    }

    public void setMe(String me) {
        this.me = me;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", me=").append(me);
        sb.append(", friend=").append(friend);
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
        Friend other = (Friend) that;
        return (this.getMe() == null ? other.getMe() == null : this.getMe().equals(other.getMe()))
            && (this.getFriend() == null ? other.getFriend() == null : this.getFriend().equals(other.getFriend()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMe() == null) ? 0 : getMe().hashCode());
        result = prime * result + ((getFriend() == null) ? 0 : getFriend().hashCode());
        return result;
    }
}