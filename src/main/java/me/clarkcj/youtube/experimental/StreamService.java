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
package me.clarkcj.youtube.experimental;

public enum StreamService {

    TWITCH("https://twitch.tv/"),
    LIVECODING("https://livecoding.tv/"),
    BEAM("https://beam.pro"),
    HITBOX("https://hitbox.tv/"),
    GOOGLE("https://youtu.be/"),
    USTREAM("http://ustream.tv/");

    String rootLink;

    StreamService(String link) {
        rootLink = link;
    }

}