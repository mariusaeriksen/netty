/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005-2008, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.netty.handler.codec.http;

import java.util.Set;
import java.util.HashSet;

/**
 * @author <a href="mailto:andy.taylor@jboss.org">Andy Taylor</a>
 */
public class HttpCookieDecoder {
    private final static String semicolon = ";";

    private final static String equals = "=";

    public Set<HttpCookie> decode(String header) {
        Set<HttpCookie> cookies = new HashSet<HttpCookie>();
        String[] split = header.split(semicolon);
        for (String s : split) {
            String[] cookie = s.split(equals);
            if(cookie != null && cookie.length == 2) {
                cookies.add(new HttpCookie(cookie[0].trim(), cookie[1].trim()));
            }
        }
        return cookies;
    }
}