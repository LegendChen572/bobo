/*
 * Decompiled with CFR 0.150.
 */
package ecpay.payment.integration.exception;

public class EcpayException
extends Error {
    private static final long serialVersionUID = 1L;
    String NewExceptionMessage;

    public EcpayException(String s2) {
        this.NewExceptionMessage = s2;
    }

    public String getNewExceptionMessage() {
        return this.NewExceptionMessage;
    }

    public void setNewExceptionMessage(String newExceptionMessage) {
        this.NewExceptionMessage = newExceptionMessage;
    }

    public void ShowExceptionMessage() {
        System.out.println("\u767c\u751f\u932f\u8aa4: " + this.getNewExceptionMessage());
    }
}

