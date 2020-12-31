/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleClient;
import java.util.HashMap;
import scripting.AbstractPlayerInteraction;
import server.Randomizer;
import tools.Pair;
import tools.data.LittleEndianAccessor;
import tools.packet.BeansPacket;

public class BeanGame {
    public static final /* synthetic */ void BeansGameAction(LittleEndianAccessor a2, MapleClient a3) {
        MapleCharacter mapleCharacter = a3.getPlayer();
        byte by = a2.readByte();
        switch (by) {
            case 0: {
                return;
            }
            case 1: {
                mapleCharacter.setBeansStatus(true);
                return;
            }
            case 2: {
                mapleCharacter.updateBeans();
                return;
            }
            case 3: {
                LittleEndianAccessor littleEndianAccessor = a2;
                int n2 = littleEndianAccessor.readInt();
                littleEndianAccessor.readInt();
                a2.readInt();
                if (mapleCharacter.getBeansLight() < 7) {
                    mapleCharacter.addBeansLight();
                }
                a3.sendPacket(BeansPacket.setLightLevel(mapleCharacter.getBeansLight()));
                return;
            }
            case 4: {
                if (mapleCharacter.getBeansLight() == 0) break;
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.setBeansLight(mapleCharacter2.getBeansLight() - 1);
                mapleCharacter2.setCanGainBeansReward(true);
                boolean bl = Randomizer.nextBoolean();
                MapleCharacter mapleCharacter3 = mapleCharacter;
                a3.sendPacket(BeansPacket.spinTest(mapleCharacter3.getBeansLight(), bl));
                mapleCharacter3.setBeanResult(bl);
                return;
            }
            case 5: {
                if (mapleCharacter.getBeanResult()) {
                    if (!mapleCharacter.CanUseBeans() || !mapleCharacter.canGainBeansReward()) break;
                    MapleCharacter mapleCharacter4 = mapleCharacter;
                    mapleCharacter4.setCanGainBeansReward(false);
                    int n3 = Randomizer.rand(0, mapleCharacter.getBeanConsume() * 2);
                    a3.sendPacket(BeansPacket.rewardBalls(n3));
                    mapleCharacter4.gainBeans(n3);
                    mapleCharacter4.setBeanConsume(0);
                    return;
                }
                mapleCharacter.dropMessage(-1, AbstractPlayerInteraction.ALLATORIxDEMO("\u597c\u53b9\u60dd\u6cc4\u4e2c\u7318\u007f\u51db\u63a4\u51db\u53b3w "));
                return;
            }
            case 6: {
                if (!mapleCharacter.CanUseBeans()) break;
                a2.readByte();
                byte by2 = a2.readByte();
                if (mapleCharacter.getBeans() <= 0) {
                    mapleCharacter.resetBeans();
                    a3.sendPacket(BeansPacket.exitBeans());
                    return;
                }
                if (by2 < 0) break;
                MapleCharacter mapleCharacter5 = mapleCharacter;
                mapleCharacter5.gainBeans(-by2);
                mapleCharacter5.gainBeanConsume(by2);
                mapleCharacter5.updateBeans();
                return;
            }
            case 7: {
                if (!mapleCharacter.CanUseBeans() || !mapleCharacter.canGainBeansReward()) break;
                a2.readInt();
                int n4 = a2.readInt();
                if (mapleCharacter.getBeansStage() == 0) {
                    mapleCharacter.setBeansTime(n4);
                }
                if (n4 - mapleCharacter.getBeansTime() > 10000) {
                    a3.sendPacket(BeansPacket.rewardBalls(0, 5));
                    mapleCharacter.setBeansStage(0);
                    return;
                }
                if (n4 - mapleCharacter.getBeansTime() > 5000) {
                    mapleCharacter.setBeansStage(4);
                    a3.sendPacket(BeansPacket.rewardBalls(100, 4));
                    mapleCharacter.gainBeans(100);
                    return;
                }
                mapleCharacter.setBeansStage(1);
                a3.sendPacket(BeansPacket.rewardBalls(100, 1));
                mapleCharacter.gainBeans(100);
                return;
            }
            default: {
                System.out.println("\u672a\u8655\u7406\u7684\u985e\u578b\u3010" + by + "\u3011\n\u5305" + a2.toString());
            }
        }
    }

    public static final /* synthetic */ Pair<Integer, Integer> getSpinResult(boolean a2) {
        int n2 = Randomizer.rand(1, 10);
        int n3 = Randomizer.rand(1, 10);
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(1, 2);
        hashMap.put(2, 4);
        hashMap.put(3, 6);
        hashMap.put(4, 9);
        hashMap.put(5, 1);
        hashMap.put(6, 3);
        hashMap.put(7, 5);
        hashMap.put(8, 8);
        hashMap.put(9, 7);
        hashMap.put(10, 10);
        if (!a2) {
            return new Pair<Integer, Integer>(n2, n3);
        }
        return new Pair<Integer, Integer>(n2, (Integer)hashMap.get(n2));
    }

    public static final /* synthetic */ void BeansUpdate(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient = a3;
        mapleClient.getPlayer().resetBeans();
        mapleClient.sendPacket(BeansPacket.exitBeans());
    }

    public /* synthetic */ BeanGame() {
        BeanGame a2;
    }
}

