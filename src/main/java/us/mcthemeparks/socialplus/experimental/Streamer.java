/*
 * ==================================================================
 * Copyright Domnian Dev. (c) 2015. All Rights Reserved
 * Any Code contained within this document, and any associated APIs
 * with similar branding are the sole property of Domnian Dev..
 * Distribution, reproduction, taking snippets, or claiming any
 * contents as your own will break the terms of the license, and
 * void any agreements with you, the third party. Thanks
 * ==================================================================
 */
package us.mcthemeparks.socialplus.experimental;

public class Streamer {

    String name;
    StreamService service;

    public Streamer(String name, StreamService service) {
        this.name = name;
        this.service = service;
    }
}