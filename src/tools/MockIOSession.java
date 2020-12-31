/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBufAllocator
 *  io.netty.channel.Channel
 *  io.netty.channel.Channel$Unsafe
 *  io.netty.channel.ChannelConfig
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelId
 *  io.netty.channel.ChannelMetadata
 *  io.netty.channel.ChannelOutboundBuffer
 *  io.netty.channel.ChannelPipeline
 *  io.netty.channel.ChannelProgressivePromise
 *  io.netty.channel.ChannelPromise
 *  io.netty.channel.EventLoop
 *  io.netty.channel.RecvByteBufAllocator$Handle
 *  io.netty.util.Attribute
 *  io.netty.util.AttributeKey
 */
package tools;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import java.net.SocketAddress;
import scripting.AbstractPlayerInteraction;
import server.MobSkillData;

public class MockIOSession
implements Channel {
    public /* synthetic */ ChannelFuture disconnect(ChannelPromise a2) {
        return null;
    }

    public /* synthetic */ ChannelFuture register(EventLoop a2, ChannelPromise a3) {
        return null;
    }

    public /* synthetic */ ChannelFuture writeAndFlush(Object a2) {
        return null;
    }

    public /* synthetic */ ByteBufAllocator alloc() {
        return null;
    }

    public /* synthetic */ ChannelFuture write(Object a2) {
        return null;
    }

    public /* synthetic */ ChannelFuture close(ChannelPromise a2) {
        return null;
    }

    public /* synthetic */ boolean isRegistered() {
        return false;
    }

    public /* synthetic */ ChannelFuture close() {
        return null;
    }

    public /* synthetic */ ChannelFuture deregister(ChannelPromise a2) {
        return null;
    }

    public /* synthetic */ ChannelPromise voidPromise() {
        return null;
    }

    public /* synthetic */ ChannelPipeline pipeline() {
        return null;
    }

    public /* synthetic */ ChannelFuture closeForcibly() {
        return null;
    }

    public /* synthetic */ boolean isActive() {
        return false;
    }

    public /* synthetic */ ChannelFuture bind(SocketAddress a2) {
        return null;
    }

    public /* synthetic */ Channel flush() {
        return null;
    }

    public /* synthetic */ long bytesBeforeUnwritable() {
        throw new UnsupportedOperationException(MobSkillData.ALLATORIxDEMO(".b\u0014-\u0013x\u0010}\u000f\u007f\u0014h\u0004-\u0019h\u0014#"));
    }

    public /* synthetic */ long bytesBeforeWritable() {
        throw new UnsupportedOperationException(AbstractPlayerInteraction.ALLATORIxDEMO("\u0018n\"!%t&q9s\"d2!/d\"/"));
    }

    public /* synthetic */ RecvByteBufAllocator.Handle recvBufAllocHandle() {
        return null;
    }

    public /* synthetic */ ChannelFuture writeAndFlush(Object a2, ChannelPromise a3) {
        return null;
    }

    public /* synthetic */ Channel parent() {
        return null;
    }

    public /* synthetic */ SocketAddress remoteAddress() {
        return null;
    }

    public /* synthetic */ EventLoop eventLoop() {
        return null;
    }

    public /* synthetic */ ChannelFuture newFailedFuture(Throwable a2) {
        return null;
    }

    public /* synthetic */ ChannelFuture newSucceededFuture() {
        return null;
    }

    public /* synthetic */ int compareTo(Channel a2) {
        return 0;
    }

    public /* synthetic */ ChannelFuture disconnect() {
        return null;
    }

    public /* synthetic */ ChannelPromise newPromise() {
        return null;
    }

    public /* synthetic */ ChannelFuture closeFuture() {
        return null;
    }

    public /* synthetic */ SocketAddress localAddress() {
        return null;
    }

    public /* synthetic */ MockIOSession() {
        MockIOSession a2;
    }

    public /* synthetic */ ChannelFuture bind(SocketAddress a2, ChannelPromise a3) {
        return null;
    }

    public /* synthetic */ ChannelOutboundBuffer outboundBuffer() {
        return null;
    }

    public /* synthetic */ ChannelFuture beginRead() {
        return null;
    }

    public /* synthetic */ ChannelFuture connect(SocketAddress a2, ChannelPromise a3) {
        return null;
    }

    public /* synthetic */ boolean isWritable() {
        return false;
    }

    public /* synthetic */ Channel read() {
        return null;
    }

    public /* synthetic */ ChannelFuture connect(SocketAddress a2) {
        return null;
    }

    public /* synthetic */ boolean isOpen() {
        return false;
    }

    public /* synthetic */ <T> boolean hasAttr(AttributeKey<T> a2) {
        return false;
    }

    public /* synthetic */ ChannelFuture connect(SocketAddress a2, SocketAddress a3, ChannelPromise a4) {
        return null;
    }

    public /* synthetic */ ChannelProgressivePromise newProgressivePromise() {
        return null;
    }

    public /* synthetic */ <T> Attribute<T> attr(AttributeKey<T> a2) {
        return null;
    }

    public /* synthetic */ ChannelId id() {
        return null;
    }

    public /* synthetic */ ChannelFuture deregister() {
        return null;
    }

    public /* synthetic */ ChannelMetadata metadata() {
        return null;
    }

    public /* synthetic */ ChannelFuture connect(SocketAddress a2, SocketAddress a3) {
        return null;
    }

    public /* synthetic */ ChannelConfig config() {
        return null;
    }

    public /* synthetic */ ChannelFuture write(Object a2, ChannelPromise a3) {
        return null;
    }

    public /* synthetic */ Channel.Unsafe unsafe() {
        return null;
    }
}

