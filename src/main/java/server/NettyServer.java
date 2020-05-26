package server;

import codec.PacketDecoder;
import codec.PacketEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import server.handler.LoginRequestHandler;
import server.handler.MessageRequestHandler;

public class NettyServer {

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {

                        ch.pipeline().addLast(new PacketEncoder())
                                .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 7, 4))
                                .addLast(new PacketDecoder())
                                .addLast(new LoginRequestHandler())
                                .addLast(new MessageRequestHandler());
                    }
                });
        bind(serverBootstrap, 8000);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("端口：" + port + "绑定成功");
                } else {
                    System.out.println("端口：" + port + "绑定失败");
                    bind(serverBootstrap, port + 1);
                }
            }
        });
    }
}
