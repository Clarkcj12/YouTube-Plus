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

import com.domnian.mcutils.TaskChain;
import com.domnian.mcutils.Util;
import org.json.JSONObject;
import us.mcthemeparks.socialplus.SocialPlus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class StreamChecker implements Runnable {

    HashMap<StreamService, List<String>> wentLive = new HashMap<>();

    @Override
    public void run() {
        TaskChain.newSharedChain("StreamChecker")
                .async(this::callTwitch)
                .async(this::callLivecode)
                .async(this::callBeam)
                .async(this::callHitbox)
                .async(this::callGoogle)
                .async(this::callUstream)
                .sync(() -> {

                })
                .execute();
    }

    private TaskChain.GenericTask callLivecode() {
        return () -> {};
    }

    private TaskChain.GenericTask callBeam() {
        return () -> {};
    }

    private TaskChain.GenericTask callHitbox() {
        return () -> {};
    }

    private TaskChain.GenericTask callGoogle() {
        return () -> {};
    }

    private TaskChain.GenericTask callUstream() {
        return () -> {};
    }

    private TaskChain.GenericTask callTwitch() {
        return () -> {
            List<String> streamers = SocialPlus.getInstance().getConfig().getStringList("streamers.twitch");
            HashMap<String, JSONObject> info = new HashMap<>();
            streamers.forEach((name) -> {
                try {
                    URL url = new URL("https://api.twitch.tv/kraken/streams/" + name);
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                        info.put(name, new JSONObject(reader.readLine()));
                    }
                } catch (Exception e) {
                    Util.printException("Error With Contacting Twitch API", e);
                }
            });
            info.forEach((name, json) -> {
                boolean isStreaming = false;
                if (json.has("stream")) {
                    if (json.getJSONObject("stream").has("_id")) { // Streamer is online
                        //TODO Do Something
                    } else if (json.getJSONObject("stream") == null) { // Streamer is offline
                        //TODO Do Something
                    }
                } else {
                    Util.log("Unable to Parse Twitch Stream Data for " + name);
                }
            });
        };
    }
}