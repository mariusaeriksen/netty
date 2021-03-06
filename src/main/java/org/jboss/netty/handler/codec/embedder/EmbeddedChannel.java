/*
 * Copyright 2009 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.netty.handler.codec.embedder;

import java.net.SocketAddress;

import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.ChannelConfig;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.DefaultChannelConfig;

/**
 * TODO Make EmbeddedChannel implement ChannelConfig and ChannelSink to reduce overhead.
 * TODO Do not extend AbstractChannel to reduce overhead and remove the internal-use-only constructor in AbstractChannel.
 *
 * @author <a href="http://www.jboss.org/netty/">The Netty Project</a>
 * @author <a href="http://gleamynode.net/">Trustin Lee</a>
 */
class EmbeddedChannel extends AbstractChannel {

    private static final Integer DUMMY_ID = Integer.valueOf(0);

    private final ChannelConfig config;
    private final SocketAddress localAddress = new EmbeddedSocketAddress();
    private final SocketAddress remoteAddress = new EmbeddedSocketAddress();

    EmbeddedChannel(ChannelPipeline pipeline, ChannelSink sink) {
        super(DUMMY_ID, null, EmbeddedChannelFactory.INSTANCE, pipeline, sink);
        config = new DefaultChannelConfig();
    }

    @Override
    public ChannelConfig getConfig() {
        return config;
    }

    @Override
    public SocketAddress getLocalAddress() {
        return localAddress;
    }

    @Override
    public SocketAddress getRemoteAddress() {
        return remoteAddress;
    }

    @Override
    public boolean isBound() {
        return true;
    }

    @Override
    public boolean isConnected() {
        return true;
    }
}
