package net.moddity.droidnubekit.responsemodels;

/**
 * Created by jaume on 12/6/15.
 */
public class DNKUnauthorizedResponse {

    private String uuid;
    private String serverErrorCode;
    private String reason;
    private String redirectURL;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getServerErrorCode() {
        return serverErrorCode;
    }

    public void setServerErrorCode(String serverErrorCode) {
        this.serverErrorCode = serverErrorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectUrl(String redirectURL) {
        this.redirectURL = redirectURL;
    }
}
