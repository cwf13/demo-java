package cooc.demo.model;

public class ZaVersion {
    private Long id;

    private String version;

    private Integer isshop;

    private Integer isvisiter;

    private Integer ismemu;

    private String url;

    private String platform;

    private String memo;

    private String mch;

    private String key;

    private String thirdpay;

    private String veurl;

    private String thirdurl;

    private String orderurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getIsshop() {
        return isshop;
    }

    public void setIsshop(Integer isshop) {
        this.isshop = isshop;
    }

    public Integer getIsvisiter() {
        return isvisiter;
    }

    public void setIsvisiter(Integer isvisiter) {
        this.isvisiter = isvisiter;
    }

    public Integer getIsmemu() {
        return ismemu;
    }

    public void setIsmemu(Integer ismemu) {
        this.ismemu = ismemu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getMch() {
        return mch;
    }

    public void setMch(String mch) {
        this.mch = mch == null ? null : mch.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getThirdpay() {
        return thirdpay;
    }

    public void setThirdpay(String thirdpay) {
        this.thirdpay = thirdpay == null ? null : thirdpay.trim();
    }

    public String getVeurl() {
        return veurl;
    }

    public void setVeurl(String veurl) {
        this.veurl = veurl == null ? null : veurl.trim();
    }

    public String getThirdurl() {
        return thirdurl;
    }

    public void setThirdurl(String thirdurl) {
        this.thirdurl = thirdurl == null ? null : thirdurl.trim();
    }

    public String getOrderurl() {
        return orderurl;
    }

    public void setOrderurl(String orderurl) {
        this.orderurl = orderurl == null ? null : orderurl.trim();
    }
}