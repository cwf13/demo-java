package cooc.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class ZaMall {
    private Long id;

    private String title;

    private String des;

    private Integer denomination;

    private BigDecimal paymoney;

    private String logo;

    private Integer type;

    private Integer isuse;

    private Integer cycle;

    private Integer roomcard;

    private Integer coins;

    private Integer status;

    private String platform;

    private Date createtime;

    private String memo;

    private Integer viproomcard;

    private Long viprank;

    private Integer vipcoins;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public Integer getDenomination() {
        return denomination;
    }

    public void setDenomination(Integer denomination) {
        this.denomination = denomination;
    }

    public BigDecimal getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsuse() {
        return isuse;
    }

    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Integer getRoomcard() {
        return roomcard;
    }

    public void setRoomcard(Integer roomcard) {
        this.roomcard = roomcard;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getViproomcard() {
        return viproomcard;
    }

    public void setViproomcard(Integer viproomcard) {
        this.viproomcard = viproomcard;
    }

    public Long getViprank() {
        return viprank;
    }

    public void setViprank(Long viprank) {
        this.viprank = viprank;
    }

    public Integer getVipcoins() {
        return vipcoins;
    }

    public void setVipcoins(Integer vipcoins) {
        this.vipcoins = vipcoins;
    }
}