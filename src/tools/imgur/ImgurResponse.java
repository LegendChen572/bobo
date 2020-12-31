/*
 * Decompiled with CFR 0.150.
 */
package tools.imgur;

import tools.imgur.Data;

public class ImgurResponse {
    private Data data;
    private boolean success;
    private int status;

    public ImgurResponse() {
    }

    public ImgurResponse(Data data, boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

