package scbc.liyongjie.servicesignapi.po;

public class StoreHousePo {
    private String number;

    private String storehouse;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(String storehouse) {
        this.storehouse = storehouse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", number=").append(number);
        sb.append(", storehouse=").append(storehouse);
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
        StoreHousePo other = (StoreHousePo) that;
        return (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getStorehouse() == null ? other.getStorehouse() == null : this.getStorehouse().equals(other.getStorehouse()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getStorehouse() == null) ? 0 : getStorehouse().hashCode());
        return result;
    }
}