/*
 * Decompiled with CFR 0.150.
 */
package handling.world.weather;

import constants.GameSetConstants;
import handling.channel.ChannelServer;
import handling.login.LoginServer;
import handling.world.World;
import handling.world.weather.WeatherType;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import server.Randomizer;
import tools.MaplePacketCreator;

public class WeatherHandler {
    public static /* synthetic */ boolean weatherSystem;
    public static /* synthetic */ WeatherType currentWeather;
    public static /* synthetic */ long nextTimeChangeWeather;
    public static /* synthetic */ long weatherTime;
    public static /* synthetic */ List<WeatherType> weathers;

    public static /* synthetic */ void changeWeather(WeatherType a2) {
        currentWeather = a2;
    }

    public /* synthetic */ WeatherHandler() {
        WeatherHandler a2;
    }

    public static /* synthetic */ void setWeather(WeatherType a2) {
        currentWeather = a2;
    }

    public static /* synthetic */ void initWeather() {
        int n2;
        WeatherType[] arrweatherType = WeatherType.values();
        int n3 = arrweatherType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            WeatherType weatherType = arrweatherType[n2];
            weathers.add(weatherType);
            n4 = ++n2;
        }
    }

    public static /* synthetic */ void startWeather() {
        if (!weatherSystem) {
            return;
        }
        WeatherHandler.changeWeather();
        WeatherHandler.notice();
        nextTimeChangeWeather = System.currentTimeMillis() + weatherTime;
    }

    public static /* synthetic */ {
        currentWeather = WeatherType.\u7121;
        weathers = new LinkedList<WeatherType>();
        weatherTime = 600000L;
        weatherSystem = GameSetConstants.WEATHER_SYSTEM;
    }

    public static /* synthetic */ WeatherType getWeather() {
        return currentWeather;
    }

    public static /* synthetic */ boolean canStartWeather() {
        return weatherSystem && System.currentTimeMillis() >= nextTimeChangeWeather;
    }

    public static /* synthetic */ void notice() {
        String string = currentWeather.name();
        String string2 = currentWeather.getInfo();
        Iterator<World> iterator = LoginServer.getWorlds().iterator();
        while (iterator.hasNext()) {
            Iterator<ChannelServer> iterator2 = iterator.next().getChannels().iterator();
            while (iterator2.hasNext()) {
                Iterator<ChannelServer> iterator3;
                iterator3.next().broadcastMessage(MaplePacketCreator.yellowChat("[\u5929\u6c23\u7cfb\u7d71]\u5929\u6c23\u8b8a\u5316 " + string + " : " + string2));
                iterator2 = iterator3;
            }
        }
        System.out.println("[\u5929\u6c23\u7cfb\u7d71]\u5929\u6c23\u8b8a\u5316 " + string + " : " + string2);
    }

    public static /* synthetic */ void changeWeather() {
        int n2 = Randomizer.nextInt(weathers.size());
        currentWeather = weathers.get(n2);
    }
}

