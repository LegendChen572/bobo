/*
 * Decompiled with CFR 0.150.
 */
package server.Auction;

import server.Auction.AuctionItemFactory;

public class AuctionItemData {
    private /* synthetic */ String a;
    private final /* synthetic */ long g;
    private final /* synthetic */ int H;
    private final /* synthetic */ int e;
    private /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int B;
    private final /* synthetic */ int k;
    private /* synthetic */ int d;
    private final /* synthetic */ long E;
    private final /* synthetic */ int K;

    public /* synthetic */ long getEndTime() {
        AuctionItemData a2;
        return a2.g;
    }

    public /* synthetic */ AuctionItemData(int a2, int a3, int a4, int a5, int a6, int a7, int a8, long a9, long a10, String a11) {
        AuctionItemData a12;
        AuctionItemData auctionItemData = a12;
        AuctionItemData auctionItemData2 = a12;
        AuctionItemData auctionItemData3 = a12;
        AuctionItemData auctionItemData4 = a12;
        AuctionItemData auctionItemData5 = a12;
        auctionItemData5.e = a2;
        auctionItemData5.H = a3;
        auctionItemData4.ALLATORIxDEMO = a4;
        auctionItemData4.B = a5;
        auctionItemData3.k = a6;
        auctionItemData3.K = a7;
        auctionItemData2.d = a8;
        auctionItemData2.E = a9;
        auctionItemData.g = a10;
        auctionItemData.a = a11;
    }

    public /* synthetic */ void setWinner(String a2) {
        a.a = a2;
        AuctionItemFactory.change = true;
    }

    public /* synthetic */ int getBiddingItem() {
        AuctionItemData a2;
        return a2.B;
    }

    public /* synthetic */ int getBiddingStartCount() {
        AuctionItemData a2;
        return a2.k;
    }

    public /* synthetic */ int getBiddingKnife() {
        AuctionItemData a2;
        return a2.K;
    }

    public /* synthetic */ int getID() {
        AuctionItemData a2;
        return a2.e;
    }

    public /* synthetic */ int getBiddingNowCount() {
        AuctionItemData a2;
        return a2.d;
    }

    public /* synthetic */ int getItemId() {
        AuctionItemData a2;
        return a2.H;
    }

    public /* synthetic */ void setCount(int a2) {
        a.ALLATORIxDEMO = a2;
        AuctionItemFactory.change = true;
    }

    public /* synthetic */ long getStartTime() {
        AuctionItemData a2;
        return a2.E;
    }

    public /* synthetic */ void setBiddingNowCount(int a2) {
        a.d = a2;
        AuctionItemFactory.change = true;
    }

    public /* synthetic */ int getCount() {
        AuctionItemData a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ String getWinner() {
        AuctionItemData a2;
        return a2.a;
    }
}

