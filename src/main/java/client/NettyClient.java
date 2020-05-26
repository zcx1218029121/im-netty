package client;

import client.FirstClientHandler;
import client.handler.LoginResponseHandler;
import client.handler.MessageResponseHandler;
import codec.PacketDecoder;
import codec.PacketEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import protocol.PacketCodeC;
import protocol.request.LoginRequestPacket;
import protocol.request.MessageRequestPacket;
import util.LoginUtil;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NettyClient {

    /**
     * 最大重试次数
     */
    private static int MAX_RETRY = 10;

    public static void main(String[] args) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();


        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline()
                                .addLast(new PacketDecoder())
                                .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 7, 4))
                                .addLast(new LoginResponseHandler())
                                .addLast(new MessageResponseHandler())
                                .addLast(new PacketEncoder());
                    }
                });

        Channel channel = connect(bootstrap, "127.0.0.1", 8000, MAX_RETRY);


    }

    /**
     * 指数退避重连机制
     *
     * @param bootstrap
     * @param host
     * @param port
     * @param retry
     * @return
     */
    private static Channel connect(Bootstrap bootstrap, String host, int port, int retry) {
        return bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功!");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
                System.err.println("重试次数用尽，放弃连接");

            } else {
                int order = (MAX_RETRY - retry) + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.err.println("重试时间" + delay);
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit.SECONDS);
            }
        }).channel();
    }

    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (LoginUtil.hasLogin(channel)) {
                    System.out.println("输入消息发送至服务端: ");
                    Scanner sc = new Scanner(System.in);
                    String line = sc.nextLine();

                    channel.writeAndFlush(new MessageRequestPacket(line));
                }
            }
        }).start();
    }

}
