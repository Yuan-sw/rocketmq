/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.remoting.netty;

public class NettyServerConfig implements Cloneable {
    /**
     * 监听的端口号，默认 8888
     */
    private int listenPort = 8888;
    /**
     * 业务线程池的线程个数，RocketMQ 按任务类型，每个任务类型会拥有一个专门的线程池，
     * 比如发送消息，消费消息，另外再加一个其他线程池（默认的业务线程池）
     * 线程名称：RemotingExecutorThread_
     * 作用范围：该参数目前主要用于 NameServer 的默认业务线程池，处理诸如 broker、producer,consume 与 NameServer 的所有交互命令。
     */
    private int serverWorkerThreads = 8;
    /**
     * Netty public 任务线程池容量，最少4个
     * 线程名称：NettyServerPublicExecutor_
     */
    private int serverCallbackExecutorThreads = 0;
    /**
     * Netty IO 线程个数，Selector 所在的线程个数，也就主从 Reactor 模型中的从 Reactor 线程数量
     * 线程名称：NettyServerNIOSelector_
     * 作用范围：broker,product,consume 服务端的IO线程数量。
     */
    private int serverSelectorThreads = 3;
    /**
     * 服务端 oneWay(单向执行)的信号量（并发度）
     */
    private int serverOnewaySemaphoreValue = 256;
    /**
     * 服务端 Async（异步调用）的信号量（并发度）
     */
    private int serverAsyncSemaphoreValue = 64;
    /**
     * 通道空闲时间，默认120S, 通过Netty的IdleStateHandler实现
     */
    private int serverChannelMaxIdleTimeSeconds = 120;
    /**
     * socket发送缓存区大小
     */
    private int serverSocketSndBufSize = NettySystemConfig.socketSndbufSize;
    /**
     * socket接收缓存区大小
     */
    private int serverSocketRcvBufSize = NettySystemConfig.socketRcvbufSize;
    /**
     * 是否使用PooledByteBuf(可重用，缓存ByteBuf)
     */
    private boolean serverPooledByteBufAllocatorEnable = true;

    /**
     * make make install
     *
     *
     * ../glibc-2.10.1/configure \ --prefix=/usr \ --with-headers=/usr/include \
     * --host=x86_64-linux-gnu \ --build=x86_64-pc-linux-gnu \ --without-gd
     */
    private boolean useEpollNativeSelector = false;

    public int getListenPort() {
        return listenPort;
    }

    public void setListenPort(int listenPort) {
        this.listenPort = listenPort;
    }

    public int getServerWorkerThreads() {
        return serverWorkerThreads;
    }

    public void setServerWorkerThreads(int serverWorkerThreads) {
        this.serverWorkerThreads = serverWorkerThreads;
    }

    public int getServerSelectorThreads() {
        return serverSelectorThreads;
    }

    public void setServerSelectorThreads(int serverSelectorThreads) {
        this.serverSelectorThreads = serverSelectorThreads;
    }

    public int getServerOnewaySemaphoreValue() {
        return serverOnewaySemaphoreValue;
    }

    public void setServerOnewaySemaphoreValue(int serverOnewaySemaphoreValue) {
        this.serverOnewaySemaphoreValue = serverOnewaySemaphoreValue;
    }

    public int getServerCallbackExecutorThreads() {
        return serverCallbackExecutorThreads;
    }

    public void setServerCallbackExecutorThreads(int serverCallbackExecutorThreads) {
        this.serverCallbackExecutorThreads = serverCallbackExecutorThreads;
    }

    public int getServerAsyncSemaphoreValue() {
        return serverAsyncSemaphoreValue;
    }

    public void setServerAsyncSemaphoreValue(int serverAsyncSemaphoreValue) {
        this.serverAsyncSemaphoreValue = serverAsyncSemaphoreValue;
    }

    public int getServerChannelMaxIdleTimeSeconds() {
        return serverChannelMaxIdleTimeSeconds;
    }

    public void setServerChannelMaxIdleTimeSeconds(int serverChannelMaxIdleTimeSeconds) {
        this.serverChannelMaxIdleTimeSeconds = serverChannelMaxIdleTimeSeconds;
    }

    public int getServerSocketSndBufSize() {
        return serverSocketSndBufSize;
    }

    public void setServerSocketSndBufSize(int serverSocketSndBufSize) {
        this.serverSocketSndBufSize = serverSocketSndBufSize;
    }

    public int getServerSocketRcvBufSize() {
        return serverSocketRcvBufSize;
    }

    public void setServerSocketRcvBufSize(int serverSocketRcvBufSize) {
        this.serverSocketRcvBufSize = serverSocketRcvBufSize;
    }

    public boolean isServerPooledByteBufAllocatorEnable() {
        return serverPooledByteBufAllocatorEnable;
    }

    public void setServerPooledByteBufAllocatorEnable(boolean serverPooledByteBufAllocatorEnable) {
        this.serverPooledByteBufAllocatorEnable = serverPooledByteBufAllocatorEnable;
    }

    public boolean isUseEpollNativeSelector() {
        return useEpollNativeSelector;
    }

    public void setUseEpollNativeSelector(boolean useEpollNativeSelector) {
        this.useEpollNativeSelector = useEpollNativeSelector;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (NettyServerConfig) super.clone();
    }
}
